package com.group10.decide;

import org.junit.jupiter.api.BeforeAll;
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

        @Test
        @DisplayName("LIC0 false case")
        public void LIC1true() {
            pm = new ParameterManager(pathToTestFiles + "test-3p-LIC0false.txt");
            cmv = new ConditionsMetVector(15, pm);
            assertEquals(Boolean.FALSE, cmv.LIC0(), "LIC0 should be false, length1 smaller than any distance between adjacent points");
        }
    }
    /**
     * All test cases for LIC1.
     */
    @Nested
    @DisplayName("Negative and positive cases for LIC1.")
    class TestLICI1{
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
