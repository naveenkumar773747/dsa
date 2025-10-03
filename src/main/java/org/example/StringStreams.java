package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;
import java.util.stream.IntStream;

public class StringStreams {
    public static void main(String[] args) {
        String s = "123";
        int n = manipulateString(s);
        System.out.println("Final Integer = "+ n);
    }

    private static int manipulateString(String s) {
        int sum = s.chars()
                .map(c -> c-'0')
                .map(c ->  c*c)
                .sum();

        return String.valueOf(sum)
                .chars()
                .map(c-> c-'0')
                .sum();
    }
}
