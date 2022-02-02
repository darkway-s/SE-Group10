package com.group10.decide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for ConditionsMetVector.
 */
public class ConditionsMetVectorTest {

    static String pathToTestFiles;
    ConditionsMetVector cmv;
    ParameterManager pm;

    /**
     * Instantiate a new ParameterManager object used for testing.
     * */
    @BeforeAll
    public static void setUp() {
        pathToTestFiles = "test-inputs/";
    }

    @Test
    @DisplayName("LIC1 true case")
    public void LIC1true() {
        pm = new ParameterManager(pathToTestFiles + "test-3p-LIC1true.txt");
        cmv = new ConditionsMetVector(15, pm);
        assertEquals(Boolean.TRUE, cmv.LIC1(), "LIC1 should be true, radius: 4, points: {{0, -5}, {-3, 4}, {3, 4}} minimal radius is 5");
    }

    @Test
    @DisplayName("LIC1 edge false case")
    public void LIC1EdgeFalse() {
        pm = new ParameterManager(pathToTestFiles + "test-3p-LIC1edgefalse.txt");
        cmv = new ConditionsMetVector(15, pm);
        assertEquals(Boolean.FALSE, cmv.LIC1(), "LIC1 should be false, radius: 5, points: {{0, -5}, {-3, 4}, {3, 4}} minimal radius is 5, points are ON the circle");
    }

    @Test
    @DisplayName("LIC1 false case")
    public void LIC1false() {
        pm = new ParameterManager(pathToTestFiles + "test-3p-LIC1false.txt");
        cmv = new ConditionsMetVector(15, pm);
        assertEquals(Boolean.FALSE, cmv.LIC1(), "LIC1 should be false, radius: 6, points: {{0, -5}, {-3, 4}, {3, 4}} minimal radius is 5");
    }

    /**
     * Test for LIC 2
     * */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 2.")
    class TestLIC2 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }

        /**
         * Test if LIC2 returns true if angle < (pi - epsilon)
         * */
        @Test
        @DisplayName("LIC2 positive case, angle < (pi - epsilon)")
        public void LIC2positiveAngleLess() {

            // 90 deg --> pi/2 rad ~ 1.6
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(2, 1);
            // epsilon = 1 --> pi - eps = 2.14, => angle < pi - eps
            double eps = 1.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC2(eps, p), "Expected to be true.");
        }

        /**
         * Test if LIC2 returns true if angle > (pi + epsilon)
         * */
        @Test
        @DisplayName("LIC2 positive case, angle > (pi + epsilon)")
        public void LIC2positiveAngleGreater() {
            // 180 deg --> 3/2*pi rad ~ 4.7
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(2, -1);
            // epsilon = 1 --> pi + eps = 3.15, => angle > pi + eps
            double eps = 0.01;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC2(eps, p), "Expected to be true.");
        }

        /**
         * Test if LIC2 returns false if angle < (pi + epsilon)
         * */
        @Test
        @DisplayName("LIC2 negative case, angle < (pi + epsilon)")
        public void LIC2negativeLess() {
            // 90 deg --> pi/2 rad ~ 1.6
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(2, 1);
            // epsilon = 3, (pi - eps = 0.14, pi + eps = 6.14)
            // => (angle > (pi + epsilon)) && (angle < (pi - epsilon)) (should return false)
            double eps = 3;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(false, cmv.LIC2(eps, p), "Expected to be false.");
        }

        /**
         * Test if LIC2 returns false if nr of points < 3
         * */
        @Test
        @DisplayName("LIC2 negative case, if nr of points is < 3")
        public void LIC2negativeNoOfPoints() {
            cmv = new ConditionsMetVector(15);
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);

            Point[] vals = new Point[]{p1, p2};
            Vector<Point> p = new Vector<Point>(2, vals);
            assertEquals(false, cmv.LIC2(1, p), "Expected to be false.");
        }

    }

    @Test
    @DisplayName("LIC3 true case")
    public void LIC3True() {
        pm = new ParameterManager(pathToTestFiles + "test-3p-LIC3true.txt");
        cmv = new ConditionsMetVector(15, pm);
        assertEquals(Boolean.TRUE, cmv.LIC3(), "LIC3 should be true when the triangle's area is greater than Area1");
    }

    @Test
    @DisplayName("LIC3 false case")
    public void LIC3False() {
        pm = new ParameterManager(pathToTestFiles + "test-3p-LIC3false.txt");
        cmv = new ConditionsMetVector(15, pm);
        assertEquals(Boolean.FALSE, cmv.LIC3(), "LIC3 should be false when the triangle's area is less than Area1");
    }
  
    @Test
    @DisplayName("LIC7 true case")
    public void LIC7True() {
        pm = new ParameterManager(pathToTestFiles + "test-10p-LIC7true.txt");
        cmv = new ConditionsMetVector(pm);
        assertEquals(Boolean.TRUE, cmv.LIC7(), "LIC7 should be true when the distance is greater than length1");
    }

    @Test
    @DisplayName("LIC7 false case")
    public void LIC7False() {
        pm = new ParameterManager(pathToTestFiles + "test-10p-LIC7false.txt");
        cmv = new ConditionsMetVector(pm);
        assertEquals(Boolean.FALSE, cmv.LIC7(), "LIC7 should be true when the distance is less than length1");
    }


    @Test
    @DisplayName("LIC14 true case")
    public void LIC14True() {
        pm = new ParameterManager(pathToTestFiles + "test-10p-LIC14true.txt");
        cmv = new ConditionsMetVector(pm);
        assertEquals(Boolean.TRUE, cmv.LIC14(), "LIC14 should be true when both conditions are true");
    }

    @Test
    @DisplayName("LIC14 false case")
    public void LIC14False() {
        pm = new ParameterManager(pathToTestFiles + "test-10p-LIC14false.txt");
        cmv = new ConditionsMetVector(pm);
        assertEquals(Boolean.FALSE, cmv.LIC14(), "LIC14 should be false when at least one condition is false");
    }
}
