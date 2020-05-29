package sample.exercise6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ExecutionTimeForGCD {
    /**
     * Find GCD for integers m and n
     */
    public static long gcd(long m, long n) {
        long gcd = 1;

        if (m % n == 0) return n;

        for (long k = n / 2; k >= 1; k--) {
            if (m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }

        return gcd;
    }

    public static long gcdEuclid(long m, long n) {
        if (m % n == 0)
            return n;
        return gcdEuclid(n, m % n);
    }

    public static ArrayList<Long> fib(long n) {
        long f0; // For fib(0)
        long f1 = 1; // For fib(1)
        long f2 = 1; // For fib(2)

        if (n == 0)
            return new ArrayList<>();
        else if (n == 1)
            return new ArrayList<>(Collections.singletonList(f1));
        else if (n == 2)
            return new ArrayList<>(Arrays.asList(f1, f2));
        ArrayList<Long> longArrayList = new ArrayList<>(Arrays.asList(f1, f2));
        for (int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
            longArrayList.add(f2);
        }

        return longArrayList;
    }

    public static void main(String[] args) {
        ArrayList<Long> integersArrayList = fib(50);
        System.out.println(integersArrayList);
        System.out.printf("%24s", " ");
        for (int i = 46; i <= 50; i++)
            System.out.printf("%6d", i);
        System.out.printf("\n%-24s", "Listing 22.3 GCD");
        drawTable(ExecutionTimeForGCD::gcd, integersArrayList);
        System.out.printf("%-24s", "Listing 22.4 GCDEuclid");
        drawTable(ExecutionTimeForGCD::gcdEuclid, integersArrayList);
    }

    private static void drawTable(Calculator calculator, ArrayList<Long> integerArrayList) {
        for (int i = 45; i < 50; i++) {
            long startTime = System.currentTimeMillis();
            calculator.calculateGCD(integerArrayList.get(i - 1), integerArrayList.get(i));
            System.out.printf("%6d", (System.currentTimeMillis() - startTime));
        }
        System.out.println();
    }

    @FunctionalInterface
    interface Calculator {
        long calculateGCD(long m, long n);
    }
}
