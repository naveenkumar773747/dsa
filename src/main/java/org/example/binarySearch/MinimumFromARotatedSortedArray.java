package org.example.binarySearch;

public class MinimumFromARotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {7, 8, 10, 12, 15, 17, 19};
//        int target = 8;
        int min = findMinimumFromRotatedSortedArray(arr);
        System.out.println("Minimum number from array = " + min);
    }

    protected static int findMinimumFromRotatedSortedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start];
    }
}
