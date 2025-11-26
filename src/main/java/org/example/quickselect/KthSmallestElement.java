package org.example.quickselect;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] nums = {17, 12, 10, 4, 16, 8, 9};
        int k = 3;
        int res = kthSmallestElementSorting(nums, k);
        int res2 = kthSmallestElementPriorityQueue(nums, k);
        int res3 = kthSmallestElementQuickSelect(nums, k);
        System.out.println(res + " == " + res2 + " == " + res3);
    }

    private static int kthSmallestElementSorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k-1];
    }

    private static int kthSmallestElementPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            int top = !queue.isEmpty() ? queue.peek() : -1;
            if (nums[i] < top) {
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return !queue.isEmpty() ? queue.peek() : -1;
    }

    private static int kthSmallestElementQuickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (true) {
           int pivot_index = (((int) (Math.random() * 100)) % (right - left + 1)) + left;
           int new_pivot_index = getNewPivotIndex(nums, pivot_index, left, right);
           if(new_pivot_index==k-1){
               return nums[new_pivot_index];
           }
           else if(new_pivot_index>k-1){
               right = new_pivot_index-1;
           }
           else{
               left = new_pivot_index+1;
           }
        }
    }

    private static void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int getNewPivotIndex(int[] nums, int pivotIndex, int left, int right) {
        int storedIdx = left;
        int pivotElement = nums[pivotIndex];
        swapElements(nums, pivotIndex, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotElement) {
                swapElements(nums, i, storedIdx);
                storedIdx++;
            }
        }
        swapElements(nums, right, storedIdx);

        return storedIdx;
    }


}
