package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/13.
 */
public class Quick {

    public static void main(String[] args) {
        int[] arr = new int[] {9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        System.out.println(Arrays.toString(sort(arr, 0, arr.length - 1)));
    }

    /**
     * 快速排序: 快速排序是一种分治的排序算法.
     *
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     * @return 排序后数组
     */
    public static int[] sort(int[] arr, int left, int right) {
        int i = left; // 左右扫描指针
        int j = right;
        int key = arr[left]; // 切分元素

        do {
            while ((arr[i] < key) && (i < right)) {
                i++;
            }
            while ((key < arr[j]) && (j > left)) {
                j--;
            }

            if(i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if(left < j) {
            sort(arr, left, j);
        }
        if(i < right) {
            sort(arr, i, right);
        }

        return arr;
    }
}
