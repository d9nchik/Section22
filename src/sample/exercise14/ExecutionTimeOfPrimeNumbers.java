package sample.exercise14;

import java.util.Arrays;

public class ExecutionTimeOfPrimeNumbers {
    public static void primeNumbersListing5(int n) {
        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        // Repeatedly find prime numbers
        while (number <= n) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // Test if number is prime
            for (int divisor = 2; divisor <= (int) (Math.sqrt(number));
                 divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    break; // Exit the for loop
                }
            }

            // Check if the next number is prime
            number++;
        }
    }

    public static void primeNumbersListing6(int n) {
        java.util.List<Integer> list =
                new java.util.ArrayList<>();

        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot


        // Repeatedly find prime numbers
        while (number <= n) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            if (squareRoot * squareRoot < number) squareRoot++;

            // Test whether number is prime
            for (int k = 0; k < list.size()
                    && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) { // If true, not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                count++; // Increase the count
                list.add(number); // Add a new prime to the list
            }

            // Check whether the next number is prime
            number++;
        }
    }

    public static void primeNumbersListing7(int n) {
        boolean[] primes = new boolean[n + 1]; // Prime number sieve

        // Initialize primes[i] to true
        Arrays.fill(primes, true);

        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false; // k * i is not prime
                }
            }
        }

    }

    private static final int[] testNumbers = {9, 11, 13, 15, 17, 19};

    private static void showTable(PrimeNumbers primeNumbers) {

        for (int testNumber : testNumbers) {
            long startTime = System.currentTimeMillis();
            primeNumbers.calculate(testNumber * 1_000_000);
            System.out.printf("%-9d", (System.currentTimeMillis() - startTime));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.printf("%-13s", "");
        for (int number : testNumbers) {
            System.out.printf("%-9d", number * 1_000_000);
        }
        System.out.println();
        System.out.printf("%-13s", "Listing 22.5");
        showTable(ExecutionTimeOfPrimeNumbers::primeNumbersListing5);
        System.out.printf("%-13s", "Listing 22.6");
        showTable(ExecutionTimeOfPrimeNumbers::primeNumbersListing6);
        System.out.printf("%-13s", "Listing 22.7");
        showTable(ExecutionTimeOfPrimeNumbers::primeNumbersListing7);
    }

    @FunctionalInterface
    interface PrimeNumbers {
        void calculate(int number);
    }


}
