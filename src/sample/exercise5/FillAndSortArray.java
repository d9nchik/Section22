package sample.exercise5;

import java.util.Random;
import java.util.Scanner;

public class FillAndSortArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a size: ");
        int size = input.nextInt();
        int[] array = fill(size);
        showArray(array);
        sort(array);
        showArray(array);
    }

    private static int[] fill(int size) {
        int[] numbers = {-1, 0, 1};
        Random random = new Random();
        int[] out = new int[size];
        for (int i = 0; i < out.length; i++)
            out[i] = numbers[random.nextInt(numbers.length)];
        return out;
    }

    private static void sort(int[] array) {//insert sort. Worst case O(n^2)
        for (int i = 1; i < array.length; i++) {
            int position = i;
            int value = array[i];
            while (position > 0 && value < array[position - 1]) {
                array[position] = array[position - 1];
                position--;
            }
            array[position] = value;
        }
    }

    private static void showArray(int[] array) {
        for (int integer : array)
            System.out.print(integer + " ");
        System.out.println();
    }
}
