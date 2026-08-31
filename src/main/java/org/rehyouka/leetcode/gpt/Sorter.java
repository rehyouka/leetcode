package org.rehyouka.leetcode.gpt;

import java.util.Arrays;

/**
 * @author william
 * @since 2026/8/28
 */
public interface Sorter {
    void doSort(int[] arr);
    default void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        this.doSort(arr);
    }
    default void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    default void exe(int[] arr) {
        String arrayUnsorted = Arrays.toString(arr);
        this.sort(arr);
        String arraySorted = Arrays.toString(arr);
        System.out.println(arrayUnsorted + " => " + arraySorted);
    }
}
