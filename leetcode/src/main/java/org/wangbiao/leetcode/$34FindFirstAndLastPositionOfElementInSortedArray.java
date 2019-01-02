package org.wangbiao.leetcode;

import java.util.Arrays;

/**
 * Leet Code Algorithm Problem 34: Find First and Last Position of Element in Sorted Array
 *
 * Description: Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/"><a/>
 */
public class $34FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{ -1, -1};
        boolean first = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (!first) {
                    result[0] = i;
                    result[1] = i;
                    first = true;
                } else {
                    result[1] = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }
}
