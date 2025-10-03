package org.example;

import java.util.Arrays;

/*
    Given the string (containing directions e.g., U, R, D, L) and initial coordinates (0,0),
    return the final coordinates after traversing the string.

    Examples:
    Given (0,0) and String - "UUU"
        Answer : (0,3)

    Given (0,0) and String - "URRDDL"
        Answer : (1,-1)

    Additional testcase : String - "DOWN UP 2xRIGHT DOWN 3xLEFT"
        Answer : (-1,-1)
 */

class CoOrdinatesCalc {
    public static void main(String[] args) {
        String str = "DOWN UP 2xRIGHT DOWN 3xLEFT";
        int[] values = {0, 0};
        int[] finalXY = getFinalCoOrdinates(str, values);
        System.out.println("Final CoOrdinates: x = " + finalXY[0] + " y = " + finalXY[1]);

    }

    protected static int[] getFinalCoOrdinates(String str, int[] xy) {
        int n = str.length();
        int[] finalXY = Arrays.copyOf(xy, xy.length);
        int i = 0;
        while (i < n) {
            int count = 0;
            while (Character.isDigit(str.charAt(i))) {
                count = count * 10 + (str.charAt(i) - '0');
                i++;
            }
            if (str.charAt(i) == 'x' || !Character.isLetter(str.charAt(i))) {
                i++;
            }
            if (count == 0) count++;
            if (Character.isLetter(str.charAt(i))) {
                if (str.charAt(i) == 'U') finalXY[1] += count;
                if (str.charAt(i) == 'D') finalXY[1] -= count;
                if (str.charAt(i) == 'R') finalXY[0] += count;
                if (str.charAt(i) == 'L') finalXY[0] -= count;
                i++;
            }
        }
        return finalXY;
    }
}
