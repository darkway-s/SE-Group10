package com.group10.decide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for LIC0.
 */
public class LIC0Test {

    @Test
    @DisplayName("LIC0Test1")
    public void LIC0Pass() {
        int NUMPOINTS = 3;
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(10, 10);
        Point[] POINTS = {point1, point2, point3};
        Matrix<Connector> logicalConnectorMatrix = new Matrix<Connector>();
        Vector<Boolean> preliminaryUnlockingVector = new Vector<Boolean>();
        LICParameter licParameter = new LICParameter(1.0, 9.3, 0.092, 24.4, 4.0, 3.4, 6.6, 7.0, 1, 3, 79, 4, 8, 56, 9, 11, 10, 3, 9);
        ParameterManager pm = new ParameterManager(NUMPOINTS, POINTS, licParameter, logicalConnectorMatrix, preliminaryUnlockingVector);
        ConditionsMetVector cmv = new ConditionsMetVector(15, pm);
        
        Boolean result = cmv.LIC0();
        assertEquals(Boolean.TRUE, result, "should get True");
        
    }


    @Test
    @DisplayName("LIC0Test1")
    public void LIC0Unpass() {
        int NUMPOINTS = 3;
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(1, 2);
        Point[] POINTS = {point1, point2, point3};
        Matrix<Connector> logicalConnectorMatrix = new Matrix<Connector>();
        Vector<Boolean> preliminaryUnlockingVector = new Vector<Boolean>();
        LICParameter licParameter = new LICParameter(5.0, 9.3, 0.092, 24.4, 4.0, 3.4, 6.6, 7.0, 1, 3, 79, 4, 8, 56, 9, 11, 10, 3, 9);
        ParameterManager pm = new ParameterManager(NUMPOINTS, POINTS, licParameter, logicalConnectorMatrix, preliminaryUnlockingVector);
        ConditionsMetVector cmv = new ConditionsMetVector(15, pm);
        
        Boolean result = cmv.LIC0();
        assertEquals(Boolean.FALSE, result, "should get False");
        
    }
}
