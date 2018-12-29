package org.wangbiao.leetcode;


/**
 * Leet Code Algorithm Problem 28: Implement strStr()
 *
 * Description: mplement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * @see <a href="https://leetcode.com/problems/implement-strstr/"><a/>
 */
public class $28ImplementstrStr {

    // 用KMP算法查找
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        // 竟然会有 "" 空串这个用例，而且需要返回0；
        // 说明里有提到，每一次提交没注意，String的indexOf("")返回的也是0；
        if (m == 0) {
            return 0;
        }
        int[] prefix = getPrefix(needle);
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = prefix[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] getPrefix(String needle) {
        int len = needle.length();
        int[] prefix = new int[len];
        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = prefix[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            prefix[i] = j;
        }
        return prefix;
    }


    public static void main(String[] args) {
        System.out.println("aa".indexOf(""));
        System.out.println(strStr("a", ""));
    }
}
