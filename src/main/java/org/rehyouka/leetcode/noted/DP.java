package org.rehyouka.leetcode.noted;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * @author william
 * @since 2026/9/15
 */
class DP {
    static class ClimbingStairs {
        /**
         * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
         * 每次你可以爬 1 个或 2 个台阶。
         * 问：有多少种不同的方法可以爬到楼顶？
         * <p>
         * 2 --> 2
         * 3 --> 3
         */
        public static void main(String[] args) {
            ClimbingStairs m = new ClimbingStairs();
            m.exe(2, 2);
            m.exe(3, 3);
        }

        void exe(int expected, int total) {
            int actual = this.algo(total);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println("total=" + total + " --> expected=" + expected + "; actual=" + actual);
        }

        int algo(int total) {
            if (total == 1) {
                return 1;
            }
            int[] dp = new int[total];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < total; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[dp.length - 1];
        }
    }

    static class MaxSubArr {
        /**
         * 给你一个整数数组 nums，请你找出一个具有最大和的连续子数组，并返回其最大和。
         * 子数组是数组中的一个连续部分，且至少包含一个元素。
         * <p>
         * [-2,1,-3,4,-1,2,1,-5,4] --> 6
         * [1] --> 1
         * [5,4,-1,7,8] --> 23
         */
        public static void main(String[] args) {
            MaxSubArr m = new MaxSubArr();
            m.exe(6, new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
            m.exe(1, new int[]{1});
            m.exe(23, new int[]{5, 4, -1, 7, 8});
        }

        void exe(int expected, int[] arr) {
            int actual = this.algo(arr);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println(Arrays.toString(arr) + " --> expected=" + expected + "; actual=" + actual);
        }

        int algo(int[] arr) {
            int[] dp = new int[arr.length];
            dp[0] = arr[0];
            int max = dp[0];
            for (int i = 1; i < arr.length; i++) {
                // 1. 先不要管主线：遍历到索引i的时候，要么算上arr[i]?
                //  换句话说： a. i是正的 b. i是负的
                //  再换句话说： 要不要重新开始 一个新的子数组？
                dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
                // 2. 回到主线：最大值！
                // dp数组 帮我们 演算；
                // 我们自己 取需要的值
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    static class Robbing {
        /**
         * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
         * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
         * 给定一个代表每个房屋存放金额的非负整数数组，
         * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
         * <p>
         * [1,2,3,1] --> 4
         * [2,7,9,3,1] --> 12
         */
        public static void main(String[] args) {
            Robbing m = new Robbing();
            m.exe(4, new int[]{1, 2, 3, 1});
            m.exe(12, new int[]{2, 7, 9, 3, 1});
        }

        void exe(int expected, int[] arr) {
            int actual = this.algo(arr);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println(Arrays.toString(arr) + " --> expected=" + expected + "; actual=" + actual);
        }

        int algo(int[] arr) {
            if (arr.length == 1) {
                return arr[0];
            }
            int[] dp = new int[arr.length];
            dp[0] = arr[0];
            dp[1] = Math.max(arr[0], arr[1]);
            for (int i = 2; i < arr.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            }
            return dp[dp.length - 1];
        }
    }

    static class LongestPalindromicSubString {
        /**
         * 给你一个字符串 s，找到 s 中最长的 回文 子串。
         * <p>
         * 1 <= s.length <= 1000
         * s 仅由数字和英文字母组成
         */
        public static void main(String[] args) {
            LongestPalindromicSubString m = new LongestPalindromicSubString();
            m.exe("bab", "babad");
            m.exe("bb", "cbbd");
        }

        void exe(String expected, String str) {
            String actual = this.algo(str);
            PrintStream s = expected.equals(actual) ? System.out : System.err;
            s.println(str + " --> expected=" + expected + "; actual=" + actual);
        }

        String algo(String s) {
            int len = s.length();
            if (len == 1) {
                return s;
            }

            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            // 长度 X 起点 --> 同时向左右两侧扩展
            int idxBgn = 0;
            int maxLen = 1;
            char[] chars = s.toCharArray();
            // 长度
            for (int l = 2; l <= len; l++) {
                // 起点
                for (int i = 0; i < len; i++) {
                    // 终点
                    int j = i + l - 1;
                    if (j >= len) {
                        break;
                    }

                    if (chars[i] == chars[j]) {
                        dp[i][j] = l < 3 || dp[i + 1][j - 1];
                    }

                    if (dp[i][j] && l > maxLen) {
                        idxBgn = i;
                        maxLen = l;
                    }
                }
            }
            return s.substring(idxBgn, idxBgn + maxLen);
        }
    }

    static class CountSubStrings {
        /**
         * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
         * 回文字符串 是正着读和倒过来读一样的字符串。
         * 子字符串 是字符串中的由连续字符组成的一个序列。
         * <p>
         * 1 <= s.length <= 1000
         * s 由小写英文字母组成
         */
        public static void main(String[] args) {
            CountSubStrings m = new CountSubStrings();
            m.exe(3, "abc");
            m.exe(6, "aaa");
            m.exe(6, "fdsklf");
        }

        void exe(int expected, String str) {
            int actual = this.algo(str);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println(str + " --> expected=" + expected + "; actual=" + actual);
        }

        int algo(String s) {
            int len = s.length();
            if (len == 1) {
                return 1;
            }

            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            int count = len;
            char[] chars = s.toCharArray();
            for (int l = 2; l <= len; l++) {
                for (int i = 0; i < len; i++) {
                    int j = i + l - 1;
                    if (j >= len) {
                        break;
                    }

                    if (chars[i] == chars[j]) {
                        dp[i][j] = l < 3 || dp[i + 1][j - 1];
                        if (dp[i][j]) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }

    static class MaxSquare {
        /**
         * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
         * <p>
         * in: [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
         * out: 4
         * <p>
         * in: [["0","1"],["1","0"]]
         * out: 1
         * <p>
         * in: [["0"]]
         * out: 0
         */
        public static void main(String[] args) {
            MaxSquare m = new MaxSquare();
            char[][] matrix = {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            };
            m.exe(1, 4, matrix);

            matrix = new char[][]{{'0', '1'}, {'1', '0'}};
            m.exe(2, 1, matrix);

            matrix = new char[][]{{'0'}};
            m.exe(3, 0, matrix);
        }

        void exe(int caseNo, int expected, char[][] matrix) {
            int actual = this.algo(matrix);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println("caseNo[" + caseNo + "]" + " --> expected=" + expected + "; actual=" + actual);
        }

        int algo(char[][] matrix) {
            int maxLen = 0;
            int mLen = matrix.length, nLen = matrix[0].length;
            int[][] dp = new int[mLen + 1][nLen + 1];
            for (int m = 0; m < mLen; m++) {
                for (int n = 0; n < nLen; n++) {
                    if (matrix[m][n] == '1') {
                        dp[m + 1][n + 1] = Math.min(Math.min(dp[m + 1][n], dp[m][n + 1]), dp[m][n]) + 1;
                        maxLen = Math.max(maxLen, dp[m + 1][n + 1]);
                    }
                }
            }
            return maxLen * maxLen;
        }
    }

    static class LongestIncrSubseq {
        /**
         * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
         * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
         * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
         */
        public static void main(String[] args) {
            LongestIncrSubseq m = new LongestIncrSubseq();
            m.exe(4, new int[]{10, 9, 2, 5, 3, 7, 101, 18});
            m.exe(3, new int[]{4,10,4,3,8,9});
            m.exe(6, new int[]{3,5,6,2,5,4,19,5,6,7,12});
            m.exe(4, new int[]{0, 1, 0, 3, 2, 3});
            m.exe(1, new int[]{7, 7, 7, 7, 7, 7, 7});
        }

        void exe(int expected, int[] nums) {
            int actual = this.algo(nums);
            PrintStream s = expected == actual ? System.out : System.err;
            s.println(Arrays.toString(nums) + "; expected=" + expected + "; actual=" + actual);
        }
        int algo(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];

            int maxLen = 1;
            for (int i = 0; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;
        }

/*
        int algo(int[] nums) {
            int len = nums.length;

            // 前面索引的 值越小，后面可以接纳 的值就越多 -> 长度越长 -> 贪心
            // tails 记录 最优解 -> 长度为 tailsCur+1 时，的最小值
            int[] tails = new int[len];
            int tailsCur = 0;
            // 预处理，防止 tails[++tailsCur] = num; 导致索引错位
            tails[0] = nums[0];
            int tailsIdxLf = 0, tailsIdxMd = 0, tailsIdxRt = 0;

            for (int num : nums) {
                // 重复值，无影响 -> 跳过 查找替换
                if (num == tails[tailsCur]) {}

                // num > tails所有 -> 即题意，长度+1 -> tails元素 增加
                else if (num > tails[tailsCur]) { tails[++tailsCur] = num;}

                // num < tails最大值 -> tails[i]存在更优解 -> tails元素 替换
                else {

                    // tails数组 递增 -> 二分查找 -> log(n)
                    tailsIdxLf = 0;
                    tailsIdxRt = tailsCur;
                    while( tailsIdxLf != tailsIdxRt ) {
                        tailsIdxMd = (tailsIdxLf+tailsIdxRt)/2;
                        if (tails[tailsIdxMd] >= num) {
                            tailsIdxRt = tailsIdxMd;
                        }
                        else {
                            tailsIdxLf = tailsIdxMd+1;
                        }
                    }
                    tails[tailsIdxLf] = num;

                }
            }
            return tailsCur+1;
        }
 */
    }
}
