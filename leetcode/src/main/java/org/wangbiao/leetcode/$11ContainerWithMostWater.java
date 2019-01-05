package org.wangbiao.leetcode;

/**
 * Leet Code Algorithm Problem 11: Container With Most Water
 *
 * Description: Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 * 9
 * 8     |              |
 * 7     |              |     |
 * 6     |  |           |     |
 * 5     |  |     |     |     |
 * 4     |  |     |  |  |     |
 * 3     |  |     |  |  |  |  |
 * 2     |  |  |  |  |  |  |  |
 * 1  |  |  |  |  |  |  |  |  |
 * 0  1  2  3  4  5  6  7  8  9
 *
 * * @see <a href="https://leetcode.com/problems/container-with-most-water/"><a/>
 */
public class $11ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
