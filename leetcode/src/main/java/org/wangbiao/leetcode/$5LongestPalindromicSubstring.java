package org.wangbiao.leetcode;

/**
 * Leet Code Algorithm Problem 5:
 *
 * Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *  Input: "babad"
 *  Output: "bab"
 *  Note: "aba" is also a valid answer.
 *
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/"><a/>
 */
public class $5LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() == 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1))) {
            return s;
        }
        int len = s.length();
        boolean[][] status = new boolean[len][len];
        int maxLen = 0; // 最长长度
        int from = 0, to = 0; // 记录到达最长长度时的位置
        for (int i = 0; i < len; i++) {
            status[i][i] = true; // 一个元素是回文
            for (int j = i; j >=0 ; j--) {
                // 如果chars[i]==chars[j]并且长度小于等于2时，肯定是回文,如aa；
                // 如果长度大于2，就对称位置
                status[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || j >= 0 && status[j + 1][i - 1]));
                if (status[j][i]) {
                    if (i - j + 1 > maxLen) {
                        from = j;
                        to = i + 1;
                        maxLen = i - j + 1;
                    }
                }
            }
        }
        return s.substring(from, to);
    }

    public static void main(String[] args) {
        String babad = longestPalindrome("aaaa");
        System.out.println(babad);
    }
}
