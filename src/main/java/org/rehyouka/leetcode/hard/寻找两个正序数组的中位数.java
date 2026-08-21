package org.rehyouka.leetcode.hard;

import java.util.Arrays;

/**
 * @author william
 * @since 2026/8/20
 */
public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] result = new int[length];
        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);

        Arrays.sort(result);

        int midIdx = length / 2;
        return length % 2 == 0 ? (result[midIdx] + result[midIdx - 1]) / 2.0 : result[midIdx];

    }
}
