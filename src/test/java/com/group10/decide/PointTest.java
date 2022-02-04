package com.group10.decide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Point class.
 */
public class PointTest {

    /**
     * Test if getX() returns the x-coordinate of a point.
     * */
    @Test
    @DisplayName("Get x coordinate")
    public void getX() {
        Point p = new Point(1, 2);
        assertEquals(1, p.getX(), "Expected 1");
    }

    /**
     * Test if getY() returns the y-coordinate of a point.
     * */
    @Test
    @DisplayName("Get y coordinate")
    public void getY() {
        Point p = new Point(1, 2);
        assertEquals(2, p.getY(), "Expected 2");
    }

    /**
     * Test if setX() sets the x-coordinate of a point.
     * */
    @Test
    @DisplayName("Set x coordinate")
    public void setX() {
        Point p = new Point(1, 2);
        p.setX(3);
        assertEquals(3, p.getX(), "Expected 3");
    }

    /**
     * Test if setY() returns the y-coordinate of a point.
     * */
    @Test
    @DisplayName("Set y coordinate")
    public void setY() {
        Point p = new Point(1, 2);
        p.setY(3);
        assertEquals(3, p.getY(), "Expected 3");
    }

    /**
     * Test if distance() calculates the distance between two
     * points correctly.
     * */
    @Test
    @DisplayName("Test euclidean distance")
    public void testEuclideanDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        assertEquals(Math.sqrt(2), p1.distance(p2), "Expected sqrt(2)");
    }

    /**
     * Test if triangleArea() calculates the area between three
     * points correctly.
     * */
    @Test
    @DisplayName("Test area of triangle")
    public void testTriangleArea() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 1);
        assertEquals(0.5, p1.triangleArea(p2, p3), "Expected 0.5");
    }

    /**
     * Test if twoPointsWithSameLocation() determines whether two points
     * are on the same location (have same x- and y-coordinate) correctly.
     * The two points have the same location, thus the funciton should
     * return true.
     * */
    @Test
    @DisplayName("Two points have the same x and y coordinate.")
    public void testTwoPointsWithSameLocation() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);
        assertEquals(true, p1.hasSameLocation(p2), "Expected to be true.");
    }

    /**
     * Test if twoPointsWithSameLocation() calculates the distance between two
     * points correctly. The two points do not have the same location, thus the funciton
     * should return false.
     * */
    @Test
    @DisplayName("Two points do not have the same x and y coordinate.")
    public void testTwoPointsWithNotSameLocation() {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(2, 3);
        assertEquals(false, p1.hasSameLocation(p2), "Expected to be false.");
    }

    /**
     * Test if distanceToLine() calculates the distance from one point
     * to the line created from two other points correctly.
     * */
    @Test
    @DisplayName("Distance from 1 point to the line created by two other points")
    public void testPointDistanceToLine() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 0);

        // Maximum accepted difference between actual and expected value. Difference is due to floating-point error
        double delta = 0.00000001;
        assertEquals(Math.sqrt(0.5), p1.distanceToLine(p2, p3), delta, "Expected to be sqrt(2)");
    }

    /**
     * Test if minimalRadiusFromThreePoints() calculates the radius created
     * from three points correctly.
     * */
    @Test
    @DisplayName("Minimal radius created by three points")
    public void testMinimalRadius() {
        Point p1 = new Point(1, -6);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(5, 2);

        // Maximum accepted difference between actual and expected value. Difference is due to floating-point error when using Math.PI
        double delta = 0.00000001;
        assertEquals(5, p1.minimalRadiusFromThreePoints(p2, p3), delta, "Expected to be 5");
    }
}
