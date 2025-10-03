package org.example.binarySearch;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 6, 10, 12};
        int[] arr2 = {7, 10, 12, 14, 16, 18, 20};
//        1, 3, 6, 10 ||  12
//          7, 10, 12 ||  14, 16, 18, 20
        double median = findMedian(arr1, arr2);
        System.out.println("Median = " + median);
    }

    private static double findMedian(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findMedian(arr2, arr1);
        }

        int m = arr1.length, n = arr2.length;
        int median = 0, low = 0, high = arr1.length;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < m) r1 = arr1[mid1];
            if (mid2 < n) r2 = arr2[mid2];
            if (mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return median;
    }
}
