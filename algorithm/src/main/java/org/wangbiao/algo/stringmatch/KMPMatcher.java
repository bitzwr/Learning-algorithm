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
     * pattern: abababca
     * index:   01234567
     * value:   00123401
     *
     * 前辍：
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
        int match = match("afaabababcabaca", "abababca");
        System.out.println(match);
    }

}
