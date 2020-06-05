package sample.exercise8;

import java.io.*;
import java.util.Arrays;

public class AllPrimeNumbers {
    private static final File FILE = new File("primeNumbers.dat");
    private static final int SIZE_OF_READ_BLOCK = 15_000_000;
    private static final long MAX_NUMBER = 10_000_000_000L;
    private static final int SIZE_OF_WRITE_BLOCK = 5_000_000;
    private static long[] primeNumbers = numbers(0);

    public static void main(String[] args) {

        // A list to hold prime numbers
        long[] array = new long[SIZE_OF_WRITE_BLOCK];

        int count = 0; // Count the number of prime numbers
        long number = startNumber() + 1; // A number to be tested for primeness
        long squareRoot = (long) Math.sqrt(number); // Check whether number <= squareRoot
        int position = 0;

        // Repeatedly find prime numbers
        while (number <= MAX_NUMBER) {
            // Assume the number is prime


            if (squareRoot * squareRoot < number) squareRoot++;

            boolean isPrime = isPrime(number, squareRoot);// Is the current number prime?


            // Test whether number is prime
            for (int k = 0; isPrime && k < position
                    && array[k] <= squareRoot; k++) {
                if (number % array[k] == 0) { // If true, not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                array[position++] = number;// Add a new prime to the list
                count++; // Increase the count
                if (count % SIZE_OF_WRITE_BLOCK == 0) {
                    // Print the number and advance to the new line
                    writeNumbers(array);
                    position = 0;
                }
            }

            // Check whether the next number is prime
            number++;
            if (number % 1_000_000 == 0)
                System.out.println(number / 1_000_000 + "*10^6");
        }

        writeNumbers(Arrays.copyOfRange(array, 0, position));
        System.out.println("\n" + count +
                " prime(s) less than or equal to " + MAX_NUMBER);
    }

    private static boolean isPrime(long number, long squareRoot) {
        int positionInFile = 0;
        int primeNumberPosition = 0;
        while (primeNumbers.length != 0 && primeNumbers[primeNumberPosition] <= squareRoot) {
            if (number % primeNumbers[primeNumberPosition] == 0) {
                if (positionInFile != 0)
                    primeNumbers = numbers(0);
                return false;
            }
            primeNumberPosition++;
            if (primeNumberPosition == primeNumbers.length) {
                positionInFile += SIZE_OF_READ_BLOCK;
                primeNumbers = numbers(positionInFile);
                primeNumberPosition = 0;
            }
        }
        if (positionInFile != 0)
            primeNumbers = numbers(0);
        return true;
    }

    private static long[] numbers(int pos) {
        try (RandomAccessFile input = new RandomAccessFile(FILE, "r")) {
            input.seek(pos * 8);
            int size = Math.min(SIZE_OF_READ_BLOCK, ((int) (input.length() / 8 - pos)));
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = input.readLong();
            }
            return array;
        } catch (IOException ex) {
            return new long[0];
        }//System.out.println("Problem with stream!");

    }

    private static long startNumber() {
        try (RandomAccessFile input = new RandomAccessFile(FILE, "r")) {
            input.seek(input.length() - 8);
            return input.readLong();
        } catch (FileNotFoundException ex) {
            return 1;
        } catch (IOException ex) {
            System.out.println("Problem with stream!");
            return 1;
        }
    }

    private static void writeNumbers(long[] numbers) {
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(FILE, true), 102_400))) {
            for (long number : numbers)
                output.writeLong(number);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Problem with stream!");
        }
        if (primeNumbers.length < SIZE_OF_WRITE_BLOCK)
            primeNumbers = numbers(0);
    }
}
