package org.wangbiao.leetcode;

import java.util.Arrays;

/**
 * Leet Code Algorithm Problem 4:
 *
 * Description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *  nums1 = [1, 3]
 *  nums2 = [2]
 *  The median is 2.0
 *
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/"><a/>
 */
public class $4MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int len1 = nums1.length, len2 = nums2.length;
        int midIdx = total / 2;
        int[] arr = new int[total];
        int i = 0, j = 0, idx = 0;
        while ((i < len1 || j < len2) && idx <= midIdx) { // 合并数组
            if (i == len1) {
                arr[idx++] = nums2[j++];
                continue;
            }
            if (j == len2) {
                arr[idx++] = nums1[i++];
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                arr[idx++] = nums1[i++];
            } else {
                arr[idx++] = nums2[j++];
            }
        }
        // 取中值
        if ((total & 1) == 1) {
            return arr[midIdx] / 1.0d;
        } else {
            return (arr[midIdx - 1] + arr[midIdx]) / 2.0d;
        }
    }


    public static void main(String[] args) {
        int[] array = mergeTwoArray(new int[]{1, 3, 5, 8, 9}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(array));
        double v = findMedianSortedArrays(new int[]{1, 3, 5, 8, 9}, new int[]{2, 4, 6});
        System.out.println(v);
    }


    public static int[] mergeTwoArray(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int len1 = nums1.length, len2 = nums2.length;
        int[] arr = new int[total];
        int i = 0, j = 0, idx = 0;
        while (i < len1 || j < len2) {
            if (i == len1) {
                arr[idx++] = nums2[j++];
                continue;
            }
            if (j == len2) {
                arr[idx++] = nums1[i++];
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                arr[idx++] = nums1[i++];
            } else {
                arr[idx++] = nums2[j++];
            }
        }
        return arr;
    }
}
