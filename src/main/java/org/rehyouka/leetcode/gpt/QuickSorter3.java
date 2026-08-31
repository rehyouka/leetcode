package org.rehyouka.leetcode.gpt;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 三区partition => 大量重复的元素
 *
 * @author william
 * @since 2026/8/28
 */
public class QuickSorter3 implements Sorter {
    @Override
    public void doSort(int[] arr) {
        this.quickSort(arr, 0, arr.length - 1);
    }

    void quickSort(int[] arr, int idxLf, int idxRt) {
        if (idxLf >= idxRt) { return; }

        int pivotIdx = ThreadLocalRandom.current().nextInt(idxLf, idxRt+1);
        int pivot = arr[pivotIdx];

        int il = idxLf, i = idxLf, ir = idxRt;
        // Q: 为什么要=?
        // A: 每个元素都要 比较与pivot的相对大小
        while(i <= ir) {
            if (arr[i]<pivot) {
                this.swap(arr, i, il);
                il++;
                i++;
            }
            else if(arr[i]>pivot) {
                this.swap(arr, i, ir);
                ir--;
                // Q: 为什么这里不 i++?
                // A: 交换后的元素 还没有比较过与pivot的相对大小，需要经过一轮if-else-if-else
            } else {
                i++;
            }
        }

        this.quickSort(arr, idxLf, il-1);
        this.quickSort(arr, ir+1, idxRt);
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 1, 3};
        new QuickSorter().exe(nums);
    }
}
