package org.wangbiao.leetcode;


/**
 * Leet Code Algorithm Problem 35: Search Insert Position
 *
 * Description: Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/"><a/>
 */
public class $35SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = len - 1; i >= 1; i--) {
            if (target <= nums[i] && target > nums[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }
}
