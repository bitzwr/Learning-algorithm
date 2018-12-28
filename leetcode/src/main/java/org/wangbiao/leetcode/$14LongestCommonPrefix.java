package org.wangbiao.leetcode;


/**
 * Leet Code Algorithm Problem 14:
 *
 * Description: Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/"><a/>
 */
public class $14LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if ("".equals(prefix)) {
                return "";
            }
            prefix = getLongestCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    public static String getLongestCommonPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
