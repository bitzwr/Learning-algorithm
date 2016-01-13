package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/13.
 */
public class Selection {

    public static void main(String[] args) {
        int[] arr = new int[] {9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 选择排序: 每次从待排序的数组元素中选出最小(或最大)的元素存放在
     * 序列的起始位置,直到全部待排序的元素排完.
     *
     * @param arr 待排序数组
     * @return 排序后的数组
     */
    public static int[] sort(int[] arr) {
        int minIndex; // 记录最小值的索引
        for (int i = 0; i < arr.length; i++) {
            minIndex = i; // 从i开始为待排序序列,并把i作为默认的最小值
            // 从待排序序列中找出最小值,并记录索引
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 如果该次循环不为i,则交换
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }


}
