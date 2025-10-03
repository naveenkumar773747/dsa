package org.example;

public class ShortestWordDistance {
    public static void main(String[] args) {
        String str = "the frog quick brown quick brown quick frog";
        String word1 = "the";
        String word2 = "dummy";
        int minDistance = findMinimumDistance(str, word1, word2);
        int maxDistance = findMaximumDistance(str, word1, word2);
        System.out.println("minDistance = " + minDistance);
        System.out.println("maxDistance = " + maxDistance);
    }

    private static int findMinimumDistance(String str, String word1, String word2) {
        String[] arr = str.split("\\s+");
        int idx1 = -1, idx2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word1)) {
                idx1 = i;
            }
            if (arr[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                res = Math.min(res, Math.abs(idx2 - idx1 - 1));
            }
        }
        return res;
    }

    private static int findMaximumDistance(String str, String word1, String word2) {
        String[] arr = str.split(" ");
        int idx1 = -1, idx2 = -1;
        int endx1 = -1, endx2 = -1;
        int res = Integer.MIN_VALUE;
        int n = arr.length - 1;

        for (int i = 0; i <= n; i++) {
            if (idx1 == -1 && arr[i].equals(word1)) {
                idx1 = i;
            }

            if (idx2 == -1 && arr[i].equals(word2)) {
                idx2 = i;
            }

            if (endx1 == -1 && arr[n - i].equals(word1)) {
                endx1 = n - i;
            }

            if (endx2 == -1 && arr[n - i].equals(word2)) {
                endx2 = n - i;
            }

            if (idx1 != -1 && idx2 != -1 && endx1 != -1 && endx2 != -1) {
                res = Math.max(Math.abs(endx2 - idx1), Math.abs(endx1 - idx2)) - 1;
            }
        }
        return res;
    }
}
