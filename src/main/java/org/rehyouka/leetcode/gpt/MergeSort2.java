package org.rehyouka.leetcode.gpt;

/**
 * @author william
 * @since 2026/8/31
 */
public class MergeSort2 implements Sorter {
    @Override
    public void doSort(int[] arr) {
        int[] tmp = new int[arr.length];
        this.mergerSort(arr, tmp, 0, arr.length-1);
    }
    void mergerSort(int[] arr, int[] tmp, int idxLf, int idxRt) {
        if (idxLf>=idxRt) { return; }
        int idxMd = idxLf + (idxRt-idxLf)/2;
        this.mergerSort(arr, tmp, idxLf, idxMd);
        this.mergerSort(arr, tmp, idxMd+1, idxRt);
        this.merge(arr, tmp, idxLf, idxMd, idxRt);
    }
    void merge(int[] arr, int[] tmp, int idxLf, int idxMd, int idxRt) {
        int il = idxLf, ir = idxMd+1, it = idxLf;
        while(il<=idxMd && ir<=idxRt) {
            if (arr[il]<=arr[ir]) { tmp[it++]=arr[il++]; }
            else { tmp[it++]=arr[ir++]; }
        }
        while(il<=idxMd) { tmp[it++]=arr[il++]; }
        while(ir<=idxRt) { tmp[it++]=arr[ir++]; }
        for (int i = idxLf; i <= idxRt; i ++) { arr[i] = tmp[i]; }
    }
    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 1, 3};
        new MergeSort2().exe(nums);
    }
}
