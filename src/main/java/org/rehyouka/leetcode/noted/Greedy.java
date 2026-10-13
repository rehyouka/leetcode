package org.rehyouka.leetcode.noted;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * @author william
 * @since 2026/10/6
 */
class Greedy {
    static class LC55 {
        /**
         * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
         *
         * 1 <= nums.length <= 10^4
         * 0 <= nums[i] <= 10^5
         */
        public static void main(String[] args) {
            LC55 m = new LC55();
            m.exe(true, new int[]{ 2,3,1,1,4 });
            m.exe(false, new int[]{ 3,2,1,0,4 });
        }
        void exe(boolean expected, int[] nums) {
            boolean actual = this.canJump(nums);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println("nums=" + Arrays.toString(nums) + "; expected=" + expected + "; actual=" + actual);
        }
        public boolean canJump(int[] nums) {
            if (nums.length == 1) { return true; }
            int max = nums[0];
            for (int i = 1, v = 0; i <= max; i++) {
                v = i+nums[i];
                if (v >= nums.length-1) { return true; }
                max = Math.max(max, v);
            }
            return false;
        }
    }

    static class LC45 {
        /**
         * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
         * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
         * 0 <= j <= nums[i] 且
         * i + j < n
         * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
         *
         * 1 <= nums.length <= 10^4
         * 0 <= nums[i] <= 1000
         * 题目保证可以到达 n - 1
         */
        public static void main(String[] args) {
            LC45 m = new LC45();
            m.exe(2, new int[]{ 2,3,1,1,4 });
            m.exe(2, new int[]{ 2,3,0,1,4 });
            m.exe(1, new int[]{ 1,2 });
            m.exe(1, new int[]{ 2,1 });
            m.exe(0, new int[]{ 0 });
        }
        void exe(int expected, int[] nums) {
            int actual = this.jump(nums);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println("nums=" + Arrays.toString(nums) + "; expected=" + expected + "; actual=" + actual);
        }
/*
        public int jump(int[] nums) {
            if (nums.length == 1) { return 0; }
            int steps = 0, boundary = 0;
            for (int i = 0, v = 0, b = 0; i <= boundary; i++) {
                v = i+nums[i];
                if (v >= nums.length-1) { return steps+1; }
                b = Math.max(b, v);
                if (i == boundary) {
                    boundary = b;
                    steps++;
                }
            }
            return steps;
        }
*/
        public int jump(int[] nums) {
            int max = 0, end = 0, steps = 0;
            for (int i = 0; i < nums.length-1; i++) {
                max = Math.max(max, i+nums[i]);
                if (i == end) {
                    end = max;
                    steps++;
                }
            }
            return steps;
        }
    }

    static class LC435 {
        /**
         * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
         * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
         * 注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。
         *
         * 1 <= intervals.length <= 10^5
         * intervals[i].length == 2
         * -5 * 10^4 <= start_i < end_i <= 5 * 10^4
         */
        public static void main(String[] args) {
            LC435 m = new LC435();
            m.exe(1, new int[][]{ {1,2},{2,3},{3,4},{1,3} });
            m.exe(2, new int[][]{ {1,2},{1,2},{1,2} });
            m.exe(0, new int[][]{ {1,2},{2,3} });
        }
        void exe(int expected, int[][] intervals) {
            int actual = this.eraseOverlapIntervals(intervals);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println(Arrays.deepToString(intervals) + "; expected=" + expected + "; actual=" + actual);
        }
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
            int ans = 0, end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= end) { end = intervals[i][1]; }
                else { ans++; }
            }
            return ans;
        }
    }
}