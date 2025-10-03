package org.example;

/*
    1052. Grumpy Bookstore Owner
    There is a bookstore owner that has a store open for n minutes. You are given an integer array customers of length n where customers[i] is the number of the customers that enter the store at the start of the ith minute and all those customers leave after the end of that minute.

    During certain minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
       When the bookstore owner is grumpy, the customers entering during that minute are not satisfied. Otherwise, they are satisfied.
        The bookstore owner knows a secret technique to remain not grumpy for minutes consecutive minutes, but this technique can only be used once.
         Return the maximum number of customers that can be satisfied throughout the day.
 */

public class SlideWindowLC1052Grumpy {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        int satisfied = returnSatisfiedCustomers(customers, grumpy, minutes);
        System.out.println("Total Satisfied = " + satisfied);
    }

    private static int returnSatisfiedCustomers(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        System.out.println("Initial Total = " + total);

        int tempAdd = 0;
        int maxAdd = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                tempAdd += customers[minutes];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                tempAdd -= customers[i - minutes];
            }

            maxAdd = Math.max(maxAdd, tempAdd);
        }

        return total + maxAdd;
    }
}
