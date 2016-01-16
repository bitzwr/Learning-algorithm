package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/15.
 */
public class Merge {

    private static int[] aux; // 归并排序所需的辅助数组

    public static void main(String[] args) {
        int[] arr = new int[]{9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        // 一次性初始化辅助空间
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序: 将两个有序的数组归并成一个更大的有序数组.
     * 递归地将待排序数组分成两半分别排序,然后再将结果归并起来.
     */
    private static void sort(int[] arr, int low, int high) {
        if(high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    /**
     * 将数组arr[low, mid] 和arr[mid + 1, high] 合并.
     */
    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        // 将a[low, high] 复制到辅助数组aux[low, high]中
        for(int k = low; k <= high; k++) {
            aux[k] = arr[k];
        }
        // 归并回到arr[low, high]
        for(int k = low; k <= high; k++) {
            if (i > mid) { // 左半边元素已经被取完
                arr[k] = aux[j++];
            } else if (j > high) { // 右半边元素被取完
                arr[k] = aux[i++];
            }
            // 比较左右两边当前位置元素的大小, 较小的直接取回, 较大的下次继续比较
            else if(aux[j] < aux[i]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }
}
