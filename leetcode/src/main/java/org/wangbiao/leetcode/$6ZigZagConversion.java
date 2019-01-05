package org.wangbiao.leetcode;

/**
 * Leet Code Algorithm Problem 6:
 *
 * Description: The string "PAYPALISHIRING" is written in a zigzag pattern on
 * a given number of rows like this:(you may want to display this pattern in
 * a fixed font for better legibility)
 *
 * Example 1:
 *  Input: s = "PAYPALISHIRING", numRows = 3
 *  Output:PAHNAPLSIIGYIR
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *
 *  Example 2:
 *  Input: s = "PAYPALISHIRING", numRows = 4
 *  Output:PINALSIGYAHRPI
 *  P     I    N
 *  A   L S  I G
 *  Y A   H R
 *  P     I
 *
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/"><a/>
 */
public class $6ZigZagConversion {

    public static String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] lines = new StringBuilder[numRows];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new StringBuilder();
        }
        int x = 0, y = 0, i = 0;
        boolean direction = true;
        while (i < len && (y >=0 || y < numRows)) {
            lines[y].append(s.charAt(i++));
            if (direction) {
                y++;
            } else {
                y--;
                x++;
            }
            if (y == 0 || y == numRows -1) {
                direction = !direction;
            }
        }
        for (int k = 1; k < numRows; k++) {
            lines[0].append(lines[k]);
        }
        return lines[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("ABcdef", 2));
    }
}
