package org.example;

/*
    "Given a string,
    return the pallindrome of maximum length and its length.
    (So, you return both the relevant pallindrome substring and its length).

    Example:
    String str = "forgeeksskeegfor";
    // Return {"geeksskeeg",  10}"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println("Longest palindrome = " + longestPalindrome(str));

        System.out.println("Max Length = " + longestPalindrome(str).length());
    }

    private static int getMaxLengthOfPalindrome(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
//        str.indexOf()

        return end - start - 1;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        // "cddb"
        for (int i = 0; i < s.length(); i++) {
            int len1 = getMaxLengthOfPalindrome(s, i, i);
            int len2 = getMaxLengthOfPalindrome(s, i, i + 1);

            int max = Math.max(len1, len2);

            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + (max) / 2;
                System.out.println("start = " + start);
                System.out.println("iterate = " + i);
                System.out.println("end = " + end);
            }
            /*
                max = 6
                i = 4
                s = 1
                e = 7
            */

        }
        System.out.println("max = " + (end - start + 1));
        return s.substring(start, end + 1);
    }
}
