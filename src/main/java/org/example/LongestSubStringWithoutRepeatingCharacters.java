package org.example;

import java.util.HashMap;
import java.util.Map;

class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "abcdefiiiiabcdefghijk";
        System.out.println("Max length = " + lengthOfLongestSubstringHashMap(str));
    }

    public static int lengthOfLongestSubstringHashMap(String s) {
        int maxLength = 0;
        int currLength = 0;
        int idx = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c, i);
            currLength = i - start + 1;
            if (currLength >= maxLength) {
                idx = i;
                maxLength = currLength;
            }
        }
        System.out.println(s.substring(idx - maxLength + 1, idx + 1));
        return maxLength;
    }


    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currLength = 0;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.indexOf(String.valueOf(c)) != -1) {
                sb.setLength(0);
                sb.append(c);
                currLength = 1;
            } else {
                sb.append(c);
                currLength++;
            }
            //maxLength = Math.max(maxLength, currLength);
            if (currLength > maxLength) {
                idx = i;
                maxLength = currLength;
            }
        }
        System.out.println(s.substring(idx - maxLength + 1, idx + 1));
        return maxLength;
    }
}