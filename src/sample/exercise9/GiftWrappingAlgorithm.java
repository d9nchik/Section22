package sample.exercise9;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Scanner;

public class GiftWrappingAlgorithm {
    public static ArrayList<Point2D> getConvexHull(double[][] s) {
        Point2D[] point2DS = fromDoubleToPoints(s);
        ArrayList<Point2D> h = new ArrayList<>();
        h.add(findRightLowestPoint(point2DS));

        Point2D t1 = point2DS[0];
        while (true) {
            Point2D t0 = h.get(h.size() - 1);
            for (Point2D point : point2DS) {
                if (isOnRightSide(t0, t1, point))
                    t1 = point;
            }
            if (t1 == h.get(0))
                break;
            h.add(t1);
            t1 = t0;
        }
        return h;
    }

    private static Point2D[] fromDoubleToPoints(double[][] points) {
        Point2D[] points2D = new Point2D[points.length];
        for (int i = 0; i < points.length; i++)
            points2D[i] = new Point2D(points[i][0], points[i][1]);
        return points2D;
    }

    private static Point2D findRightLowestPoint(Point2D[] point2DS) {
        Point2D rightLowest = point2DS[0];
        double rightLowestIndex = rightLowest.getX() + rightLowest.getY();
        for (Point2D point : point2DS) {
            double tempIndex = point.getX() + point.getY();
            if (rightLowestIndex < tempIndex) {
                rightLowestIndex = tempIndex;
                rightLowest = point;
            }
        }
        return rightLowest;
    }

    private static boolean isOnRightSide(Point2D point1, Point2D point2, Point2D point3) {
        double result = (point2.getX() - point1.getX()) * (point3.getY() - point1.getY()) - (point3.getX() - point1.getX())
                * (point2.getY() - point1.getY());
        return result < 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many points are in the set? ");
        double[][] s = new double[input.nextInt()][2];

        System.out.print("Enter " + s.length + " points: ");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                s[i][j] = input.nextDouble();
            }
        }

        System.out.println("The convex hull is ");
        System.out.println(getConvexHull(s));
    }
}
