package org.rehyouka.leetcode.gpt;

/**
 * @author william
 * @since 2026/8/30
 */
public class MergeSort implements Sorter {
    @Override
    public void doSort(int[] arr) {
        this.mergeSort(arr, 0, arr.length-1);
    }
    private void mergeSort(int[] arr, int idxLf, int idxRt) {
        if (idxLf >= idxRt) { return; }
        int idxMd = idxLf + (idxRt-idxLf)/2;
        this.mergeSort(arr, idxLf, idxMd);
        this.mergeSort(arr, idxMd+1, idxRt);
        this.merge(arr, idxLf, idxMd, idxRt);
    }
    private void merge(int[] arr, int idxLf, int idxMd, int idxRt) {
        int[] tmp = new int[idxRt-idxLf+1];
        int il = idxLf, ir = idxMd+1, it = 0;
        while(il <= idxMd && ir <= idxRt) {
            if (arr[il] <= arr[ir]) {
                tmp[it++] = arr[il++];
            } else {
                tmp[it++] = arr[ir++];
            }
        }
        while(il<=idxMd) { tmp[it++] = arr[il++]; }
        while(ir<=idxRt) { tmp[it++] = arr[ir++]; }
        for (int i = 0; i < tmp.length; i++) {
            arr[idxLf+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 1, 3};
        new MergeSort().exe(nums);
    }
}
