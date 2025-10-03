package org.example;

import java.util.Arrays;
import java.util.Comparator;

/*
    Given a dictionary (list of words) and a substring, you have to return the length of the longest word in the dictinary containing the substring.

    Example:
    String[] dict = {""CODGE"", ""ODG"", ""LODGES"", ""SODG"", ""dodge"", ""mODJ"", ""LODGESSSS""}
    String toSearch = ""ODG"";

    Returns 9 (LODGESSSS)
 */

class StreamFilter {
    public static void main(String[] args) {
        String[] list = {"CODGENaveen", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS", ""};
        String toSearch = "ODG";

        int maxLength = filterStrings(list, toSearch);
        System.out.println("Maximum length = " + maxLength);
    }

    protected static int filterStrings(String[] list, String search) {
        return Arrays.stream(list)
                .filter(s -> s.contains(search))
                .max(Comparator.comparing(String::length))
                .map(String::length)
                .orElse(-1);
    }
}
