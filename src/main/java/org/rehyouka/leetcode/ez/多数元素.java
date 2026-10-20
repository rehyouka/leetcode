package org.rehyouka.leetcode.ez;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author william
 * @since 2026/10/20
 */
class 多数元素 {
    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
     * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -10^9 <= nums[i] <= 10^9
     * 输入保证数组中一定有一个多数元素。
     */
    public static void main(String[] args) {
        多数元素 m = new 多数元素();
        m.exe(3, new int[]{ 3,2,3 });
        m.exe(2, new int[]{ 2,2,1,1,1,2,2 });
    }
    void exe(int expected, int[] nums) {
        int actual = this.majorityElement(nums);
        PrintStream s = expected == actual ? System.out : System.err;
        s.println(Arrays.toString(nums) + "; expected=" + expected + "; actual=" + actual);
    }

/*
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int val = 0, b = nums.length/2;
        for (int num : nums) {
            val = map.getOrDefault(num, 0);
            if (++val > b) { return num; }
            map.put(num, val);
        }
        return 0;
    }
*/

/*
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums[0], c = 1, b = nums.length/2;
        for (int i = 1; i < nums.length; i++) {
            if (n == nums[i]) { if (++c > b) { return n; } }
            else {
                n = nums[i];
                c = 1;
            }
        }
        return n;
    }
*/

    // Boyer–Moore 投票算法
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
