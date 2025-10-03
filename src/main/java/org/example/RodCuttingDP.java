package org.example;

import java.util.Arrays;

public class RodCuttingDP {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20}; // Price for lengths 1 to 8
        int rodLength = 8;
        System.out.println("Maximum Obtainable Value is " + rodCutting(price, rodLength));
    }

    private static int rodCutting(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        //{1, 5, 8, 9, 10, 17, 17, 20}
        for (int i = 1; i <= n; i++) {
            int maxVal = price[i - 1];
            for (int j = 1; j <= i / 2; j++) {
                maxVal = Math.max(maxVal, dp[j] + dp[i - j]);
            }
            dp[i] = maxVal;
        }
        System.out.println("DP Array = " + Arrays.toString(dp));
        return dp[n];
    }
}
