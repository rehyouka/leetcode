package org.rehyouka.leetcode.gpt;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机选取基准值 => pivot基准值选取 => 极端情况下选到 很大或者很小的值
 *
 * @author william
 * @since 2026/8/28
 */
public class QuickSorter2 implements Sorter {
    @Override
    public void doSort(int[] arr) {
        this.doSort0(arr, 0, arr.length - 1);
    }

    private void doSort0(int[] nums, int idxLf, int idxRt) {
        if (idxLf >= idxRt) {
            return;
        }
        int idxPivot = this.partition(nums, idxLf, idxRt);
        this.doSort0(nums, idxLf, idxPivot - 1);
        this.doSort0(nums, idxPivot + 1, idxRt);
    }

    private int partition(int[] nums, int idxLf, int idxRt) {
        int pivot = nums[ThreadLocalRandom.current().nextInt(idxLf, idxRt+1)];
        int i = idxLf;
        for (int j = idxLf; j < idxRt; j++) {
            if (nums[j] <= pivot) {
                this.swap(nums, i, j);
                i++;
            }
        }
        this.swap(nums, i, idxRt);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 1, 3};
        new QuickSorter().exe(nums);
    }
}
