package org.rehyouka.leetcode.hard;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author william
 * @since 2026/10/1
 */
class 存在重复元素III {
    /**
     * 220：
     * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
     * 找出满足下述条件的下标对 (i, j)：
     * i != j,
     * abs(i - j) <= indexDiff
     * abs(nums[i] - nums[j]) <= valueDiff
     * 如果存在，返回 true ；否则，返回 false
     *
     * 2 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     * 1 <= indexDiff <= nums.length
     * 0 <= valueDiff <= 10^9
     */
    public static void main(String[] args) {
        存在重复元素III m = new 存在重复元素III();
        m.exe(true, new int[]{ 1,2,3,1 }, 3, 0);
        m.exe(false, new int[]{ 1,5,9,1,5,9 }, 2, 3);
        m.exe(false, new int[]{ 3, -3 }, 2, 4);
    }

    void exe(boolean expected, int[] nums, int indexDiff, int valueDiff) {
        boolean actual = this.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        PrintStream s = expected == actual ? System.out : System.err;
        s.println("nums=" + Arrays.toString(nums) + "; indexDiff=" + indexDiff + "; valueDiff=" + valueDiff +
                "; expected=" + expected + "; actual=" + actual);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (Math.abs(nums[0]-nums[1]) <= valueDiff) { return true; }

        TreeSet<Integer> aSet = new TreeSet<>();
        aSet.add(nums[0]);
        aSet.add(nums[1]);

        Integer jValue = null;
        int bound = Math.min(indexDiff+1, nums.length);
        for (int i = 2; i < bound; i++) {
            // ∣nums[i]−y∣ ≤ valueDiff --> −valueDiff ≤ nums[i]−y ≤ valueDiff --> nums[i]−valueDiff ≤ y ≤ nums[i]+valueDiff
            jValue = aSet.ceiling(nums[i]-valueDiff);
            if (jValue != null && jValue <= nums[i]+valueDiff) { return true; }
            aSet.add(nums[i]);
        }

        bound = nums.length;
        for (int i = 0, j = indexDiff+1; j < bound; i++, j++) {
            aSet.remove(nums[i]);
            jValue = aSet.ceiling(nums[j] - valueDiff);
            if (jValue != null && jValue <= nums[j]+valueDiff) { return true; }
            aSet.add(nums[j]);
        }

        return false;
    }
}
