package org.rehyouka.leetcode.mid;

/**
 * @author william
 * @since 2026/9/13
 */
class 打家劫舍 {
    public static void main(String[] args) {
        打家劫舍 m = new 打家劫舍();
        m.exe(4, new int[]{ 1,2,3,1 });
        m.exe(12, new int[]{ 2,7,9,3,1 });
    }
/*
    public int rob(int[] nums) {
        return this.dp(nums, nums.length-1, new int[nums.length]);
    }

    int dp(int[] nums, int bound, int[] backup) {
        if (bound < 0) { return 0; }
        if (backup[bound] != 0) { return backup[bound]; }
        backup[bound] =  Math.max(this.dp(nums,  bound-2, backup) + nums[bound], this.dp(nums, bound-1, backup));
        return backup[bound];
    }
*/

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int stp2 = nums[0];//dp[i-2]上上动的最大收益
        int stp1 = Math.max(nums[0], nums[1]);//dp[i-1]上一栋的最大收益
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(stp1, stp2 + nums[i]);//核心方程，偷或不偷
            stp2 = stp1;//状态回滚
            stp1 = cur;
        }
        return stp1;
    }

    void exe(int expected, int[] nums) {
        int actual = this.rob(nums);
        if (actual != expected) {
            throw new IllegalStateException();
        }
    }
}
