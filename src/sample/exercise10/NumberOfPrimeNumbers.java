package sample.exercise10;

import java.io.*;

public class NumberOfPrimeNumbers {
    public static void main(String[] args) {
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(
                new FileInputStream("/home/d9nich/IdeaProjects/Section22/src/binary/primeNumbers.dat")))) {
            int counter = 0;

            for (int maxNumber = 12; maxNumber < 1_200_000_000; maxNumber *= 10) {
                while (true) {
                    long number = input.readLong();
                    if (number > maxNumber)
                        break;
                    ++counter;
                }
                System.out.println("Less than " + maxNumber + " = " + (counter++));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (EOFException ex) {
            System.out.println("EOF");
        } catch (IOException ex) {
            System.out.println("Error of stream!");
        }

    }
}
