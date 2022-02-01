package com.group10.decide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for ParameterManager.
 */
public class ParameterManagerTest {

    ParamaterManager test-2-p-0-manager;
    String test-2-p-0-filePath

    /**
     * Instantiate a new ParameterManager object used for testing.
     * */
    @BeforeEach
    public void setUp() {
        test-2-p-0-filePath = "../../../../../../test-inputs/test-2p-0.txt";
        test-2-p-0-manager = new ParameterManager(test-2-p-0-filePath);
    }

    /**
     * Test if we get the correct NUMPOINTS
     */
    @Test
    @DisplayName("Can get NUMPOINTS correctly")
    public void getNumPointsCorrectly:w//#endregion() {
        int testNumPoints = 2;
        assertEquals(2, test-2-p-0-manager.getNumPoints, "should get 2");
    }

    /**
     * Test if we get the correct Points
     */
    @Test
    @DisplayName("Can get POINTS correctly")
    public void getPointsCorrectly() {
        int n = test-2-p-0-manager.getNumPoints();
        double[][] testInput = {{-0.4148, 0.0811}, {-0.3334, -0.7910}}
        Point[] points = test-2-p-0-manager.getPoints();
        for (int i = 0, i < n; ++i) {
            assertEquals(testInput[i][0], points.getX(), "should get equal");
            assertEquals(testInput[i][1], points.getY(), "should get equal");
        }
    }

}