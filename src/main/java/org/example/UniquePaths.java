package org.example;

import java.util.Arrays;

class UniquePaths {

    public static void main(String[] args) {
        int rows = 10;
        int columns = 4;
        System.out.println("Total Unique Paths = " + uniquePaths(rows, columns));

    }

    public static int uniquePaths(int m, int n) {
        int r = 0;
        int c = 0;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return recursiveFun(r, c, m, n, dp);
    }

    public static int recursiveFun(int r, int c, int m, int n, int[][] dp) {

        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        if (r >= m || c >= n) {
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int moveRight = recursiveFun(r, c + 1, m, n, dp);
        int moveDown = recursiveFun(r + 1, c, m, n, dp);

        return dp[r][c] = moveRight + moveDown;
    }
}