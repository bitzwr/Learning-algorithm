package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/29.
 */
public class Counting {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        System.out.println(Arrays.toString(sort(arr, 10)));
    }

    /**
     * 计数排序: 对每一个输入元素x, 确定小于x的元素的个数.
     * 这样可以直接把x放到它在数组中的位置上
     *
     * @param arr 待排序数组
     * @param k   待排序数组数值上限
     */
    public static int[] sort(int[] arr, int k) {
        int N = arr.length;
        int[] sorted = new int[N]; // 存放排好序的序列
        int[] temp = new int[k]; // 临时存储空间, 初始值都为0
        for (int i = 0; i < N; i++) {
            temp[arr[i]] = temp[arr[i]] + 1;
        }
        for (int i = 1; i < k; ++i) {
            temp[i] = temp[i] + temp[i - 1];
        }
        for (int i = N - 1; i >= 0; --i) {
            sorted[temp[arr[i]] - 1] = arr[i];
            temp[arr[i]] = temp[arr[i]] - 1;
        }
        return sorted;
    }
}
