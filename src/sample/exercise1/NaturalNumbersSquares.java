package sample.exercise1;

public class NaturalNumbersSquares {
    public static void main(String[] args) {
        showSequenceSquare(10);
    }

    private static void showSequenceSquare(int number) {
        int previousSquare = 1;
        for (int i = 0; i <= number; i++) {
            previousSquare += (i << 1) - 1;
            System.out.println(i + "^2 = " + previousSquare);
        }
    }
}
