package com.group10.decide;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit test for ConditionsMetVector.
 * In this test, we separately test every LIC function with positive, negative and edge cases.
 */
public class ConditionsMetVectorTest {

    static String pathToTestFiles;
    ConditionsMetVector cmv;
    ParameterManager pm;

    /**
     * Set up path to all test inputs before all tests.
     * */
    @BeforeAll
    public static void setUp() {
        pathToTestFiles = "test-inputs/";

    }

    /**
     * All test cases for LIC0.
     * There exists at least one set of two consecutive data points
     * that are a distance greater than LENGTH1. (0 ≤ LENGTH1)
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC0.")
    class TestLIC0 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }

        /**
         * Input is three points{(0, 0),(1, 0),(1.3, 0)}, with LENGTH1 = 0.5
         * there exists the distance between the first two points which is bigger than LENGTH1,
         * so LIC0() should return true.
         */
        @Test
        @DisplayName("LIC0 true case")
        public void LIC0true() {
            // distance between each adjacent points is 1 and 0.3
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(1.3, 0);
            // p1->p2 = 1 > length = 0.5
            double length = 0.5;
            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(Boolean.TRUE, cmv.LIC0(length, p), "LIC0 should be true,  one distance between adjacent points larger than length1");
        }

        /**
         * Input is three points{(0, 0),(1, 0),(1.3, 0)}, with LENGTH1 = 2
         * all the distance between two consecutive data points are less than LENGTH1,
         * so LIC0() should return false.
         */
        @Test
        @DisplayName("LIC0 false case")
        public void LIC0false() {
            // distance between each adjacent points is 1 and 0.3
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(1.3, 0);
            // p1->p2 = 1 < length = 2 and p2->p3 = 0.3 < length = 2
            double length = 2;
            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);

            assertEquals(Boolean.FALSE, cmv.LIC0(length, p), "LIC0 should be false,  no distance between adjacent points larger than length1");
        }

    }
    /**
     * All test cases for LIC1.
     * There exists at least one set of three consecutive data points that cannot
     * all be contained
     * within or on a circle of radius RADIUS1.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC1.")
    class TestLIC1{

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
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
     * True if there exists 3 consecutive points that form an angle such that:
     * angle < PI - EPSILON
     * angle > PI + EPSILON
     * where the second point is the vertex of the angle. The angle is calculated
     * using the law of cosines.
     *
     * If either the first point or the last point (or both) coincides with the
     * vertex, the angle is undefined
     * */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 2.")
    class TestLIC2 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }

        /**
         * Test if LIC2 returns true if angle < (pi - epsilon)
         * Points are arranged in a triangle with 90 deg (pi/2 rad) angle
         * and epsilon is set to 1, so angle < (pi - epsilon) <=> pi/2 < (3.14 - 1)
         * which is true.
         * */
        @Test
        @DisplayName("LIC2 positive case, angle < (pi - epsilon)")
        public void LIC2positiveAngleLess() {
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(2, 1);
            double eps = 1.0;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC2(eps, p), "Expected to be true.");
        }

        /**
         * Test if LIC2 returns true if angle > (pi + epsilon)
         * Points are arranged in a triangle with 180 deg (3*pi/2 rad) angle
         * and epsilon is set to 0.01, so angle > (pi + epsilon) <=> 3*pi/2 < (3.14 - 0.01)
         * which is true.
         * */
        @Test
        @DisplayName("LIC2 positive case, angle > (pi + epsilon)")
        public void LIC2positiveAngleGreater() {
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(2, -1);
            double eps = 0.01;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC2(eps, p), "Expected to be true.");
        }

        /**
         * Test if LIC2 returns false if angle < (pi + epsilon)
         * The points are arranged in a triangle with 90 deg (pi/2 rad) angle
         * and epsilon is set to 3, so angle < (pi + epsilon) <=> pi/2 < (3.14 + 3)
         * which is true.
         * */
        @Test
        @DisplayName("LIC2 false case, angle < (pi + epsilon)")
        public void LIC2falseAngleLess() {
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(2, 1);

            double eps = 3;

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(false, cmv.LIC2(eps, p), "Expected to be false.");
        }

        /**
         * Test if LIC2 returns false if nr of points < 3
         * Expected to return false if number of points is less than 3.
         * */
        @Test
        @DisplayName("LIC2 false case, if nr of points is < 3")
        public void LIC2falseNoOfPoints() {
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);

            Point[] vals = new Point[]{p1, p2};
            Vector<Point> p = new Vector<Point>(2, vals);
            assertEquals(false, cmv.LIC2(1, p), "Expected to be false.");
        }

    }

    /**
     * All test cases for LIC3.
     * There exists at least one set of three consecutive data points that are the vertices of a triangle
     * with area greater than AREA1.
     * (0 ≤ AREA1)
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC3.")
    class TestLIC3 {
        Point p1;
        Point p2;
        Point p3;
        Point p4;

        Point[] vals;
        Vector<Point> p;

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
            // area = 1 * 1 / 2 = 0.5
            p1 = new Point(0, 0);
            p2 = new Point(1, 0);
            p3 = new Point(0, 1);
            p4 = new Point(1, 1);

            vals = new Point[]{p1, p2, p3, p4};
            p= new Vector<Point>(4, vals);
        }
        
        /**
         * Test LIC3 when area is greater than area1
         */
        @Test
        @DisplayName("LIC3 positive case")
        public void LIC3Positive() {
            double area1 = 0.4;

            // The points form a triangle with area = 0.5 and area1 = 0.4 therefore area > area1, LIC3 should be true
            assertEquals(true, cmv.LIC3(area1, p), "LIC3 should be true when the triangle's area is greater than Area1");
        }

         /**
         * Test LIC3 when area is equal to area1
         */
        @Test
        @DisplayName("LIC3 negative edge case")
        public void LIC3NegativeEdge() {
            double area1 = 0.5;

            // The points form a triangle with area = 0.5 and area1 = 0.5 therefore area = area1, LIC3 should be false
            assertEquals(false, cmv.LIC3(area1, p), "LIC3 should be false when the triangle's area is less than Area1");
        }
        

        /**
         * Test LIC3 when area is less than area1
         */
        @Test
        @DisplayName("LIC3 negative case")
        public void LIC3Negative() {
            double area1 = 0.6;

            // The points form a triangle with area = 0.5 and area1 = 0.6 therefore area < area1, LIC3 should be false
            assertEquals(false, cmv.LIC3(area1, p), "LIC3 should be false when the triangle's area is less than Area1");
        }
    }

    
    /**
     * All test cases for LIC4.
     * Checking that at least one set of qPts number of consecutive points lies 
     * in more quads number of quadrants.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC4.")
    class TestLIC4 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }

        /**
         * Test where 2 consecutive points lie in more than 1 quadrant.
         * The added points are in 2 different quadrants.
         */
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

        /**
         * Test where 2 consecutive points lie in more than 2 quadrant.
         * The added points are in 2 different quadrants which is not more than 2.
         */
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

        /**
         * Test where 3 consecutive points lie in more than 2 quadrant.
         * The added points are in 3 different quadrants which is more than 2.
         * This specific case is using edge case coordinates with origo.
         */
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
     * There exists at least one set of two consecutive data points, (X[i],Y[i]) and
     * (X[j],Y[j]),
     * such that X[j] - X[i] < 0. (where i = j-1)
     * */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 5.")
    class TestLIC5 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }

        /**
         * Input is three points{(0, 0),(1, 0),(0, 1)}
         * there exists i = 1, j = 2, s.t. X[2] - X[1] =  -1 < 0
         * so LIC5() should return true.
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
         * Input is three points{(0, 0),(1, 0),(2, 1)}
         * for every i from 0 to 2, X[i+1] - X[i] =  1 > 0
         * so LIC5() should return false.
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
     * True if there, amongst nPts (p_i, p_i+1, pi+2, p_i+3) consecutive points,
     * exist a distance from p_i+1, p_i+2 to the line formed by p_i and p_i+3
     * such that the distance > dist
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC6")
    class TestLIC6 {
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }

        /**
         * Test to see if LIC6 returns true if dist < distance between line and point.
         * The points are arranged as follows: (0,1) (0,0) (1,0) (2,0) (3,0) (3,1)
         *      *        *
         *      *  *  *  *
         * And nPts is set to 4, so the smallest distance to the line will be 0
         * (when the slice includes (0,0), (1,0), (2,0), (3,0)). Since dist = 0.1 > 0, the method is expected to return true.
         */
        @Test
        @DisplayName("LIC6 returns true if dist < distance between line and point.")
        public void testIfDistIsSmaller() {
            int nPts = 4;
            int numPts = 6;
            double dist = 0.1;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(3, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(true, cmv.LIC6(nPts, dist, points), "Expected to be true");
        }

        /**
         * The points are arranged as follows: (0,1) (0,0) (1,0) (2,0) (3,0) (3,1)
         *      *        *
         *      *  *  *  *
         * And nPts is set to 4, so the smallest distance to the line will be 0 (when the slice includes
         * (0,0), (1,0), (2,0), (3,0)). Since dist = 50 > 0, the method is expected to return false.
         */
        @Test
        @DisplayName("LIC6 returns false if dist > distance between line and point.")
        public void testIfDistIsLarger() {
            int nPts = 4;
            int numPts = 6;
            double dist = 50;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(3, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(false, cmv.LIC6(nPts, dist, points), "Expected to be false");
        }

        /**
         * Test to see if LIC6 returns true if dist < distance between line and point & last point == first point
         * The points are arranged as follows: (0,1) (0,0) (1,0)
         *      *
         *      *  *
         * And nPts is set to 3, so the smallest distance to the line will be 0 sqrt(2).
         * Since dist = 0.1 > sqrt(2), the method is expected to return true.
         */
        @Test
        @DisplayName("LIC6 returns true if dist < distance between line and point & last point == first point")
        public void testIfDistIsSmallerAndLastIsFirst() {
            int nPts = 3;
            int numPts = 3;
            double dist = 0.1;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(0, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(true, cmv.LIC6(nPts, dist, points), "Expected to be true");
        }

        /**
         * Test to see if LIC6 returns false if dist > distance between line and point & last point == first point
         * The points are arranged as follows: (0,1) (0,0) (1,0) (1,1)
         *      *  *
         *      *  *
         * And nPts is set to 4, so the smallest distance to the line will be 1.
         * Since dist = 2 > 1, the method is expected to return false.
         */
        @Test
        @DisplayName("LIC6 returns false if dist > distance between line and point & last point == first point")
        public void testIfDistIsLargerAndLastIsFirst() {
            int nPts = 4;
            int numPts = 4;
            double dist = 2;
            Point[] pts = new Point[]{ new Point(0, 1), new Point(0, 0), new Point(1, 1), new Point(0, 1) };
            Vector<Point> points = new Vector<Point>(numPts, pts);
            assertEquals(false, cmv.LIC6(nPts, dist, points), "Expected to be false");
        }
    }


    /**
     * All test cases for LIC7.
     * True if there exists two points, separated by KPts intervening points, that
     * are LENGTH1 distance apart
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC7.")
    class TestLIC7 {
        Point p1;
        Point p2;
        Point p3;
        Point p4;

        Point[] vals;
        Vector<Point> p;

        @BeforeEach
        void setUp(){
            p1 = new Point(0, 0);   // edge case, Q1
            p2 = new Point(1, 0);   // edge case, Q1
            p3 = new Point(2, 0);   // Q1
            p4 = new Point(3, 0);  // Q2

            vals = new Point[]{p1, p2, p3, p4};
            p = new Vector<Point>(4, vals);

            cmv = new ConditionsMetVector();
        }

        /**
         * LIC7 should be true when the distance is greater than length1
         */
        @Test
        @DisplayName("LIC7 true case")
        public void LIC7True() {
            double length1 = 1;
            int kPts = 2;

            assertEquals(true, cmv.LIC7(length1, kPts, p), "LIC7 should be true when the distance is greater than length1");
        }
        
        /**
         * LIC7 should be false when the distance is less than length1
         */
        @Test
        @DisplayName("LIC7 false case")
        public void LIC7False() {
            double length1 = 10;
            int kPts = 2;

            assertEquals(false, cmv.LIC7(length1, kPts, p), "LIC7 should be false when the distance is less than length1");
        }
    }

    /**
     * All test cases for LIC8.
     * Checking that three consecutive points separated by at exaktly aPts and bPts
     * points are not within a circle of radius1. The number of points must also be
     * at least 5.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC8.")
    class TestLIC8 {
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }
        /**
         * 6 points where we have three points separated by 1 which are 
         * outside a circle of radius1 = 1.
         */
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
            assertEquals(true, cmv.LIC8(aPts, bPts, radius, points), "Expected to be true");
            
        }
        
        /**
         * 6 points where we have three points separated by 1 which are 
         * within a circle of radius1 = 5.
         */
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
            assertEquals(false, cmv.LIC8(aPts, bPts, radius, points), "Expected to be false");
        }

        /**
         * Test that should false since we have less than 5 points.
         */
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
            assertEquals(false, cmv.LIC8(aPts, bPts, radius, points), "Expected to be false");
        }
    }



    /**
     * Test for LIC 9
     * There exists at least one set of three data points separated by exactly C_PTS
     * and D_PTS
     * consecutive intervening points, respectively, that form an angle such that:
     * angle < (PI − EPSILON)
     * or
     * angle > (PI + EPSILON)
     * */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 9.")
    class TestLIC9 {

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
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
            cmv = new ConditionsMetVector();
            Point p1 = new Point(0, 0);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(1, 0);

            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(false, cmv.LIC9(1, 1, 1, p), "Expected to be false.");
        }

    }

    /**
     * Test for LIC 10. 
     * Checking there exist at least one set of three points separated
     * by exakt ePts and fPts points that has a triangular area greater than Area1. The 
     * nr of points in the set is at least 5.
     */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 10.")
    class TestLIC10 {
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }

        /**
         * The area of points p1, p3 and p5 is greater than Area1.
         */
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

        /**
         * There is no compination where every other point forms a triangle with area greater than Area1.
         */
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
     * Test for LIC 11
     * There exists at least one set of two data points, (X[i],Y[i]) and
     * (X[j],Y[j]),
     * separated by exactly G_PTS consecutive intervening points, such that X[j] -
     * X[i] < 0. (where i < j )
     * The condition is not met when NUMPOINTS < 3.
     * 1 <= G_PTS <= NUMPOINTS - 3
     */
    @Nested
    @DisplayName("Negative and positive test cases for LIC 11.")
    class TestLIC11 {
        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
        }
        /**
         * input 3 points with G_pts = 1,
         * the set consists of the first point and the third point, separated by 1 intervening point,
         * such that X[0] - x[2] = -1 < 0
         * so LIC11() should return true.
         */
        @Test
        @DisplayName("LIC11 positive case")
        public void LIC11true() {
            int gPts = 1;
            Point p1 = new Point(1, 3);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(0, 2);
            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(true, cmv.LIC11(gPts, p), "Expected to be true.");
        }

        /**
         * input 3 points with G_pts = 1,
         * the only set which can be separated by 1 intervening point is
         * the set consisting of the first point and the third point,
         * X[0] - x[2] = 4 > 0
         * so LIC11() should return false.
         */
        @Test
        @DisplayName("LIC11 negative case")
        public void LIC11false() {
            int gPts = 1;
            Point p1 = new Point(1, 3);
            Point p2 = new Point(1, 0);
            Point p3 = new Point(5, 2);
            Point[] vals = new Point[]{p1, p2, p3};
            Vector<Point> p = new Vector<Point>(3, vals);
            assertEquals(false, cmv.LIC11(gPts, p), "Expected to be false.");
        }

        /**
         * input 2 points,
         * NUMPOINTS = 2 < 3, condition is not met
         * so LIC11() should return false.
         */
        @Test
        @DisplayName("LIC11 edge test")
        public void LIC11ShortOfNum() {
            int gPts = 1;
            Point p1 = new Point(1, 3);
            Point p2 = new Point(1, 0);
            Point[] vals = new Point[]{p1, p2};
            Vector<Point> p = new Vector<Point>(2, vals);
            assertEquals(false, cmv.LIC11(gPts, p), "Expected to be false.");
        }
    }

    /**
     * All test cases for LIC12.
     * There exists at least one set of two data points, separated by exactly K PTS
     * consecutive intervening points, which are a distance greater than the length, LENGTH1,
     * apart. In addition, there exists at least one set of two data points (which can be the same
     * or different from the two data points just mentioned), separated by exactly K PTS consecutive
     * intervening points, that are a distance less than the length, LENGTH2, apart. Both parts
     * must be true for the LIC to be true.
     * 
     * The condition is not met when NUMPOINTS < 3.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC12.")
    class TestLIC12{

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
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
     * This condition has two subcondition
     *      (1) three points separated by aPts and bPts cannot be contained within or on a circle with radius radius1
     *      (2) three points separated by aPts and bPts can be contained within or on a circle with radius2
     * If both are true, the condition is satisfied.
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
            cmv = new ConditionsMetVector();
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
         * Tests if both subconditions are met, and thus returns true.
         * Radius1 is set to 0.25, Radius2 to 50. The points that form a circle are
         * (0,0) (3,1) (2,3) which has a radius of r=1.82; thus r is not within Radius1,
         * but within Raduis2, and the function should return true.
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
         * Radius1 is set to 0.25, Radius2 to 0.25. The points that form a circle are
         * (0,0) (3,1) (2,3) which has a radius of r=1.82; thus r is not within Radius1,
         * nor within Raduis2, and the function should return false.
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
         * Tests if both subconditions are met, and thus returns true.
         * Radius1 is set to 50, Radius2 to 50. The points that form a circle are
         * (0,0) (3,1) (2,3) which has a radius of r=1.82; thus r is within Radius1,
         * and within Raduis2, and the function should return false.
         */
        @Test
        @DisplayName("LIC13 returns false, only subcondition (2) is met")
        public void testRadius1BigRadius2Big() {
            double radius1 = 50;
            double radius2 = 50;

            assertEquals(false, cmv.LIC13(aPts, bPts, radius1, radius2, p), "Expected to be false");
        }
    }

    /**
     * All test cases for LIC14.
     * <b>True</b> if there exists three points separated by EPts and FPts
     * intervening points that form the vertices of
     * a triangle with an area greater than area1 and three more points that are
     * separated by the same conditions
     * but could be the same which form the vertices of a triangle with an area less
     * than area2. <b>False</b> otherwise.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC14.")
    class TestLIC14 {
        Point p1;
        Point p2;
        Point p3;
        Point p4;
        Point p5;
        Point p6;

        Point[] vals;
        Vector<Point> p;

        @BeforeEach
        void setUp(){
            cmv = new ConditionsMetVector();
            p1 = new Point(0, 0);
            p2 = new Point(2, 0);
            p3 = new Point(2, 2);
            p4 = new Point(0, 2);
            p5 = new Point(0, 2);
            p6 = new Point(2, 1);

            vals = new Point[]{p1, p2, p3, p4, p5};
            p = new Vector<Point>(5, vals);
        }


        /**
         * LIC14 should be true when both conditions are fulfilled. In this case points (0,0), (2,2), and (0,2) '
         * should be used as they form a triangle with an area of 2. 
         * When area1 = 1 and area2 = 5, the conditions are true as 1 < 2 < 5.
         */
        @Test
        @DisplayName("LIC14 positive case, same points")
        public void LIC14PositiveSamePoints() {
            double area1 = 1;
            double area2 = 5;
            int ePts = 1;
            int fPts = 1;
            assertEquals(true, cmv.LIC14(area1, area2, ePts, fPts, p), "LIC14 should be true when both conditions are true");
        }

        /**
         * LIC14 should be true when both conditions are fulfilled. In this case points (0,0), (2,2), and (0,2)
         * should be used as they form a triangle with an area of 2. As well as points (2,0), (0,2) and (2,1) 
         * which form a triangle with an area of 1.
         * When area1 = 1 and area2 = 2, the conditions are true as 1 (area1) < 2 (triangle 1) and 1 (triangle 2) < 2 (area2).
         */
        @Test
        @DisplayName("LIC14 positive case, Different points fulfill conditions")
        public void LIC14PositiveDifferentPoints() {
            Point[] valsSixPoints = new Point[]{p1, p2, p3, p4, p5};
            Vector<Point> pSix = new Vector<Point>(5, valsSixPoints);

            double area1 = 1;
            double area2 = 5;
            int ePts = 1;
            int fPts = 1;
            assertEquals(true, cmv.LIC14(area1, area2, ePts, fPts, pSix), "LIC14 should be true when both conditions are true but fulfilled by different points");
        }


        /**
         * LIC14 should be false when both conditions are false. In this case (0,0), (2,2), and (0,2) form a triangle
         * with an area of 2. When area1 = 10 and area2 = 2, none of the conditions are true
         */
        @Test
        @DisplayName("LIC14 negative case, when both conditions fail")
        public void LIC14NegativeBothFalse() {
            double area1 = 10;
            double area2 = 2;
            int ePts = 1;
            int fPts = 1;
            assertEquals(false, cmv.LIC14(area1, area2, ePts, fPts, p), "LIC14 should be false when both conditions are false");
        }

        /**
         * LIC14 should be false when atleast one condition is false. In this case (0,0), (2,2), and (0,2) form a triangle
         * with an area of 2. When area1 = 1 and area2 = 2, the first condition holds but not the second one
         */
        @Test
        @DisplayName("LIC14 negative case, when first condition fail")
        public void LIC14NegativeFirstFalse() {
            double area1 = 1;
            double area2 = 2;
            int ePts = 1;
            int fPts = 1;
            assertEquals(false, cmv.LIC14(area1, area2, ePts, fPts, p), "LIC14 should be false when first condition is false");
        }

        /**
         * LIC14 should be false when atleast one condition is false. In this case (0,0), (2,2), and (0,2) form a triangle
         * with an area of 2. When area1 = 2 and area2 = 10, the second condition holds but not the first one
         */
        @Test
        @DisplayName("LIC14 negative case, when second condition fail")
        public void LIC14NegativeSecondFalse() {
            double area1 = 2;
            double area2 = 10;
            int ePts = 1;
            int fPts = 1;
            assertEquals(false, cmv.LIC14(area1, area2, ePts, fPts, p), "LIC14 should be false when second condition is false");
        }
    }
}
