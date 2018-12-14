package org.wangbiao.leetcode;

/**
 * Leet Code Algorithm Problem 7:
 *
 * Description: Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *  Input: 123
 *  Output: 321
 *
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/"><a/>
 */
public class $7ReverseInteger {

    /**
     * 取巧的方法，正经的方法应该是使用模除得到每一位的数字，再翻转
     */
    public static int reverse(int x) {
        // -2147483648 翻转后溢出，直接特殊处理
        if (x == Integer.MIN_VALUE) {
            x = 0;
        }
        boolean positive = x >= 0;
        String temp = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder();
        int length = temp.length();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(temp.charAt(i));
        }
        long result = Long.valueOf(sb.toString());
        if (result > Integer.MAX_VALUE) {
            return 0;
        } else {
            return positive ? (int) result : -(int) result;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
