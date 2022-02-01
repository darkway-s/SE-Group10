package com.group10.decide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.Scanner;

/**
 * Unit test for ParameterManager.
 */
public class ParameterManagerTest {

    ParameterManager test_t_p_0_manager;

    /**
     * Instantiate a new ParameterManager object used for testing.
     * */
    @BeforeEach
    public void setUp() {
        String root = System.getProperty("user.dir");
        System.out.println(root + "/test-inputs/test-2p-0.txt");
        test_t_p_0_manager = new ParameterManager(root + "/test-inputs/test-2p-0.txt");
    }

    /**
     * Test if we get the correct NUMPOINTS
     */
    @Test
    @DisplayName("Can get NUMPOINTS correctly")
    public void getNumPointsCorrectly() {
        int testNumPoints = 2;
        assertEquals(2, test_t_p_0_manager.getNumPoints(), "should get 2");
    }

    /**
     * Test if we get the correct Points
     */
    @Test
    @DisplayName("Can get POINTS correctly")
    public void getPointsCorrectly() {
        int n = test_t_p_0_manager.getNumPoints();
        double[][] testInput = {{-0.4148, 0.0811}, {-0.3334, -0.7910}};
        Vector<Point> points = test_t_p_0_manager.getPoints();
        for (int i = 0; i < 2; ++i) {
            assertEquals(testInput[i][0], points.getValue(i).getX(), "should get equal");
            assertEquals(testInput[i][1], points.getValue(i).getY(), "should get equal");
        }
    }

    /**
     * Test if we get the correct LIC Parameters
     */
    @Test
    @DisplayName("Can get LIC Parameters correctly")
    public void getLICParametersCorrectly() {
        LICParameter parameters = test_t_p_0_manager.getLICParameter();
        assertEquals(0.4470, parameters.getLength1(), "should get equal");
        assertEquals(1.9120, parameters.getRadius1(), "should get equal");
        assertEquals(0.1966, parameters.getEpsilon(), "should get equal");
        assertEquals(3.3428, parameters.getArea1(), "should get equal");
        assertEquals(2, parameters.getQPts(), "should get equal");
        assertEquals(1, parameters.getQuads(), "should get equal");
        assertEquals(2.1458, parameters.getDist(), "should get equal");
        assertEquals(-1, parameters.getNPts(), "should get equal");
        assertEquals(-1, parameters.getKPts(), "should get equal");
        assertEquals(-1, parameters.getAPts(), "should get equal");
        assertEquals(-1, parameters.getBPts(), "should get equal");
        assertEquals(-1, parameters.getCPts(), "should get equal");
        assertEquals(-1, parameters.getDPts(), "should get equal");
        assertEquals(-1, parameters.getEPts(), "should get equal");
        assertEquals(-1, parameters.getFPts(), "should get equal");
        assertEquals(-1, parameters.getGPts(), "should get equal");
        assertEquals(0.2198, parameters.getLength2(), "should get equal");
        assertEquals(0.9714, parameters.getRadius2(), "should get equal");
        assertEquals(2.2333, parameters.getArea2(), "should get equal");
    }

}