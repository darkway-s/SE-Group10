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
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }
        @Test
        @DisplayName("LIC4 true case")
        public void LIC4True() {
            int qPts = 2;
            int quads = 1;
            Point p1 = new Point(1, 1);
            Point p2 = new Point(-1, -1);
            Point p3 = new Point(2, 1);

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> points = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC4(points, qPts, quads), "LIC4 should be true when there exist qPts nr of consecutive points in more than quads quadrants");
        }
        @Test
        @DisplayName("LIC4 false case")
        public void LIC4False() {
            int qPts = 2;
            int quads = 2;
            Point p1 = new Point(1, 1);
            Point p2 = new Point(-1, 0);
            Point p3 = new Point(2, 1);

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> points = new Vector<Point>(3, vals);
            assertEquals(false, cmv.LIC4(points, qPts, quads), "LIC4 should be false when there dont exist qPts nr of consecutive points in more than quads quadrants");
        }
        @Test
        @DisplayName("LIC4 true case, edge case")
        public void LIC4TrueEdge() {
            int qPts = 3;
            int quads = 2;
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, 0);
            Point p3 = new Point(0, -1);

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> points = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC4(points, qPts, quads), "LIC4 should be true when there exist qPts nr of consecutive points in more than quads quadrants");
        }
    }

    /**
     * Test for LIC 5
     * */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 5.")
    class TestLIC5 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }

        /**
         * Test if LIC5 returns true if exists i, s.t. X[i+1] - X[i] < 0
         * */
        @Test
        @DisplayName("LIC5 true case, exists i, s.t. X[i+1] - X[i] < 0")
        public void LIC5true() {

            // 90 deg --> pi/2 rad ~ 1.6
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(0, 1);

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC5(p), "Expected to be true.");
        }

        /**
         * Test if LIC2 returns true if exists i, s.t. X[i+1] - X[i] < 0
         * */
        @Test
        @DisplayName("LIC5 false case, any i, not satisfy X[i+1] - X[i] < 0")
        public void LIC5false() {

            // 90 deg --> pi/2 rad ~ 1.6
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(2, 1);

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(false, cmv.LIC5(p), "Expected to be false.");
        }


    }

    /**
     * All test cases for LIC6
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC6")
    class TestLIC6 {
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }

        @Test
        @DisplayName("Tes to see if LIC6 returns true if dist < distance between line and point.")
        public void testIfDistIsSmaller() {
            int nPts = 4;
            int numPts = 6;
            double dist = 0.1;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(3, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(true, cmv.LIC6(nPts, numPts, dist, points), "Expected to be true");
        }

        @Test
        @DisplayName("Test to see if LIC6 returns false if dist > distance between line and point.")
        public void testIfDistIsLarger() {
            int nPts = 4;
            int numPts = 6;
            double dist = 50;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(3, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(false, cmv.LIC6(nPts, numPts, dist, points), "Expected to be false");
        }

        @Test
        @DisplayName("Test to see if LIC6 returns true if dist < distance between line and point & last point == first point")
        public void testIfDistIsSmallerAndLastIsFirst() {
            int nPts = 3;
            int numPts = 3;
            double dist = 0.1;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(0, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(true, cmv.LIC6(nPts, numPts, dist, points), "Expected to be true");
        }

        @Test
        @DisplayName("Test to see if LIC6 returns false if dist > distance between line and point & last point == first point")
        public void testIfDistIsLargerAndLastIsFirst() {
            int nPts = 4;
            int numPts = 4;
            double dist = 2;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(1, 1), new Point(0, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(false, cmv.LIC6(nPts, numPts, dist, points), "Expected to be false");
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
     * All test cases for LIC8.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC8.")
    class TestLIC8 {
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }
        @Test
        @DisplayName("LIC8 true case")
        public void LIC8True() {
            double radius = 1.0;
            int aPts = 1;
            int bPts = 1;
            //These points are not within the circle
            Point p1 = new Point(0, 0);
            Point p2 = new Point(0, 1);
            Point p3 = new Point(2, 0);
            Point p4 = new Point(2, 1);
            Point p5 = new Point(2, 2);
            Point p6 = new Point(1, 2);

            Vector<Point> points = new Vector<Point>(6, new Point[]{p1, p2, p3, p4, p5, p6});
            assertEquals(true, cmv.LIC8(points, aPts, bPts, radius), "Expected to be true");
            
        }
    
        @Test
        @DisplayName("LIC8 false case")
        public void LIC8False() {
            double radius = 5.0;
            int aPts = 1;
            int bPts = 1;
            //These points are within the circle
            Point p1 = new Point(0, 0);
            Point p2 = new Point(0, 1);
            Point p3 = new Point(2, 0);
            Point p4 = new Point(2, 1);
            Point p5 = new Point(2, 2);
            Point p6 = new Point(1, 2);

            Vector<Point> points = new Vector<Point>(6, new Point[]{p1, p2, p3, p4, p5, p6});
            assertEquals(false, cmv.LIC8(points, aPts, bPts, radius), "Expected to be false");
        }
        @Test
        @DisplayName("LIC8 false case, fewer than 5 points")
        public void LIC8FalseFewerThan5() {
            double radius = 1.0;
            int aPts = 1;
            int bPts = 1;
            //These points are within the circle
            Point p1 = new Point(0, 0);
            Point p2 = new Point(0, 1);
            Point p3 = new Point(2, 0);
            Point p4 = new Point(2, 1);

            Vector<Point> points = new Vector<Point>(4, new Point[]{p1, p2, p3, p4});
            assertEquals(false, cmv.LIC8(points, aPts, bPts, radius), "Expected to be false");
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
     * Test for LIC 10
     * 
     */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 10.")
    class TestLIC10 {
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }

        @Test
        @DisplayName("LIC10 positive case, area of the triangle is greater than area1")
        public void LIC10positiveAreaGreater() {
            int ePts = 1;
            int fPts = 1;
            double area1 = 10.5;

            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(0, 30);
            Point p4 = new Point(1, 1);
            Point p5 = new Point(30, 1);

            Point[] vals = new Point[]{p1, p2, p3, p4, p5};
            Vector<Point> p = new Vector<Point>(5, vals);
            assertEquals(true, cmv.LIC10(p, ePts, fPts, area1), "Expected to be true.");
        }
        @Test
        @DisplayName("LIC10 positive case, area of the triangle is less than area1")
        public void LIC10positiveAreaLess() {
            int ePts = 1;
            int fPts = 1;
            double area1 = 10.5;

            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(0, 2);
            Point p4 = new Point(1, 1);
            Point p5 = new Point(2, 1);

            Point[] vals = new Point[]{p1, p2, p3, p4, p5};
            Vector<Point> p = new Vector<Point>(5, vals);
            assertEquals(false, cmv.LIC10(p, ePts, fPts, area1), "Expected to be false.");
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

    /**
     * All test cases for LIC12.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC12.")
    class TestLIC12{

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
        }

        /**
         * test if distance between {0, 0} and {3, 4} is higher than 4 and lesser than 6
         */
        @Test
        @DisplayName("LIC12 true case")
        public void LIC12true() {
            // first and third points are seperated by 5 units
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, -1); // unused in this example
            Point p3 = new Point(3, 4);

            // only check p1 against p2
            int kPts = 1;
            double length1 = 4.0;
            double length2 = 6.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.TRUE, cmv.LIC12(kPts, length1, length2, p), "should get true. p1 and p3 are 5 units apart, which is 4 < 5 < 6");
        }

        /**
         * test if distance between {0, 0} and {3, 4} is higher than 5 and lesser than 6
         */
        @Test
        @DisplayName("LIC12 first edge false case")
        public void LIC12EdgeFalse1() {
            // first and third points are seperated by 5 units
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, -1); // unused in this example
            Point p3 = new Point(3, 4);

            // only check p1 against p2
            int kPts = 1;
            double length1 = 5.0;
            double length2 = 6.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.FALSE, cmv.LIC12(kPts, length1, length2, p), "should get false. p1 and p3 are 5 units apart, which is 5 < 5 < 6");
        }
    
        /**
         * test if distance between {0, 0} and {3, 4} is higher than 5 and lesser than 6
         */
        @Test
        @DisplayName("LIC12 second edge false case")
        public void LIC12EdgeFalse2() {
            // first and third points are seperated by 5 units
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, -1);
            Point p3 = new Point(3, 4);

            // only check p1 against p2
            int kPts = 1;
            double length1 = 4.0;
            double length2 = 5.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.FALSE, cmv.LIC12(kPts, length1, length2, p), "should get false. p1 and p3 are 5 units apart, which is 4 < 5 < 5");
        }

        /**
         * test if distance between {0, 0} and {3, 4} is higher than 6 and lesser than 4
         */
        @Test
        @DisplayName("LIC12 false case")
        public void LIC12False() {
            // first and third points are seperated by 5 units
            Point p1 = new Point(0, 0);
            Point p2 = new Point(-1, -1);
            Point p3 = new Point(3, 4);

            // only check p1 against p2
            int kPts = 1;
            double length1 = 6.0;
            double length2 = 4.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.FALSE, cmv.LIC12(kPts, length1, length2, p), "should get false. p1 and p3 are 5 units apart, which is 4 < 5 < 5");
        }

        /**
         * test if at least one of the distance between {0, 0} and {3, 4} or
         * thr distance between {0, 1} and {3, 1} higher than 2 and lesser than 3.5
         */
        @Test
        @DisplayName("LIC12 true case with 4 inputs")
        public void LIC12True4Inputs() {
            // first and third points are seperated by 5 units
            Point p1 = new Point(0, 0);
            Point p2 = new Point(0, 1);
            Point p3 = new Point(3, 4);
            Point p4 = new Point(3, 1);

            // only check p1 against p2
            int kPts = 1;
            double length1 = 2.0;
            double length2 = 3.5;

            Point[] vals = new Point[]{p1, p2, p3, p4};
            Vector<Point> p = new Vector<Point>(4, vals);
            assertEquals(Boolean.TRUE, cmv.LIC12(kPts, length1, length2, p), "should get true. p1 and p3 are 5 units apart and p2 and p4 are 3 units apart, length1: 2, length2: 3.5");
        }
    }

    /**
     * All test cases for LIC13.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC13.")
    class TestLIC13 {
        Point p1;
        Point p2;
        Point p3;
        Point p4;
        Point p5;
        Point p6;
        int aPts;
        int bPts;
        Point[] vals;
        Vector<Point> p;

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector(15);
            p1 = new Point(0, 0);
            p2 = new Point(0, 1);
            p3 = new Point(3, 4);
            p4 = new Point(3, 1);
            p5 = new Point(3, 1);
            p6 = new Point(2, 3);
            aPts = 2;
            bPts = 1;
            vals = new Point[]{ p1, p2, p3, p4, p5, p6 };
            p = new Vector<Point>(6, vals);
        }

        /**
         * Tests if both subconditions are met, and thus returns true
         */
        @Test
        @DisplayName("LIC13 returns true, both subcondtions are met")
        public void testRadius1SmallRadius2Big() {
            double radius1 = 0.25;
            double radius2 = 50;

            assertEquals(true, cmv.LIC13(aPts, bPts, radius1, radius2, p), "Expected to be true");
        }

        /**
         * Tests if only 1 subcondition is met, and thus returns false
         */
        @Test
        @DisplayName("LIC13 returns false, only subcondition (1) is met")
        public void testRadius1SmallRadius2Small() {
            double radius1 = 0.25;
            double radius2 = 0.25;

            assertEquals(false, cmv.LIC13(aPts, bPts, radius1, radius2, p), "Expected to be false");
        }

        /**
         * Tests if only 1 subcondition is met, and thus returns false
         */
        @Test
        @DisplayName("LIC13 returns false, only subcondition (2) is met")
        public void testRadius1BigRadius2Big() {
            double radius1 = 50;
            double radius2 = 50;

            assertEquals(false, cmv.LIC13(aPts, bPts, radius1, radius2, p), "Expected to be false");
        }
    }
}
