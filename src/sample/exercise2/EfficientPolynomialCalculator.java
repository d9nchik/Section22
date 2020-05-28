package sample.exercise2;

import java.util.Scanner;

public class EfficientPolynomialCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = input.nextInt();
        System.out.print("Enter x: ");
        double x = input.nextDouble();

        double[] a = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            System.out.print("Enter a" + i + ": ");
            a[i] = input.nextDouble();
        }

        double result = 0;
        for (int i = a.length - 1; i >= 0; i--)
            result = result * x + a[i];
        System.out.printf("f(%.6f) = %.6f", x, result);
    }
}
