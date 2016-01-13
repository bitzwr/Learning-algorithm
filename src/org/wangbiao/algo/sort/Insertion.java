package org.wangbiao.algo.sort;

import java.util.Arrays;

/**
 * Created by Wang Biao on 16/1/13.
 */
public class Insertion {

    public static void main(String[] args) {
        int[] arr = new int[] {9, 0, 2, 3, 8, 1, 4, 5, 7, 6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    /**
     * 插入排序: 遍历已排序序列, 找到待排序元素key的位置, 并插入.
     *
     * 如下是<算法导论>中插入排序算法的伪代码.
     * <p>
     * INSERTION-SORT(A)
     *   for i ← 2 to length[A]
     *     do key ← A[i]
     *       △ Insert A[i] into the sorted sequence A[1..i-1].
     *       j ← i - 1
     *       while j > 0 and A[j] > key
     *         do A[j + 1] ← A[j]
     *           j ← j -1
     *       A[j + 1] ← key
     * </p>
     *
     * @param arr 待排序数组
     * @return 排序后数组
     */
    public static int[] sort(int[] arr) {
        // [i,..) 为待排序序列
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // 本次循环被排序的元素
            int j = i - 1; // 已排序序列最后一个位置
            // [0, j]为已排序序列, 循环确定key值的位置, 并比key值大的依次后移
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 循环结束后, j + 1 就是key的位置
            arr[j + 1] = key;
        }
        return arr;
    }
}
