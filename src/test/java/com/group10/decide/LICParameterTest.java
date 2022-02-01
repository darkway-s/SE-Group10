package com.group10.decide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for LICParameter.
 */
public class LICParameterTest {

    LICParameter licParameter;

    /**
     * Instantiate a new LICParameter object used for testing.
     * */
    @BeforeEach
    public void setUp() {
        licParameter = new LICParameter(1.0, 9.3, 0.092, 24.4, 4.0, 3.4, 6.6, 7.0, 1, 3, 79, 4, 8, 56, 9, 11, 10, 3, 9);
    }

    /**
     * Test if LENGTH_1 can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter LENGTH 1")
    public void getParameterLength1() {
        assertEquals(1.0, licParameter.getLength1(), "should get 1.0");
    }

    /**
     * Test if RADIUS_1 can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter RADIUS_1")
    public void getParameterRadius1() {
        assertEquals(9.3, licParameter.getRadius1(), "should get 9.3");
    }

    /**
     * Test if EPSILON can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter EPSILON")
    public void getParameterEpsilon() {
        assertEquals(0.092, licParameter.getEpsilon(), "should get 0.092");
    }

    /**
     * Test if AREA_1 can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter AREA_1")
    public void getParameterArea1() {
        assertEquals(24.4, licParameter.getArea1(), "should get  24.4");
    }

    /**
     * Test if DIST can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter DIST")
    public void getParameterDist() {
        assertEquals(4.0, licParameter.getDist(), "should get 4.0");
    }

    /**
     * Test if LENGTH_2 can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter LENGTH 2")
    public void getParameterLength2() {
        assertEquals(3.4, licParameter.getLength2(), "should get 3.4");
    }

    /**
     * Test if RADIUS_2 can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter RADIUS_2")
    public void getParameterRadius2() {
        assertEquals(6.6, licParameter.getRadius2(), "should get 6.6");
    }

    /**
     * Test if AREA_2 can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter AREA_2")
    public void getParameterArea2() {
        assertEquals(7.0, licParameter.getArea2(), "should get 7.0");
    }

    /**
     * Test if Q_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter Q_PTS")
    public void getParameterQPts() {
        assertEquals(1, licParameter.getQPts(), "should get 1");
    }

    /**
     * Test if QUADS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter QUADS")
    public void getParameterQuads() {
        assertEquals(3, licParameter.getQuads(), "should get 3");
    }

    /**
     * Test if N_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter N_PTS")
    public void getParameterNPts() {
        assertEquals(79, licParameter.getNPts(), "should get 79");
    }

    /**
     * Test if K_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter K_PTS")
    public void getParameterKPts() {
        assertEquals(4, licParameter.getKPts(), "should get 4");
    }

    /**
     * Test if A_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter A_PTS")
    public void getParameterAPts() {
        assertEquals(8, licParameter.getAPts(), "should get 8");
    }

    /**
     * Test if B_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter B_PTS")
    public void getParameterBPts() {
        assertEquals(56, licParameter.getBPts(), "should get 56");
    }

    /**
     * Test if C_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter C_PTS")
    public void getParameterCPts() {
        assertEquals(9, licParameter.getCPts(), "should get 9");
    }

    /**
     * Test if D_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter D_PTS")
    public void getParameterDPts() {
        assertEquals(11, licParameter.getDPts(), "should get 11");
    }

    /**
     * Test if E_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter E_PTS")
    public void getParameterEPts() {
        assertEquals(10, licParameter.getEPts(), "should get 10");
    }

    /**
     * Test if F_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter F_PTS")
    public void getParameterFPts() {
        assertEquals(3, licParameter.getFPts(), "should get 3");
    }

    /**
     * Test if G_PTS can be retrieved from the LICParameter object
     */
    @Test
    @DisplayName("Can get LIC parameter G_PTS")
    public void getParameterGPts() {
        assertEquals(9, licParameter.getGPts(), "should get 9");
    }
}