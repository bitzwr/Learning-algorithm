package org.wangbiao.algo.stringmatch;

/**
 * Knuth-Morris-Pratt 字符串匹配算法.
 *
 *
 */
public class KMPMatcher {

    /**
     *
     * @param T text
     * @param P pattern
     * @return 匹配到text中第一个pattern的索引,没有的话返回-1
     */
    public static int match(String T, String P) {
        int n = T.length();
        int m = P.length();
        int[] prefix = computePrefixArray(P);
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = prefix[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /* KMP 核心思想就是提前计算出前辍函数，而前辍函数只于自身相关。
     *
     * 局部匹配表：
     * pattern: abababca
     * index:   01234567
     * value:   00123401
     *
     * 前辍：除了最后一个字符外，一个字符串的全部头部组合；
     * 后辍：除了第一个字符外，一个字符串全部尾部组合；
     *
     * 举例："good"
     * 前辍：g, go, goo
     * 后辍：ood, od, d
     *
     * 局部匹配表中的值就是前辍和后辍的最长的共有原素的长度。
     *
     * 以abababca为例：
     * - "a" 前辍和后辍都是空集，共有元素长度为0；
     * - "ab" 前辍为[a]，后辍为[b], 共有元素长度为0；
     * - "aba" 前辍为[a, ab]，后辍为[ba, a]，共有原素长度为1；
     * - "abab" 前辍为[a, ab, aba]，后辍为[bab, ab, b]，共有原素长度为2；
     * - "ababa" 前辍为[a, ab, aba, abab]，后辍为[baba, aba, ba, a]，共有原素最长长度为3；
     * - "ababab" 前辍为[a, ab, aba, abab, ababa]，后辍为[babab, abab, bab, ab, b]， 共有原素最长长度为4;
     * - "abababc" 前辍为[a, ab, aba, abab, ababa, ababab]，后辍为[bababc, ababc, babc, abc, bc, c]，共有原素长度为0；
     * - "abababca" 前辍为[a, ab, aba, abab, ababa, ababab, abababc]，后辍为[bababca, ababca, babca, abca, bca, ca, a]，共有原素长度为1；
     *
     * 以上，与上边的局部匹配表中的值相符合。
     *
     *       |
     * bbababnbcafaabababcabaca
     *   abababca
     *       |
     *     abababca
     * 字符串的长度-局部匹配值; 第一个ab向后移动2位就是下次比对开始的位置。
     */
    public static int[] computePrefixArray(String P) {
        int m = P.length();
        int[] prefix = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && P.charAt(j) != P.charAt(i)) {
                j = prefix[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }
        return prefix;
    }

    public static void main(String[] args) {
        int match = match("bbabababcafaabababcabaca", "abababca");
        System.out.println(match);
    }

}
