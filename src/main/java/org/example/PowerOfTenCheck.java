package org.example;

public class PowerOfTenCheck {

    public static boolean isPowerOfTen(long n) {
        if (n <= 0) return false;

        double logValue = Math.log10(n);
        System.out.println("Double value = " + logValue);
        double size = Math.log10(n);
        System.out.println("Size-1 = " + size);
        double powerTen = Math.pow(10, size);
        System.out.println("Power Ten = " + powerTen);
        System.out.println("Remainder = " + n % (Math.pow(10, size)));
//        return n % (Math.pow(10, size)) == 0;

//        System.out.println("Rounded value = " + Math.round(logValue));
//        // check if logValue is very close to an integer (to handle floating point errors)
        return Math.abs(logValue - Math.round(logValue)) < 1e-10;
    }

    public static void main(String[] args) {
//        System.out.println(isPowerOfTen(1));     // true (10^0)
//        System.out.println(isPowerOfTen(10));    // true (10^1)
        System.out.println(isPowerOfTen(1000000000));   // true (10^2)
        System.out.println(isPowerOfTen(2000));    // false
//        System.out.println(isPowerOfTen(0));     // false
    }
}