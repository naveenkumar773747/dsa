package org.example.quickselect;

import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int[] arr = {17, 10, 2, 20, 6, 28, 14, 22, 55};
        int[] topKElements = findTopKElementsUsingHeap(arr, 3);
        System.out.println("Top K Element Min Heap = " + Arrays.toString(topKElements));
        int[] topKElementsQuickSelect = findTopKElementsUsingQuickSelect(arr, 3);
        System.out.println("Top K Element Quick Select = " + Arrays.toString(topKElementsQuickSelect));
        int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3};
        int[] topKFrequent = topKFrequent(nums, 2);
        System.out.println("Top K Frequent = " + Arrays.toString(topKFrequent));
    }

    private static int[] findTopKElementsUsingQuickSelect(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (true) {
            int pivot_index = arr.length - k;
            int new_pivot_index = partitions(arr, left, right, pivot_index);
            if (new_pivot_index == pivot_index) {
                return Arrays.copyOfRange(arr, arr.length - k, arr.length);
            } else if (new_pivot_index > arr.length - k) {
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

    private static int[] findTopKElementsUsingHeap(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[k];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
            if (i == k) {
                System.out.println("Initial Heap = " + minHeap);
            }
            if (minHeap.size() > k + 1) {
                minHeap.poll();
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }

        return res;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> list1 = freqMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("List one ASC = " + list1);

        List<Integer> list = list1.reversed()
                .stream()
                .limit(k)
                .toList();

        System.out.println("List two DESC Limit K = " + list);

        int i = k - 1;
        int[] res = new int[k];
        for (int num : list) {
            res[i--] = num;
        }

        return res;
    }

}
