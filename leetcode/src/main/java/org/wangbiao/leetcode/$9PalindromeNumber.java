package org.wangbiao.leetcode;

/**
 * Leet Code Algorithm Problem 9:
 *
 * Description: Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *  Input: 121
 *  Output: true
 *
 * Example 2:
 *  Input: -121
 *  Output: false
 *
 * @see <a href="https://leetcode.com/problems/palindrome-number/"><a/>
 */
public class $9PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        String temp = String.valueOf(x);
        int len = temp.length();
        int loop = len / 2;
        for (int i = 0; i < loop; i++) {
            if (temp.charAt(i) != temp.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int num = 0;
        while (x > num) { // 数字翻转
            num =  num * 10 + x % 10;
            x /= 10;
        }
        return x == num || x == num / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(2147483639));
    }
}
