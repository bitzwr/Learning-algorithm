package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/14.
 */
public class Shell {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 希尔排序: 一种基于插入排序的快速的排序算法, 思想是使数组中任意
     * 间隔为h的元素都是有序的.
     *
     * @param arr 待排序数组
     * @return 排序后数组
     */
    public static int[] sort(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                int key = arr[i];
                int j = i - h;
                while (j >= 0 && arr[j] > key) {
                    arr[j + h] = arr[j];
                    j -= h;
                }
                arr[j + h] = key;
            }
            h /= 3;
        }
        return arr;
    }
}
