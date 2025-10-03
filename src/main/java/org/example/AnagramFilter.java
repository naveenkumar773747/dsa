package org.example;

/*
    "Given a dictionary (list of words) and a word,
    return an array of strings that can be formed from the given word.
    [Every letter in the input word can occur only once in the word to be returned].

    Examples:
        String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab"};
        String input = "abcd";
        Return {"abcd", "bcad"}
    
        String[] dict =  {"ab", "abcd", "bcdaf", "bcad", "acaab", "acab"};
        String input = "caab";
        Return {"acab"}"
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramFilter {
    public static void main(String[] args) {
        String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab" };
        String input = "abcd";
        String[] matchedAnagrams = matchedAnagramsFromArray(dict, input);
        System.out.println("Matched Anagrams = " + Arrays.toString(matchedAnagrams));
    }

    private static int[] getFrequencyMap(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq['z' - c]++;
        }
        return freq;
    }

    private static boolean areAnagrams(int[] word, int[] input) {
        for (int i = 0; i < 26; i++) {
            if (word[i] != input[i]) {
                return false;
            }
        }
        return true;
    }

    private static String[] matchedAnagramsFromArray(String[] dict, String input) {
        int[] inputFreq = getFrequencyMap(input);
        List<String> res = new ArrayList<>();
        for (String word : dict) {
            int[] wordFreq = getFrequencyMap(word);
            if (areAnagrams(wordFreq, inputFreq)) {
                res.add(word);
            }
        }
        return !res.isEmpty() ? res.toArray(new String[0]) : new String[0];
    }
}
