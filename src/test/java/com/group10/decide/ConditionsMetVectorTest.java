package com.group10.decide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
