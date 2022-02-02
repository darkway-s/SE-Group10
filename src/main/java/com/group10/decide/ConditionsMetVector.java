package com.group10.decide;

import java.lang.Math;
import java.util.Set;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Arrays;

public class ConditionsMetVector {
    ParameterManager pm;
    int length;
    Vector<Boolean> conditionsMetVector;

    /**
     * Constructor that sets both length of the vector and the parameter manager
     * holding all the relevant parameters
     * 
     * @param length length of the vector
     * @param pm     Parameter manager
     */
    public ConditionsMetVector(int length, ParameterManager pm) {
        this.length = length;
        this.pm = pm;
    }

    /**
     * Constructor that only sets the length of the vector
     * 
     * @param length length of the vector
     */
    public ConditionsMetVector(int length) {
        this.length = length;
    }

    /**
     * Constructor that only sets the parameter manager
     * 
     * @param pm length of the vector
     */
    public ConditionsMetVector(ParameterManager pm) {
        this.pm = pm;
    }

    /**
     * Sets the parameter manager
     * 
     * @param pm ParameterManager that manages all parameters
     */
    public void setParameterManager(ParameterManager pm) {
        this.pm = pm;
    }

    /**
     * There exists at least one set of two consecutive data points
     * that are a distance greater than LENGTH1. (0 ≤ LENGTH1)
     * 
     * @return Boolean. True if there exists two consecutive data points, otherwise
     *         False
     */
    public Boolean LIC0() {
        int siz = this.pm.getNumPoints();
        Vector<Point> pointsArray = this.pm.getPoints();
        double length1 = this.pm.getLICParameter().getLength1();
        for (int i = 0; i < siz - 1; i++) {
            if (pointsArray.getValue(i).distance(pointsArray.getValue(i + 1)) > length1)
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Computes the 1st Launch Interceptor Condition
     * There exists at least one set of three consecutive data points that cannot
     * all be contained
     * within or on a circle of radius RADIUS1.
     * 
     * @return Boolean
     */
    public Boolean LIC1(double radius1, Vector<Point> points) {
        int size = points.length();
        // We need to compare 3 consecutive points, so if we have 2, return FALSE
        if (size < 3) {
            return Boolean.FALSE;
        }
        for (int i = 0; i < size - 2; i++) {
            double minimalRadius = points.getValue(i).minimalRadiusFromThreePoints(points.getValue(i + 1),
                    points.getValue(i + 2));
            // if these three points cannot be contained in a circle of radius radius1,
            if (radius1 < minimalRadius) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    /**
     * Computes the 2nd Launch Interceptor Condition
     * True if there exists 3 consecutive points that form an angle such that:
     * angle < PI - EPSILON
     * angle > PI + EPSILON
     * where the second point is the vertex of the angle. The angle is calculated
     * using the law of cosines.
     *
     * If either the first point or the last point (or both) coincides with the
     * vertex, the angle is undefined
     *
     * @return Boolean
     */
    public boolean LIC2(double epsilon, Vector<Point> points) {
        if (epsilon < 0 || epsilon > Math.PI || points.length() < 3)
            return false;

        for (int i = 1; i < points.length() - 1; i++) {
            Point p1 = points.getValue(i - 1);
            Point p2 = points.getValue(i);
            Point p3 = points.getValue(i + 1);
            if (!p1.hasSameLocation(p2) || !p3.hasSameLocation(p2)) {
                double a = p2.distance(p1);
                double b = p2.distance(p3);
                double c = p1.distance(p3);
                double angle = Math
                        .acos(Math.toRadians(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2) / (2 * a * b)));

                if (angle < (Math.PI - epsilon) || angle > (Math.PI + epsilon))
                    return true;
            }
        }

        return false;
    }

    /**
     * Computes the 3rd Launch Interceptor Condition
     * True if there exists 3 consecutive points that form the vertices of a
     * triangle and that triangle has an area greater than pm.AREA1
     *
     * @return Boolean
     */
    public Boolean LIC3() {
        Point pointOne, pointTwo, pointThree;
        Vector<Point> points = pm.getPoints();
        double area;
        for (int i = 0; i < pm.getNumPoints() - 2; i++) {
            pointOne = points.getValue(i);
            pointTwo = points.getValue(i + 1);
            pointThree = points.getValue(i + 2);
            area = pointOne.triangleArea(pointTwo, pointThree);
            if (area > pm.getLICParameter().getArea1()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * Checking that at least one set of qPts number of consecutive points lies
     * in more than quads number of quadrants.
     * 
     * @return Boolean True if there exist at least one set. False if not.
     */
    public Boolean LIC4(Vector<Point> points, int qPts, int quads) {
        int length = points.length();
        // Going through each point and checking if the nr of unique quadrants
        // represented by the point is more than quads
        for (int i = 0; i < length - qPts + 1; i++) {
            Set<Integer> uniqeQuadrants = new HashSet<Integer>();
            for (int j = 0; j < qPts; j++) {
                if (points.getValue(i + j).getX() >= 0 && points.getValue(i + j).getY() >= 0) {
                    uniqeQuadrants.add(1);
                }
                if (points.getValue(i + j).getX() < 0 && points.getValue(i + j).getY() >= 0) {
                    uniqeQuadrants.add(2);
                }
                if (points.getValue(i + j).getX() <= 0 && points.getValue(i + j).getY() < 0) {
                    uniqeQuadrants.add(3);
                }
                if (points.getValue(i + j).getX() > 0 && points.getValue(i + j).getY() < 0) {
                    uniqeQuadrants.add(4);
                }
            }
            if (uniqeQuadrants.size() > quads) {
                return true;
            }
        }
        return false;
    }

    /**
     * There exists at least one set of two consecutive data points, (X[i],Y[i]) and
     * (X[j],Y[j]),
     * such that X[j] - X[i] < 0. (where i = j-1)
     * 
     * @param points the points
     * @return Boolean if such a set exists.
     */
    public Boolean LIC5(Vector<Point> points) {
        int siz = points.length();
        for (int i = 0; i < siz - 1; i++) {
            if (points.getValue(i + 1).getX() - points.getValue(i).getX() < 0)
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Computes the 6th Launch Interceptor Condition
     * True if there, amongst nPts (p_i, p_i+1, pi+2, p_i+3) consecutive points,
     * exist a distance from
     * p_i+1, p_i+2 to the line formed by p_i and p_i+3 such that the distance >
     * dist
     * 
     * @param dist   the distance to compare to
     * @param nPts   number of consecutive points
     * @param numPts number of points in total
     * @param points the points
     * @return Boolean if such a distance exists.
     */
    public boolean LIC6(int nPts, int numPts, double dist, Vector<Point> points) {
        if (numPts < 3)
            return false;
        if (nPts < 3 || nPts > numPts || dist < 0)
            throw new InputMismatchException(
                    "N_PTS must greater or equal to 3 and less or equal to NUM_POINTS. DIST cannot be less than 0.");

        int max = nPts == numPts ? points.length() - nPts + 1 : points.length() - nPts;

        for (int i = 0; i < max; i++) {
            Point[] nConsecutivePoints = Arrays.copyOfRange(points.getValues(), i, i + nPts);
            for (int j = 0; j < nConsecutivePoints.length; j++) {
                Point first = nConsecutivePoints[0];
                Point last = nConsecutivePoints[nConsecutivePoints.length - 1];

                if (first.hasSameLocation(last)) {
                    for (int k = j + 1; k < (i + nPts - 1); k++)
                        if (nConsecutivePoints[k].distance(first) > dist)
                            return true;
                } else {
                    for (int k = j + 1; k < (i + nPts - 1); k++)
                        if (nConsecutivePoints[k].distanceToLine(first, last) > dist)
                            return true;
                }
            }
        }

        return false;
    }

    /**
     * Computes the 7th Launch Interceptor Condition
     * True if there exists two points, separated by KPts intervening points, that
     * are LENGTH1 distance apart
     *
     * @return Boolean
     */
    public Boolean LIC7() {
        if (pm.getNumPoints() < 3) {
            return Boolean.FALSE;
        }

        Vector<Point> points = pm.getPoints();
        int KPts = pm.getLICParameter().getKPts();
        double Length1 = pm.getLICParameter().getLength1();
        for (int i = 0; i < pm.getNumPoints() - KPts - 1; i++) {
            if (points.getValue(i).distance(points.getValue(i + KPts + 1)) > Length1) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * There exists at least one set of three data points separated by exactly A_PTS
     * and B_PTS
     * consecutive intervening points, respectively, that cannot be contained within
     * or on a circle of
     * radius RADIUS1.
     * The condition is not met when the nr of points is less than 5.
     * 
     * @return if the conditions are met or not
     */
    public Boolean LIC8(Vector<Point> points, int aPts, int bPts, double radius1) {
        int nrPoints = points.length();
        if (nrPoints < 5) {
            return false;
        }
        Boolean result = true;
        // Checking for the three points
        for (int i = 0; i < nrPoints - aPts - bPts - 2; i++) {
            Point p1 = points.getValue(i);
            Point p2 = points.getValue(i + aPts + 1);
            Point p3 = points.getValue(i + aPts + bPts + 2);
            // Checking if the points are on the same circle
            if (p1.distance(p2) <= radius1 && p2.distance(p3) <= radius1 && p1.distance(p3) <= radius1) {
                result = false;
            }
        }
        return result;
    }

    /**
     * @return Boolean
     */
    public Boolean LIC9(double epsilon, int cPts, int dPts, Vector<Point> points) {
        if (epsilon < 0 || epsilon > Math.PI || cPts < 1 || dPts < 1 || cPts + dPts > points.length() - 3
                || points.length() < 5)
            return false;

        for (int i = 0; i < points.length() - (cPts + dPts + 2); i++) {
            Point p1 = points.getValue(i);
            Point p2 = points.getValue(i + cPts + 1);
            Point p3 = points.getValue(i + cPts + dPts + 2);
            if (!p1.hasSameLocation(p2) || !p3.hasSameLocation(p2)) {
                double a = p2.distance(p1);
                double b = p2.distance(p3);
                double c = p1.distance(p3);
                double angle = Math
                        .acos(Math.toRadians(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2) / (2 * a * b)));

                if (angle < (Math.PI - epsilon) || angle > (Math.PI + epsilon))
                    return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    /**
     * There exists at least one set of three data points separated by exactly
     * E_PTS and F_PTS consecutive intervening points, respectively, that are
     * the vertices of a triangle with area greater than AREA1. The condition
     * is not met when NUMPOINTS < 5
     * 
     * @return Boolean If condition is met or not.
     */
    public Boolean LIC10(Vector<Point> points, int ePts, int fPts, double area1) {
        if (points.length() < 5)
            return false;
        // Iterate through all the points
        for (int i = 0; i < points.length() - (ePts + fPts + 2); i++) {
            // Get the three points
            Point p1 = points.getValue(i);
            Point p2 = points.getValue(i + ePts + 1);
            Point p3 = points.getValue(i + ePts + fPts + 2);

            // Checking the area of the triangle
            double area = p1.triangleArea(p2, p3);
            if (area > area1) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return Boolean
     */
    public Boolean LIC11() {
        return Boolean.FALSE;
    }

    /**
     * Computes the 12th Launch Interceptor Condition
     *
     * There exists at least one set of two data points, separated by exactly K PTS
     * consecutive
     * intervening points, which are a distance greater than the length, LENGTH1,
     * apart. In addi-
     * tion, there exists at least one set of two data points (which can be the same
     * or different from
     * the two data points just mentioned), separated by exactly K PTS consecutive
     * intervening
     * points, that are a distance less than the length, LENGTH2, apart. Both parts
     * must be true
     * for the LIC to be true.
     * 
     * The condition is not met when NUMPOINTS < 3.
     *
     * @return Boolean
     */
    public Boolean LIC12(int kPts, double length1, double length2, Vector<Point> points) {
        if (kPts < 1 || points.length() < kPts + 2 || points.length() < 3)
            return Boolean.FALSE;

        Boolean part1 = Boolean.FALSE;
        Boolean part2 = Boolean.FALSE;

        for (int i = 0; i < points.length() - (kPts + 1); i++) {
            Point p1 = points.getValue(i);
            Point p2 = points.getValue(i + kPts + 1);
            if (p1.distance(p2) > length1) {
                part1 = Boolean.TRUE;
            }
            if (p1.distance(p2) < length2) {
                part2 = Boolean.TRUE;
            }
        }

        // both parts should be true to get true
        return part1 && part2;
    }

    /**
     * Computes the 13th Launch Interceptor Condition
     * This condition has two subcondition
     * (1) three points separated by aPts and bPts cannot be contained within or on
     * a circle with radius radius1
     * (2) three points separated by aPts and bPts can be contained within or on a
     * circle with radius2
     * If both are true, the condition is satisfied.
     * 
     * @param aPts    no. of. consecutive points between point 1 and point 2
     * @param bPts    no. of. consecutive points between point 2 and point 3
     * @param radius1 radius of the circle for the first subcondition
     * @param radius2 radius of the circle for the second subcondition
     * @param points  the points
     * @return If condition is satisfied or not.
     */
    public boolean LIC13(int aPts, int bPts, double radius1, double radius2, Vector<Point> points) {
        if (radius1 < 0 || radius2 < 0 || points.length() < 5 || (aPts + bPts + 2) > points.length())
            return false;

        boolean conditionNotOnRadius1 = false;
        boolean conditionOnRadius2 = false;

        for (int i = 0; i < (points.length() - (aPts + bPts + 2)); i++) {
            Point a = points.getValue(i);
            Point b = points.getValue(i + aPts + 1);
            Point c = points.getValue(i + aPts + bPts + 2);

            double minimalRadius = a.minimalRadiusFromThreePoints(b, c);

            if (minimalRadius > radius1)
                conditionNotOnRadius1 = true;
            if (minimalRadius <= radius2)
                conditionOnRadius2 = true;
        }

        return conditionNotOnRadius1 && conditionOnRadius2;
    }

    /**
     * <h3>Computes the 14th Launch Interceptor Condition</h3>
     *
     * <b>True</b> if there exists three points separated by EPts and FPts
     * intervening points that form the vertices of
     * a triangle with an area greater than area1 and three more points that are
     * separated by the same conditions
     * but could be the same which form the vertices of a triangle with an area less
     * than area2. <b>False</b> otherwise.
     *
     * @return Boolean
     */
    public Boolean LIC14() {
        if (pm.getNumPoints() < 5) {
            return Boolean.FALSE;
        }

        Point pointOne, pointTwo, pointThree;
        Vector<Point> points = pm.getPoints();
        LICParameter lic = pm.getLICParameter();
        double area,
                area1 = lic.getArea1(),
                area2 = lic.getArea2();
        int EPts = lic.getEPts(),
                FPts = lic.getFPts();
        boolean greaterThanArea1 = false,
                lesserThanArea2 = false;
        for (int i = 0; i < pm.getNumPoints() - EPts - FPts - 2; i++) {
            pointOne = points.getValue(i);
            pointTwo = points.getValue(i + EPts + 1);
            pointThree = points.getValue(i + EPts + FPts + 2);
            area = pointOne.triangleArea(pointTwo, pointThree);
            if (area > area1) {
                greaterThanArea1 = true;
            }
            if (area < area2) {
                lesserThanArea2 = true;
            }
            if (greaterThanArea1 && lesserThanArea2) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * @return Vector<Boolean>
     */
    public Vector<Boolean> getConditionsMetVector() {
        return this.conditionsMetVector;
    }
}
