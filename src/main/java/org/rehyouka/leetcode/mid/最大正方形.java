package org.rehyouka.leetcode.mid;

/**
 * @author william
 * @since 2026/8/25
 */
class 最大正方形 {
    public static void main(String[] args) {
        最大正方形 m = new 最大正方形();

        // {{}} 只能用于第一次初始化
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        m.exe("5x4", matrix);

        matrix = new char[][]{{'0','1'},{'1','0'}};
        m.exe("2x2", matrix);

        matrix= new char[][]{{'0'}};
        m.exe("1x1", matrix);
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height+1][width+1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <width; j++) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i][j]) + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        return max*max;
    }

    void exe(String flag, char[][] matrix) {
        int max = this.maximalSquare(matrix);
        System.out.println(flag + " => " + max);
    }
}
