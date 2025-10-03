package org.example;


import java.util.Arrays;

/*
        There are n houses built in a line, each of which contains some money in it. A robber wants to steal money from these houses, but he can’t steal from two adjacent houses. The task is to find the maximum amount of money which can be stolen.

        Examples:

        Input: hval[] = {6, 7, 1, 3, 8, 2, 4}
        Output: 19
        Explanation: The thief will steal from house 1, 3, 5 and 7, total money = 6 + 1 + 8 + 4 = 19.

        Input: hval[] = {5, 3, 4, 11, 2}
        Output: 16
        Explanation: Thief will steal from house 1 and 4, total money = 5 + 11 = 16.
 */
public class HouseRobberyOne {

    public static void main(String[] args) {
        int[] val = {2, 1, 1, 7, 2, 4, 9};
        int[] dp = new int[val.length + 1];
        int[] dpRec = new int[val.length + 1];
        Arrays.fill(dpRec, -1);
        int totalRecursive = maxRobbedMoneyRecursive(val, val.length, dpRec);
        int total = maxRobbedMoneyByDP(val, dp);
        int optTotal = maxRobbedMoneyOptimized(val);
        System.out.println(total + " == " + optTotal + " == " + totalRecursive);
    }

    private static int maxRobbedMoneyRecursive(int[] val, int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return val[0];

        if (dp[n] != -1) return dp[n];

        int pick = val[n - 1] + maxRobbedMoneyRecursive(val, n - 2, dp);
        int notPick = maxRobbedMoneyRecursive(val, n - 1, dp);

        dp[n] = Math.max(pick, notPick);

        return dp[n];
    }

    // bottom up approach
    private static int maxRobbedMoneyByDP(int[] val, int[] dp) {
        int n = val.length;

        dp[0] = 0;
        dp[1] = val[0];
        //5,7

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(val[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[n];
    }

    //Space Optimized
    private static int maxRobbedMoneyOptimized(int[] val) {
        int n = val.length;

        int prev2 = 0;
        int prev1 = val[0];

        for (int i = 2; i <= n; i++) {
            int temp = Math.max(val[i - 1] + prev2, prev1);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
