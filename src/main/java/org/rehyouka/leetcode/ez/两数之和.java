package org.rehyouka.leetcode.ez;

import java.util.Arrays;

/**
 * @author william
 * @since 2026/8/17
 * @link https://leetcode.cn/problems/two-sum/description/
 */
public class 两数之和 {
    public static void main(String[] args) {
        两数之和 m = new 两数之和();

        int[] nums = new int[]{ 2, 7, 11, 15 };
        System.out.println(Arrays.toString(m.twoSum(nums, 9)));

        nums = new int[]{ 3,2,4 };
        System.out.println(Arrays.toString(m.twoSum(nums, 6)));

        nums = new int[]{ 3,3 };
        System.out.println(Arrays.toString(m.twoSum(nums, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}