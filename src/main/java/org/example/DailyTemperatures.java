package org.example;

/*
    ✅ Key Idea:
    Monotonic stack
    We maintain the stack in decreasing order of temperature values.
    For each temperature, we pop all previous colder temps (whose index is on stack) and
    update their waiting days.

    The algorithm will:
    Push indices onto stack as long as temps are not increasing.
    Once it finds a warmer temperature,
    it resolves all previous colder temps in the stack and sets their waiting time (i - prevIndex).
 */

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res;
        res = dailyTemperatures(temp);
        System.out.println("Res array = " + Arrays.toString(res));
    }

    private static int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
//        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int prevIdx = stack.pop();
                res[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }

        return res;
    }
}
