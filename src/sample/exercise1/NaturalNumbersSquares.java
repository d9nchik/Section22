package sample.exercise1;

public class NaturalNumbersSquares {
    public static void main(String[] args) {
        showSequenceSquare(15);
        showSequenceCube(15);
    }

    private static void showSequenceSquare(int number) {
        int previousSquare = 1;
        for (int i = 0; i <= number; i++) {
            previousSquare += (i << 1) - 1;
            System.out.println(i + "^2 = " + previousSquare);
        }
    }

    private static void showSequenceCube(int number) {
        int previousSquare = 1;
        int previousCube = -1;
        for (int i = 0; i <= number; i++) {
            previousCube += previousSquare * 3 + i * 3 - 2;
            previousSquare += (i << 1) - 1;
            System.out.println(i + "^3 = " + previousCube);
        }
    }
}
