package org.wangbiao.leetcode;

import java.util.Stack;

/**
 * Leet Code Algorithm Problem 20: Valid Parentheses
 *
 * Description: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses/"><a/>
 */
public class $20ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null || (s.length() & 1) != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isFront(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != getFront(ch)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isFront(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static char getFront(char ch) {
        switch (ch) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default:
                return ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }
}
