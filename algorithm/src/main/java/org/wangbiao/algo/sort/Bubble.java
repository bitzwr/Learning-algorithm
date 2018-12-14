package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/13.
 */
public class Bubble {

    public static void main(String[] args) {
        int[] arr = new int[] {9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 冒泡排序: 比较相邻元素的大小
     * @param arr 待排序数组
     * @return 排序后的数组
     */
    public static int[] sort(int[] arr) {
        boolean isSorted = false;
        for(int i = arr.length - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    isSorted = false;
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
        }
        return arr;
    }
}
