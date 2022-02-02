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

    /**
     * All test cases for LIC0.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC0.")
    class TestLIC0 {
        @Test
        @DisplayName("LIC0 true case")
        public void LIC0true() {
            pm = new ParameterManager(pathToTestFiles + "test-3p-LIC0true.txt");
            cmv = new ConditionsMetVector(15, pm);
            assertEquals(Boolean.TRUE, cmv.LIC0(), "LIC0 should be true, length1 larger than one distance between adjacent points");
        }

    }
    /**
     * All test cases for LIC1.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC1.")
    class TestLIC1{

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }

        /**
         * Test if these 3 points require a bigger circle than radius 4
         */
        @Test
        @DisplayName("LIC1 true case")
        public void LIC1true() {
            // these points are on to of a circle of radius 5
            Point p1 = new Point(0, -5);
            Point p2 = new Point(-3, 4);
            Point p3 = new Point(3, 4);
            // 
            double radius1 = 4.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.TRUE, cmv.LIC1(radius1, p), "There exists 3 consecutive points where the smallest circle's radius is greater than 4.0");
        }

        /**
         * Test if these 3 points require a strictly bigger circle than radius 5
         */
        @Test
        @DisplayName("LIC1 edge false case")
        public void LIC1EdgeFalse() {
            // these points are on to of a circle of radius 5
            Point p1 = new Point(0, -5);
            Point p2 = new Point(-3, 4);
            Point p3 = new Point(3, 4);
            // 
            double radius1 = 5.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.FALSE, cmv.LIC1(radius1, p), "LIC1 should be false, radius: 5, points: {{0, -5}, {-3, 4}, {3, 4}} minimal radius is 5, points are ON the circle");
        }
    
        /**
         * Test if these 3 points require a strictly bigger circle than radius 6
         */
        @Test
        @DisplayName("LIC1 false case")
        public void LIC1false() {
            // these points are on to of a circle of radius 5
            Point p1 = new Point(0, -5);
            Point p2 = new Point(-3, 4);
            Point p3 = new Point(3, 4);
            // 
            double radius1 = 6.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.FALSE, cmv.LIC1(radius1, p), "LIC1 should be false, radius: 6, points: {{0, -5}, {-3, 4}, {3, 4}} minimal radius is 5");
        }
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

    /**
     * All test cases for LIC3.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC3.")
    class TestLIC3 {
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

    }
    
    /**
     * All test cases for LIC4.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC4.")
    class TestLIC4 {
        @Test
        @DisplayName("LIC4 true case")
        public void LIC4True() {
            pm = new ParameterManager(pathToTestFiles + "test-3p-LIC4true.txt");
            cmv = new ConditionsMetVector(15, pm);
            assertEquals(Boolean.TRUE, cmv.LIC4(), "LIC4 should be true when there exist qPts nr of consecutive points in more than quads quadrants");
        }
        @Test
        @DisplayName("LIC4 false case")
        public void LIC4False() {
            pm = new ParameterManager(pathToTestFiles + "test-3p-LIC4false.txt");
            cmv = new ConditionsMetVector(15, pm);
            assertEquals(Boolean.FALSE, cmv.LIC4(), "LIC4 should be false when there does not exist qPts nr of consecutive points in more than quads quadrants");
        }
    }

    /**
     * All test cases for LIC7.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC7.")
    class TestLIC7 {
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
    }


    /**
     * Test for LIC 9
     * */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 9.")
    class TestLIC9 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }

        /**
         * Test if LIC9 returns true if angle < (pi - epsilon)
         * */
        @Test
        @DisplayName("LIC9 positive case, angle < (pi - epsilon)")
        public void LIC9positiveAngleLess() {

            // 90 deg --> pi/2 rad ~ 1.6
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, -1); // unused in this test case
            Point p3 = new Point(1, 0);
            Point p4 = new Point(-1, -1); // unused in this test case
            Point p5 = new Point(2, 1);
            // epsilon = 1 --> pi - eps = 2.14, => angle < pi - eps
            double eps = 1.0;
            int cPts = 1;
            int dPts = 1;

            Point[] vals = new Point[]{p1, p2, p3, p4, p5};
            Vector<Point> p = new Vector<Point>(5, vals);
            assertEquals(true, cmv.LIC9(eps, cPts, dPts, p), "Expected to be true.");
        }

        /**
         * Test if LIC9 returns true if angle > (pi + epsilon)
         * */
        @Test
        @DisplayName("LIC9 positive case, angle > (pi + epsilon)")
        public void LIC9positiveAngleGreater() {
            // 180 deg --> 3/2*pi rad ~ 4.7
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, -1); // unused in this test case
            Point p3 = new Point(1, 0);
            Point p4 = new Point(-1, -1); // unused in this test case
            Point p5 = new Point(2, -1);
            // epsilon = 1 --> pi + eps = 3.15, => angle > pi + eps
            double eps = 0.01;
            int cPts = 1;
            int dPts = 1;

            Point[] vals = new Point[]{p1, p2, p3, p4, p5};
            Vector<Point> p = new Vector<Point>(5, vals);
            assertEquals(true, cmv.LIC9(eps, cPts, dPts, p), "Expected to be true.");
        }

        /**
         * Test if LIC9 returns false if angle < (pi + epsilon)
         * */
        @Test
        @DisplayName("LIC9 negative case, angle < (pi + epsilon)")
        public void LIC9negativeLess() {
            // 90 deg --> pi/2 rad ~ 1.6
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, -1); // unused in this test case
            Point p3 = new Point(1, 0);
            Point p4 = new Point(-1, -1); // unused in this test case
            Point p5 = new Point(2, 1);
            // epsilon = 3, (pi - eps = 0.14, pi + eps = 6.14)
            // => (angle > (pi + epsilon)) && (angle < (pi - epsilon)) (should return false)
            double eps = 3;
            int cPts = 1;
            int dPts = 1;

            Point[] vals = new Point[]{p1, p2, p3, p4, p5};
            Vector<Point> p = new Vector<Point>(5, vals);
            assertEquals(false, cmv.LIC9(eps, cPts, dPts, p), "Expected to be false.");
        }

        /**
         * Test if LIC9 returns false if nr of points < 5
         * */
        @Test
        @DisplayName("LIC9 negative case, if nr of points is < 5")
        public void LIC9negativeNoOfPoints() {
            cmv = new ConditionsMetVector(15);
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(1, 0);

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(false, cmv.LIC9(1, 1, 1, p), "Expected to be false.");
        }

    }

    /**
     * All test cases for LIC14.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC14.")
    class TestLIC14 {
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
}
