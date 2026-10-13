package org.rehyouka.leetcode.mid;

/**
 * @author william
 * @since 2026/9/10
 */
class 岛屿数量 {
    public static void main(String[] args) {
        岛屿数量 m = new 岛屿数量();
        m.exe(1, new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        });
        m.exe(2, new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        });
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int nLen = grid[0].length;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < nLen; n++) {
                if (grid[m][n] == '1') {
                    this.dfs(grid, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int m, int n) {
        if (
            m < 0 ||
            m >= grid.length ||
            n < 0 ||
            n >= grid[0].length ||
            grid[m][n] == '0'
        ) {
            return;
        }
        grid[m][n] = '0';

        this.dfs(grid, m - 1, n);
        this.dfs(grid, m + 1, n);
        this.dfs(grid, m, n - 1);
        this.dfs(grid, m, n + 1);
    }

    void exe(int caseNo, char[][] grid) {
        int count = this.numIslands(grid);
        System.out.println("caseNo[" + caseNo + "] -> count=" + count);
    }
}
