package org.example.slidingWindow;

public class MinWindowSubString {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Min Window V1 = " + minWindow(s, t));
        System.out.println("Min Window V2 = " + minWindowV2(s, t));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int[] need = new int[128];
        for (Character c : t.toCharArray()) {
            need[c]++;
        }


        int left = 0;
        int right = 0;
        int required = t.length();
        int start = 0;
        int minLen = Integer.MAX_VALUE;


        while (right < s.length()) {

            char c = s.charAt(right);
            if (need[c] > 0) {
                required--;
            }

            need[c]--;
            right++;

            while (required == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                need[leftChar]++;

                if (need[leftChar] > 0) {
                    required++;
                }

                left++;
            }


        }
        return s.substring(start, start + minLen);
    }

    public static String minWindowV2(String s, String t) {
        int[] freq = new int[256];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;
        int required = 0;
        int startIdx = -1;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char curr = s.charAt(right);
            if (freq[curr] > 0) {
                required++;
            }
            
            freq[curr]--;

            while (required == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                freq[s.charAt(left)]++;

                if (freq[s.charAt(left)] > 0) {
                    required--;
                }

                left++;
            }

            right++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
