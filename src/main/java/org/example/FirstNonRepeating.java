package org.example;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class FirstNonRepeating {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 2, 3, 5);

        System.out.println("First Non Repeating = " + returnFirstNonRepeatingCharacter(intList));
        Map<Integer, Long> sortMapByValue =
                intList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(),
                                        LinkedHashMap::new,
                                        Collectors.counting()
                                ))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (existValue, newValue) -> existValue,
                                LinkedHashMap::new
                        ));
        System.out.println("Sorted Map by value = " + sortMapByValue);
    }

    private static Integer returnFirstNonRepeatingCharacter(List<Integer> intList) {
        return intList.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        ))
                .entrySet()
                .stream()
                .filter(map -> map.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }
}
