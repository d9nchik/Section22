package sample.exercise24;

import java.util.Arrays;
import java.util.Random;

public class SmallestNumber {
    public static <E extends Comparable<E>> E smallest(E[] array) {
        return smallest(array, 0, array.length);
    }

    private static <E extends Comparable<E>> E smallest(E[] array, int from, int to) {
        if (to - from == 1)
            return array[from];
        int middle = (from + to) / 2;
        E a = smallest(array, from, middle);
        E b = smallest(array, middle, to);
        if (a.compareTo(b) < 0)
            return a;
        return b;
    }

    public static void main(String[] args) {
        Integer[] integers = generateMatrix(10);
        System.out.println(Arrays.toString(integers));
        System.out.println(smallest(integers));
    }

    private static Integer[] generateMatrix(int size) {
        Random random = new Random();
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt(21) - 10;
        }
        return integers;
    }
}
