package org.example;

import java.util.Arrays;

public class SortWaveForm {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 6, 3, 5, 9};
        //           0, 1, 2, 4, 3, 6,
        waveSortOptimal(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void waveSortOptimal(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {

            // If current even index element is smaller than previous
            if (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }

            // If current even index element is smaller than next
            if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

}
