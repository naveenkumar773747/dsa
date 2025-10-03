package org.example;

/*
    "Given an array of integers and a sum K,
    return the length of the shortest sub-array which matches the given sum. If it doesn't exist, return -1.
    [Even a single integer can be considered as a sum.]

    Examples:
        int[] arr = {2, 4, 6, 10, 2, 1}, K = 12
        // Return 2

        int[] arr = {5, 8, 50, 4}, K = 50
        // Return 50 (A single integer may be considered as a sum)"
 */

public class ShortestSubArraySumLength {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 6, 13, 10, 2, 1};
        int k = 1;
        int min = findMinLength(arr, k);
        System.out.println("Min Length = " + min);
    }

    private static int findMinLength(int[] arr, int k) {
        int minLength = Integer.MAX_VALUE;
        int startIdx = 0;
        int currSum = 0;

        int i = 0;
        while (i < arr.length) {
            while (i < arr.length && currSum <= k) {

                if (currSum == k) {
                    minLength = Math.min(minLength, i - startIdx);
                    if (minLength == 1) return minLength;
                }
                currSum += arr[i];
                i++;
            }
            while (currSum > k) {
                currSum -= arr[startIdx];
                startIdx++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
