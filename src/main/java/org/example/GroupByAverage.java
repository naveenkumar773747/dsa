package org.example;

/*
    "Given a list of student names and corresponding marks,
    return the highest average marks (and print the corresponding student name - optional).
    The marks can be negative as well and a student may have multiple marks.

    Example:
        String[][] = {{"Charles", 84},
                      {"John", 100},
                      {"Andy", 37},
                      {"John", 23},
                      {"Charles", 20}};

    //Return 61.5 (which is of John's)"
 */

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByAverage {
    public static void main(String[] args) {
        String[][] studentMap = {{"Charles", "84"},
                {"John", "100"},
                {"Andy", "37"},
                {"John", "23"},
                {"Charles", "20"}};

        String[] array = {"Charles", "John", "Andy", "Charles"};

        for (String arr : array) {
            char[] charArr = arr.toLowerCase().toCharArray();
            Arrays.sort(charArr);

            System.out.println("Sorted ARR = " + new String(charArr));
        }

        Map.Entry<String, Double> topStudent = highestAverage(studentMap);
        int topStudentWithoutStream = getHighestAverageWithoutStreamAPI(studentMap);
        System.out.println("Top Student Name = " + topStudent.getKey() + " Average = " + topStudent.getValue());
        System.out.println("Top Student Average = " + topStudentWithoutStream);

    }

    private static Map.Entry<String, Double> highestAverage(String[][] studentMap) {
        return Arrays.stream(studentMap)
                .filter(map -> Integer.parseInt(map[1]) > 0)
                .collect(
                        Collectors.groupingBy(
                                s -> s[0],
                                Collectors.averagingInt(
                                        s -> Integer.parseInt(s[1]))
                        )
                )
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .stream()
                .findFirst()
                .orElse(new AbstractMap.SimpleEntry<>(null, 0.0));

    }

    public static int getHighestAverageWithoutStreamAPI(String[][] studentMap) {

        Map<String, int[]> calcMap = new HashMap<>();

        for (String[] arr : studentMap) {
            int previousScore = calcMap.containsKey(arr[0]) ? calcMap.get(arr[0])[0] : 0;
            int previousCount = calcMap.containsKey(arr[0]) ? calcMap.get(arr[0])[1] : 0;
            calcMap.put(arr[0], new int[]{previousScore + Integer.parseInt(arr[1]), previousCount + 1});
        }
        int avg = 0;
        for (Map.Entry<String, int[]> entry : calcMap.entrySet()) {
            avg = Math.max(avg, entry.getValue()[0] / entry.getValue()[1]);
        }

        return avg;
    }
}
