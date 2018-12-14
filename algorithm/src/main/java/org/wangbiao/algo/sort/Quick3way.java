package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/16.
 */
public class Quick3way {

    public static void main(String[] args) {
        int[] arr = new int[] {9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 三向切分快速排序: 改良的快速排序
     */
    public static void sort(int[] arr, int low, int high) {
        if(high <= low) {
            return;
        }
        int lt = low, i = low + 1, gt = high;
        int v = arr[low];
        int temp;
        while (i <= gt) {
            if(arr[i] < v) {
                temp = arr[i];
                arr[i] = arr[lt];
                arr[lt] = temp;
                i++;
                lt++;
            } else if (arr[i] > 0) {
                temp = arr[i];
                arr[i] = arr[gt];
                arr[gt] = temp;
                gt--;
            } else {
                i++;
            }
        } // 现在 arr[low, lt - 1] < v = arr[lt, gt] < arr[gt + 1, high] 成立.
        sort(arr, low, lt - 1);
        sort(arr, gt + 1, high);
    }
}
