package org.example;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{15,18},{8,10},{2,6}};
        int[][] sorted = (int[][]) Arrays.stream(intervals).sorted(Comparator.comparing(arr->arr[0])).toArray();
        Arrays.stream(sorted).forEachOrdered(a-> System.out.println(a[0]+" , "+a[1]));
    }

}
