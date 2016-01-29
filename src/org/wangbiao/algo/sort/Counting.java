package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/29.
 */
public class Counting {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        System.out.println(Arrays.toString(sort(arr, 8)));
    }

    public static int[] sort(int[] arr, int k) {
        int N = arr.length;
        int[] b = new int[N]; // 存放排序
        int[] c = new int[k]; // 临时存储空间
        for (int i = 0; i < N; i++) {
            c[arr[i]] = c[arr[i]] + 1;
        }
        for (int i = 1; i < k; i++) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = N - 1; i > 0; i--) {
            b[c[arr[i]]] = arr[i];
            c[arr[i]] = c[arr[i]] - 1;
        }
        return b;
    }
}
