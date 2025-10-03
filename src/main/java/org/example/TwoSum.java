package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 13, 11, 15};
        int target = 18;
        int[] indices = twoSumNlogN(nums, target);
        System.out.println("Two indices to sum up to target = " + java.util.Arrays.toString(indices));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{i, indexMap.get(target - nums[i])};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumSorted(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int tempSum = nums[low] + nums[high];
            if (tempSum == target) {
                return new int[]{low, high};
            } else if (tempSum > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumNlogN(int[] nums, int target) {
        int[][] numIdx = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numIdx[i][0] = nums[i];
            numIdx[i][1] = i;
        }

        int[][] sortedNumIdx = Arrays.stream(numIdx)
                .sorted(Comparator.comparingInt(s -> s[0]))
                .toList()
                .toArray(new int[0][]);

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int tempSum = sortedNumIdx[low][0] + sortedNumIdx[high][0];
            if (tempSum == target) {
                return new int[]{sortedNumIdx[low][1], sortedNumIdx[high][1]};
            } else if (tempSum > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }
}