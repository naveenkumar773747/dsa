package org.example;

import java.util.Arrays;

class UniquePathsObstacle {

    public int recursiveFun(int r, int c, int m, int n, int[][] dp, int[][] grid) {

        if (r == m - 1 && c == n - 1 && grid[r][c] != 1) {
            return 1;
        }

        if (r >= m || c >= n) {
            return 0;
        }

        if (grid[r][c] == 1) {
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int moveRight = recursiveFun(r, c + 1, m, n, dp, grid);
        int moveDown = recursiveFun(r + 1, c, m, n, dp, grid);

        return dp[r][c] = moveRight + moveDown;
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return recursiveFun(0, 0, m, n, dp, grid);
    }
}