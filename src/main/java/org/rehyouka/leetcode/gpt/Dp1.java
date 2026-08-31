package org.rehyouka.leetcode.gpt;

/**
 * @author william
 * @since 2026/8/25
 */
public class Dp1 {
    int algorithm(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int i = 1;
        int max = dp[0];
        for (; i < nums.length; i++) {
            dp[i] = Math.max( nums[i], nums[i]+dp[i-1] );
            max = Math.max( max, dp[i] );
        }
        return max;
    }

    public static void main(String[] args) {
        Dp1 m = new Dp1();
        System.out.println(m.algorithm(new int[]{ -2,1,-3,4,-1,2,1,-5,4 }));
    }
}
