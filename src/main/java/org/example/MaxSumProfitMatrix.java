package org.example;

import java.util.Arrays;

public class MaxSumProfitMatrix {
    public static void main(String[] args) {
        int[][] grid = {{5, 8, 1}, {2, 5, 1}, {8, 2, 1}};
        // 5,8,1
        // 2,5,1
        // 8,2,1
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int maxProfitDP = minPathSumDownLeftToTopRight(grid);
//        int maxProfitDPRev = minPathSumMnTo00(grid);
//        int maxProfit = solveMemo(grid, 0, 0, dp);
        System.out.println("Max Profit DP Rev == " + maxProfitDP);
    }

    private static int solveMemo(int[][] grid, int r, int c, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (r >= m) return Integer.MIN_VALUE;
        if (c >= n) return Integer.MIN_VALUE;

        if (dp[r][c] != -1) return dp[r][c];

        if (r == m - 1 && c == n - 1) return grid[r][c];

        return dp[r][c] = grid[r][c] + Math.max(solveMemo(grid, r + 1, c, dp), solveMemo(grid, r, c + 1, dp));
    }

    public static int minPathSum00ToMn(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        // for row
        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }
        // for col
        for (int j = 1; j < m; j++) {
            res[j][0] = res[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
            }
        }
        return res[m - 1][n - 1];
    }

    public static int minPathSumMnTo00(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[m - 1][n - 1] = grid[m - 1][n - 1];
        // for row
        for (int i = m - 2; i >= 0; i--) {
            res[n - 1][i] = res[n - 1][i + 1] + grid[n - 1][i];
        }
        System.out.println("Last row = " + Arrays.deepToString(res));
        // for col
        for (int j = n - 2; j >= 0; j--) {
            res[j][m - 1] = res[j + 1][m - 1] + grid[j][n - 1];
        }
        System.out.println("Last column = " + Arrays.deepToString(res));
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                res[i][j] = grid[i][j] + Math.max(res[i + 1][j], res[i][j + 1]);
                System.out.println(Arrays.deepToString(res));
            }
        }
        return res[0][0];
    }

    public static int minPathSumDownLeftToTopRight(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[m - 1][0] = grid[m - 1][0];

        // 5,8,1
        // 2,5,1
        // 8,2,1

        // for last row
        for (int i = 1; i < n; i++) {
            res[m - 1][i] = res[n - 1][i - 1] + grid[m - 1][i];
        }
        System.out.println("Last row = " + Arrays.deepToString(res));
        // for first col
        for (int j = m - 2; j >= 0; j--) {
            res[j][0] = res[j + 1][0] + grid[j][0];
        }
        System.out.println("First column = " + Arrays.deepToString(res));
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                res[i][j] = grid[i][j] + Math.max(res[i + 1][j], res[i][j - 1]);
                System.out.println(Arrays.deepToString(res));
            }
        }
        return res[0][n - 1];
    }
}
