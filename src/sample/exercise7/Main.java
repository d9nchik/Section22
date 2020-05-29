package sample.exercise7;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[][] pair = generatePairs(5);
        System.out.println(Arrays.deepToString(pair));
        System.out.println(Pair.getClosestPair(pair).getDistance());
    }

    private static double[][] generatePairs(int size) {
        double[][] pairs = new double[size][2];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2; j++) {
                pairs[i][j] = random.nextInt(10);
            }
        }
        return pairs;
    }
}
