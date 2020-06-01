package sample.exercise14;

import java.util.Arrays;

public class ExecutionTimeOfPrimeNumbers {
    public static void primeNumbersListing5(int n) {
        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        System.out.println("The prime numbers are:");

        // Repeatedly find prime numbers
        while (number <= n) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // Test if number is prime
            for (int divisor = 2; divisor <= (int) (Math.sqrt(number));
                 divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                count++; // Increase the count

                if (count % NUMBER_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    System.out.printf("%7d\n", number);
                } else
                    System.out.printf("%7d", number);
            }

            // Check if the next number is prime
            number++;
        }
    }

    public static void primeNumbersListing6(int n) {
        java.util.List<Integer> list =
                new java.util.ArrayList<>();

        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        int squareRoot = 1; // Check whether number <= squareRoot

        System.out.println("The prime numbers are \n");

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
                if (count % NUMBER_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    System.out.println(number);
                } else
                    System.out.print(number + " ");
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

        final int NUMBER_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers found so far
        // Print prime numbers
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
                if (count % NUMBER_PER_LINE == 0)
                    System.out.printf("%7d\n", i);
                else
                    System.out.printf("%7d", i);
            }
        }
    }
}
