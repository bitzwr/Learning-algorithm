package org.wangbiao.algo.stringmatch;

/**
 * 朴素字符串匹配算法。
 */
public class NaiveStringMatcher {

    /**
     *
     * @param T text
     * @param P pattern
     * @return 匹配到text中第一个pattern的索引,没有的话返回-1
     */
    public static int match(String T, String P) {
        int n = T.length();
        int m = P.length();
        for (int i = 0; i < n - m; i++) {
            // 对比T[i, i + m - 1] 和 P 是否匹配
            for (int j = 0; j < m; j++) {
                if (T.charAt(i + j) != P.charAt(j)) {
                    break;
                }
                if (j == m - 1) { // 为true 说明每一位都对比过了
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int match = match("qafadfadfafabcababca", "abcab");
        System.out.println(match);
    }
}
