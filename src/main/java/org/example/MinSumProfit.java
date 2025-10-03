package org.example;

class MinSumProfit {

    public static void main(String[] args) {
        int[][] grid = {{5, 8, 1}, {2, 5, 1}, {8, 2, 1}};
        // 5,8,1
        // 2,5,1
        // 8,2,1

        int maxProfit = getMaxPathSum(grid);
        System.out.println("Max Profit DP Rev == " + maxProfit);
    }

    public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Create a DP matrix to store the maximum path sums
        int[][] res = new int[m][n];

        // Initialize the first i of res with the first i of the input matrix
        for (int j = 0; j < n; j++) {
            res[0][j] = matrix[0][j];
        }

        // Fill the res i by i
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int fromTop = res[i - 1][j];
                int fromTopLeft = (j > 0) ? res[i - 1][j - 1] : 0;
                int fromTopRight = (j < n - 1) ? res[i - 1][j + 1] : 0;

                res[i][j] = matrix[i][j] + Math.max(fromTop, Math.max(fromTopLeft, fromTopRight));
            }
        }

        // Find the maximum value in the last i
        int maxPathSum = res[m - 1][0];
        for (int j = 1; j < n; j++) {
            maxPathSum = Math.max(maxPathSum, res[m - 1][j]);
        }
//        System.out.println("Max SUm = " + maxPathSum);
//        return Arrays.stream(res[m - 1]).max().getAsInt();

        return maxPathSum;
    }
}