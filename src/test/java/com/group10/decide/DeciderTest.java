package com.group10.decide;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Decider.
 */
public class DeciderTest {

    /**
     * The decide program should output LAUNCH/true when the PUV only contains false
     * elements.
     * An all false PUV would mean that no PUM elements should be considered and
     * that a LAUNCH can be proceeded with.
     */
    @Test
    @DisplayName("Positive test for when all PUV elements are false")
    public void decideAllPUVFalse() {
        // Initialize decide program with all false PUV elements
        ParameterManager pm = new ParameterManager("test-inputs/test-100p-allfalse.txt");
        Decider d = new Decider(pm);

        // Run decide function
        boolean launch = d.decide();

        // Assertions
        assertEquals(true, launch, "If all elements of PUV is false then the launch decision should be true");
    }

    /**
     * The decide program should output LAUNCH/true when the LCM is filled with
     * NOTUSED.
     * A matrix filled with NOTUSED would generate a PUM with only true elements
     * resulting in a LAUNCH.
     */
    @Test
    @DisplayName("Positive test for when all LCM elements are NOTUSED")
    public void decideAllLCMNOTUSED() {
        // Initialize decide program with all false PUV elements
        ParameterManager pm = new ParameterManager("test-inputs/test-100p-LCMallNOTUSED.txt");
        Decider d = new Decider(pm);

        // Run decide function
        boolean launch = d.decide();

        // Assertions
        assertEquals(true, launch,
                "If all elements of LCM is NOTUSED and PUV are all true then the launch decision should be true");
    }

    /**
     * The decide program should output NO/false if all LIC's are considered and the
     * datapoints are less than 5.
     * This is because of e.g. LIC10 which automatically fails when datapoints are
     * less than 10.
     */
    @Test
    @DisplayName("Negative test, all true PUV with 3 datapoints is bound to fail")
    public void decideAllPUVTrueThreeDataPoints() {
        // Initialize decide program with all true PUV elements and 2 datapoints
        ParameterManager pm = new ParameterManager("test-inputs/test-2p-alltrue.txt");
        Decider d = new Decider(pm);

        // Run decide function
        boolean launch = d.decide();

        // Assertions
        assertEquals(false, launch,
                "Should fail on LIC10 if datapoints less than 5");
    }
}