package org.example;

/*
     1
     1,2,1
     1,3,3,1
     1,4,6,4,1
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int num = 5;
        printPascalTriangle(num);
    }

    private static void printPascalTriangle(int num) {
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(Collections.singletonList(1));
        System.out.println(finalList.getFirst());
        finalList.add(List.of(1, 2, 1));
        System.out.println(finalList.get(1));
        for (int i = 2; i <= num; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j <= i; j++) {
                list.add(finalList.get(i - 1).get(j - 1) + finalList.get(i - 1).get(j));
            }
            list.add(1);
            System.out.println(list);
            finalList.add(list);
        }
//        System.out.println(finalList);
    }
}
