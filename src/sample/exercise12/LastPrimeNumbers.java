package sample.exercise12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LastPrimeNumbers {
    private static final int COUNT_OF_LAST_NUMBERS = 100;

    public static void main(String[] args) {
        try (RandomAccessFile input = new RandomAccessFile("src/binary/primeNumbers.dat", "r")) {
            input.seek(input.length() - COUNT_OF_LAST_NUMBERS * 8);
            while (input.getFilePointer() != input.length())
                System.out.println(input.readLong());
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Stream problem");
        }
    }
}
