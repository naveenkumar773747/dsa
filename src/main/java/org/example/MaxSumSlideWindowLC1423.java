package org.example;

import java.util.Arrays;

public class MaxSumSlideWindowLC1423 {
    public static void main(String[] args) {
        int[] cardPoints = {6, 11, 2, 4, 1, 6, 8};
        int k = 3;
        System.out.println("Max Sum = " + getMaxSum(cardPoints, k));
    }

    private static int getMaxSum(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int rem = len - k;
        int tempSum = 0;

        for (int i = 0; i < rem; i++) {
            tempSum += cardPoints[i];
        }
        int minSum = tempSum;

        for (int i = rem; i < len; i++) {
            tempSum = tempSum - cardPoints[i - rem] + cardPoints[i];
            minSum = Math.min(tempSum, minSum);
        }

        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
