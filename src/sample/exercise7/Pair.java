package sample.exercise7;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Pair {
    private final Point2D p1;
    private final Point2D p2;

    public Pair(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public static double distance(Point2D p1, Point2D p2) {
        return p1.distance(p2);
    }

    public static double distance(double x1, double y1,
                                  double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) - Math.pow(y1 - y2, 2));
    }

    private static Point2D[] fromDoubleToPoints(double[][] points) {
        Point2D[] points2D = new Point2D[points.length];
        for (int i = 0; i < points.length; i++)
            points2D[i] = new Point2D(points[i][0], points[i][1]);
        return points2D;
    }

    public static Pair getClosestPair(double[][] points) {
        return getClosestPair(fromDoubleToPoints(points));
    }

    public static Pair getClosestPair(Point2D[] points) {
        Point2D[] pointsOrderedOnX = Arrays.copyOf(points, points.length);
        Arrays.sort(pointsOrderedOnX, Comparator.comparingDouble(Point2D::getX).thenComparingDouble(Point2D::getY));
        Point2D[] pointsOrderedOnY = Arrays.copyOf(points, points.length);
        Arrays.sort(pointsOrderedOnY, Comparator.comparingDouble(Point2D::getY).thenComparingDouble(Point2D::getX));
        return distance(pointsOrderedOnX, 0, points.length, pointsOrderedOnY);
    }

    public static Pair distance(Point2D[] pointsOrderedOnX, int low, int high, Point2D[] pointsOrderedOnY) {
        if (low == high || high - low == 1) {
            return Pair.getMaximum();
        }
        if (high - low == 2)
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high - 1]);
        final int medium = (low + high) / 2;
        Pair pair1 = distance(pointsOrderedOnX, low, medium, pointsOrderedOnY);
        Pair pair2 = distance(pointsOrderedOnX, medium, high, pointsOrderedOnY);
        Pair nearest = pair1.getDistance() < pair2.getDistance() ? pair1 : pair2;
        double d = nearest.getDistance();
        Point2D mid = pointsOrderedOnX[medium];

        ArrayList<Point2D> stripR = new ArrayList<>();
        ArrayList<Point2D> stripL = new ArrayList<>();
        for (Point2D p : pointsOrderedOnY)
            if (pointIsIn(p, pointsOrderedOnX, low, medium) && mid.getX() - p.getX() <= d)
                stripL.add(p);
            else if (pointIsIn(p, pointsOrderedOnX, medium, high) && p.getX() - mid.getX() <= d)
                stripR.add(p);

        int r = 0; // r is the index of a point in stripR
        for (Point2D p : stripL) {
            while (r < stripR.size() && stripR.get(r).getY() <= p.getY() - d)
                r++;

            int r1 = r;
            while (r1 < stripR.size() && Math.abs(stripR.get(r1).getY() - p.getY()) <= d) {
                final double distance = distance(p, stripR.get(r1));
                if (distance < d) {
                    d = distance;
                    nearest = new Pair(p, stripR.get(r1));
                }
                r1++;
            }
        }
        return nearest;
    }

    private static boolean pointIsIn(Point2D point, Point2D[] point2DS, int from, int to) {
        for (int i = from; i < to; i++)
            if (point == point2DS[i])
                return true;
        return false;
    }

    private static Pair getMaximum() {
        return new Pair(Point2D.ZERO, new Point2D(Integer.MAX_VALUE / 2.0, Integer.MAX_VALUE / 2.0));
    }

    public double getDistance() {
        return p1.distance(p2);
    }
}
