package org.example.binarySearch;

import java.util.Arrays;

public class RotateAnArray {

    public static void main(String[] args) {
        int[] nums = {7, 10, 12, 14, 16, 18, 20};

        rotate(nums, 3);
        System.out.println("Rotated Array = " + Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1); // {20, 18, 16, 14, 12, 10, 7}
        reverse(nums, 0, k - 1); // {16, 18, 20, 14, 12, 10, 7}
        reverse(nums, k, nums.length - 1); //{16, 18, 20, 7, 10, 12, 14}
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
