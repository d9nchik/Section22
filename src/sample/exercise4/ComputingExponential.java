package sample.exercise4;

public class ComputingExponential {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println("exp(1.0, " + i + ") = " + exp(1, i));
        }
    }

    public static double exp(double x, int n) {
        double previousAdding = 1;
        double exp = previousAdding;
        for (int i = 1; i <= n; i++) {
            previousAdding *= x / i;
            exp += previousAdding;
        }
        return exp;
    }
}
