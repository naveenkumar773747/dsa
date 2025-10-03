package org.example;

import java.util.PriorityQueue;

public class MiddleElementAfterSorted {
    public static void main(String[] args) {
        int[] arr = {17, 10, 2, 20, 6, 28, 14, 22, 55};
        int midHeap = findMidUsingHeap(arr);
        System.out.println("Middle Element Min Heap = " + midHeap);
        int midQuickSelect = findMidUsingQuickSelect(arr);
        System.out.println("Middle Element Quick Select = " + midQuickSelect);

    }

    private static int findMidUsingQuickSelect(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (true) {
            int pivot_index = (int) (Math.random() * 100) % (right - left + 1) + left;
            int new_pivot_index = partitions(arr, 0, arr.length - 1, pivot_index);

            if (new_pivot_index == arr.length / 2) {
                return arr[new_pivot_index];
            } else if (new_pivot_index > arr.length / 2) {
                right = new_pivot_index - 1;
            } else {
                left = new_pivot_index + 1;
            }

        }

    }

    private static int partitions(int[] arr, int left, int right, int pivotIndex) {
        int storedIndex = left;
        int pivot_element = arr[pivotIndex];
        swapElements(arr, right, pivotIndex);
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot_element) {
                swapElements(arr, i, storedIndex);
                storedIndex++;
            }
        }
        swapElements(arr, right, storedIndex);
        return storedIndex;
    }

    private static void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int findMidUsingHeap(int[] arr) {
        int n = arr.length;
        int midIndex = n / 2;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
            if (i == midIndex) {
                System.out.println("Initial Heap = " + minHeap);
            }
            if (minHeap.size() > midIndex + 1) {
                minHeap.poll();
                System.out.println(minHeap);
            }
        }

        return minHeap.peek() != null ? minHeap.peek() : -1;
    }

}
