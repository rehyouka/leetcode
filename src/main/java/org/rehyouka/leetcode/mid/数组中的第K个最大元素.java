package org.rehyouka.leetcode.mid;

import java.util.Arrays;

/**
 * @author william
 * @since 2026/8/28
 */
class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        数组中的第K个最大元素 m = new 数组中的第K个最大元素();
        m.exe(new int[]{ 3,2,1,5,6,4 }, 2);
        m.exe(new int[]{ 3,2,3,1,2,4,5,5,6 }, 4);
    }

    void exe(int[] nums, int k) {
        int kthLargest = this.findKthLargest(nums, k);
        System.out.println(Arrays.toString(nums) + " => " + kthLargest);
    }
}
