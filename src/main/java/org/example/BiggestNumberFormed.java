package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BiggestNumberFormed {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        String max = maximumNumberFromArray(arr);
        System.out.println("Maximum = " + max);
    }

    private static String maximumNumberFromArray(int[] arr) {

        List<String> sorted = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .toList();

        if (Objects.equals(sorted.getFirst(), "0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String str : sorted) {
            sb.append(str);
        }

        return sb.toString();
    }


}
