package org.wangbiao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Leet Code Algorithm Problem 3:
 *
 * Description: Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *   Input: "abcabcbb"
 *   Output: 3
 *   Explanation: The answer is "abc", with the length of 3.
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/"><a/>
 */
public class $3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int n = s.length(), result = 0;
        int i = 0, j = 0; // 两个指针
        while (i < n && j < n) {
            // 1.遍历s的字符，如是不重复就移动j向后走一位
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i); // 3.j和i的距离就是不重复子串的长度；取最大值
            } else {
                // 2.否则就移动i向后走一位，直到把跟j重复的项移除掉
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }
}
