package org.example;

//643. Maximum Average Subarray I
/*
    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

    Example 1:


    Input: nums = [1,12,-5,-6,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */

public class SlidingWindowLC643 {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double avg = getMaximumInAWindow(nums, k);
        System.out.println("Max Average = " + avg);
    }

    private static double getMaximumInAWindow(int[] nums, int k) {
        int tempSum = 0;
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            tempSum += nums[i];
        }
        int maxSum = tempSum;

        for (int i = k; i < len; i++) {
            tempSum = tempSum + nums[i] - nums[i - k];
            maxSum = Math.max(tempSum, maxSum);
        }

        return (double) maxSum / k;
    }
}
