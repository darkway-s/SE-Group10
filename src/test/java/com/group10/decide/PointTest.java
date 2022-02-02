package com.group10.decide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Point class.
 */
public class PointTest {
    @Test
    @DisplayName("Get x coordinate")
    public void getX() {
        Point p = new Point(1, 2);
        assertEquals(1, p.getX(), "Expected 1");
    }
    @Test
    @DisplayName("Get y coordinate")
    public void getY() {
        Point p = new Point(1, 2);
        assertEquals(2, p.getY(), "Expected 2");
    }
    @Test
    @DisplayName("Set x coordinate")
    public void setX() {
        Point p = new Point(1, 2);
        p.setX(3);
        assertEquals(3, p.getX(), "Expected 3");
    }
    @Test
    @DisplayName("Set y coordinate")
    public void setY() {
        Point p = new Point(1, 2);
        p.setY(3);
        assertEquals(3, p.getY(), "Expected 3");
    }
    @Test
    @DisplayName("Test euclidean distance")
    public void testEuclideanDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        assertEquals(Math.sqrt(2), p1.distance(p2), "Expected sqrt(2)");
    }

    @Test
    @DisplayName("Two points have the same x and y coordinate.")
    public void testTwoPointsWithSameLocation() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);
        assertEquals(true, p1.hasSameLocation(p2), "Expected to be true.");
    }

    @Test
    @DisplayName("Two points do not have the same x and y coordinate.")
    public void testTwoPointsWithNotSameLocation() {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(2, 3);
        assertEquals(false, p1.hasSameLocation(p2), "Expected to be false.");
    }
}
