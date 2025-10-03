package org.example;

import java.util.HashMap;
import java.util.Map;

public class LengthOfCycle {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        int len = countLengthOfCycle(arr, 0);
        int lenFloyd = countLengthOfCycleFloyd(arr, 0);
        System.out.println(lenFloyd + " = Length of cycle = " + len);
    }

    public static int countLengthOfCycle(int[] arr, int startIndex) {
        Map<Integer, Integer> visited = new HashMap<>();
        int current = startIndex;
        int steps = 0;

        while (current >= 0 && current < arr.length) {
            if (visited.containsKey(current)) {
                // Cycle found — difference in steps gives cycle length
                return steps - visited.get(current);
            }
            visited.put(current, steps);
            current = arr[current];
            steps++;
        }

        return -1; // No cycle (should not happen with problem constraints)
    }

    public static int countLengthOfCycleFloyd(int[] arr, int startIndex) {
        int slow = startIndex;
        int fast = startIndex;

        do {
            if (fast >= arr.length || arr[fast] >= arr.length) {
                return -1;
            }
            slow = arr[slow];
            fast = arr[arr[fast]];

        } while (slow != fast);

        int cycleLength = 1;
        int current = arr[slow];
        while (current != slow) {
            current = arr[current];
            cycleLength++;
        }

        return cycleLength;
    }
}
