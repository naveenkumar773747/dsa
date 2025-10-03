package org.example;

import java.util.Arrays;

public class TimeToSeconds {
    public static void main(String[] args) {
        String time = "01:15:50";
        int sec = Arrays.stream(time.split(":"))
                .map(Integer::parseInt)
                .reduce(0,(a,b)->a+b*60);
        System.out.println("Total seconds = "+sec);
    }
}
