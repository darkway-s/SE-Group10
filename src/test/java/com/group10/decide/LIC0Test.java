package com.group10.decide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.locks.Condition;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for LIC0.
 */
public class LIC0Test {
    String dir;
    

    @BeforeEach
    public void setUp() {
        String root = System.getProperty("user.dir");
        this.dir = root + "/test-inputs/";
    }

    /**
     * Test if LIC0 Passes
     */
    @Test
    @DisplayName("LIC0Test1")
    public void LIC0Pass() {
        ParameterManager myPM = new ParameterManager(dir + "test-4p-0.txt");
        ConditionsMetVector cmv = new ConditionsMetVector(myPM);
        Boolean result = cmv.LIC0();
        assertEquals(Boolean.TRUE, result, "should get True");
    }


    /**
     * Test if LIC0 Unpasses
     */
    @Test
    @DisplayName("LIC0Test2")
    public void LIC0Unpass() {
        ParameterManager myPM = new ParameterManager(dir + "test-10p-allfalse.txt");
        ConditionsMetVector cmv = new ConditionsMetVector(myPM);
        Boolean result = cmv.LIC0();
        assertEquals(Boolean.FALSE, result, "should get False");
    }
}
