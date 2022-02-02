package com.group10.decide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for PreliminaryUnlockingMatrix.
 */
public class PreliminaryUnlockingMatrixTest {

    static Matrix<Connector> allANDD;
    static Matrix<Connector> allORR;
    static Matrix<Connector> allNOTUSED;
    static Vector<Boolean> cmvAllTrue;
    static Vector<Boolean> cmvAllFalse;
    static Vector<Boolean> cmvOneTrue;


    /**
     * Initializes all LCMs and CMVs used by the tests
     */
    @BeforeAll
    public static void setUp() {

        Connector[][] allANDDVals = new Connector[][] {
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
                {Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD, Connector.ANDD },
        };

        Connector[][] allORRVals = new Connector[][] {
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
                {Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR, Connector.ORR },
        };

        Connector[][] allNOTUSEDVals = new Connector[][] {
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
                {Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED, Connector.NOTUSED },
        };

        Boolean[] allFalse = new Boolean[] { false, false, false, false, false, false,false, false, false,false, false, false,false, false, false };
        Boolean[] allTrue = new Boolean[] { true, true, true, true, true, true,true, true, true,true, true, true,true, true, true };
        Boolean[] oneTrue = new Boolean[] { false, false, false, false, true, false,false, false, false,false, false, false,false, false, false };

        allANDD = new Matrix<>(15, 15,allANDDVals);
        allORR = new Matrix<>(15, 15,allORRVals);
        allNOTUSED = new Matrix<>(15, 15,allNOTUSEDVals);

        cmvAllFalse = new Vector<>(15, allFalse);
        cmvAllTrue = new Vector<>(15, allTrue);
        cmvOneTrue = new Vector<>(15, oneTrue);
    }

    @Test
    @DisplayName("PUM with NOTUSED filled LCM shouldn't be affected by CMV")
    public void testPUMWithNOTUSEDLCM() {
        // Initialize and compute PUMs
        PreliminaryUnlockingMatrix pumNOTUSEDWithAllFalseCMV = new PreliminaryUnlockingMatrix(allNOTUSED, cmvAllFalse);
        PreliminaryUnlockingMatrix pumNOTUSEDWithAllTrueCMV = new PreliminaryUnlockingMatrix(allNOTUSED, cmvAllTrue);

        // Assert that PUMs are equal and that all elements are true
        Matrix<Boolean> pumFromAllFalse = pumNOTUSEDWithAllFalseCMV.getPUM();
        Matrix<Boolean> pumFromAllTrue = pumNOTUSEDWithAllTrueCMV.getPUM();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(pumFromAllFalse.getValue(i, j), pumFromAllTrue.getValue(i, j), String.format("Element %d and %d from both matrices should be equal", i, j));
                assertEquals(pumFromAllFalse.getValue(i, j), Boolean.TRUE, "All elements should be true when LCM is NOTUSED");
            }
        }
    }

    @Test
    @DisplayName("PUM with ANDD filled LCM should be affected by CMV")
    public void testPUMWithANDDLCM() {
        // Initialize and compute PUMs
        PreliminaryUnlockingMatrix pumANDDWithAllFalseCMV = new PreliminaryUnlockingMatrix(allANDD, cmvAllFalse);
        PreliminaryUnlockingMatrix pumANDDWithAllTrueCMV = new PreliminaryUnlockingMatrix(allANDD, cmvAllTrue);

        // Assert that PUMs are filled differently and correctly
        Matrix<Boolean> pumFromAllFalse = pumANDDWithAllFalseCMV.getPUM();
        Matrix<Boolean> pumFromAllTrue = pumANDDWithAllTrueCMV.getPUM();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(Boolean.FALSE, pumFromAllFalse.getValue(i, j), "All elements should be false when LCM is ANDD and CMV is false");
                assertEquals(Boolean.TRUE, pumFromAllTrue.getValue(i, j), "All elements should be true when LCM is ANDD and CMV is true");
            }
        }

        // Initialize new PUM with one true LIC
        PreliminaryUnlockingMatrix pumANDDWithOneTrueCMV = new PreliminaryUnlockingMatrix(allANDD, cmvOneTrue);

        // Calculate PUM with one true LIC and assert that all PUM elements except one is false
        Matrix<Boolean> pumFromOneTrue = pumANDDWithOneTrueCMV.getPUM();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if ((i == 4) && (j == 4)) {
                    assertEquals(Boolean.TRUE, pumFromOneTrue.getValue(i, j), String.format("Element (%d, %d) should be true when LCM is ANDD and it is the only CMV element that is true", i, j));
                } else {
                    assertEquals(Boolean.FALSE, pumFromOneTrue.getValue(i, j), String.format("Element (%d, %d) should be false when LCM is ANDD and only one CMV element is true", i, j));
                }
            }
        }
    }

    @Test
    @DisplayName("PUM with ORR filled LCM should be affected by CMV")
    public void testPUMWithORRLCM() {
        // Initialize and compute PUMs
        PreliminaryUnlockingMatrix pumORRWithAllFalseCMV = new PreliminaryUnlockingMatrix(allORR, cmvAllFalse);
        PreliminaryUnlockingMatrix pumORRWithAllTrueCMV = new PreliminaryUnlockingMatrix(allORR, cmvAllTrue);

        // Assert that PUMs are filled differently and correctly
        Matrix<Boolean> pumFromAllFalse = pumORRWithAllFalseCMV.getPUM();
        Matrix<Boolean> pumFromAllTrue = pumORRWithAllTrueCMV.getPUM();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(Boolean.FALSE, pumFromAllFalse.getValue(i, j),"All elements should be false when LCM is ORR and CMV is false");
                assertEquals(Boolean.TRUE, pumFromAllTrue.getValue(i, j),"All elements should be true when LCM is ORR and CMV is true");
            }
        }

        // Initialize new PUM with one true LIC
        PreliminaryUnlockingMatrix pumORRWithOneTrueCMV = new PreliminaryUnlockingMatrix(allORR, cmvOneTrue);

        // Calculate PUM with one true LIC and assert that PUM elements that are connected to true CMV value is true
        Matrix<Boolean> pumFromOneTrue = pumORRWithOneTrueCMV.getPUM();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if ((i == 4) || (j == 4)) {
                    assertEquals(Boolean.TRUE, pumFromOneTrue.getValue(i, j), "Element should be true for true CMV value");
                } else {
                    assertEquals(Boolean.FALSE, pumFromOneTrue.getValue(i, j), "Element should be false for false CMV value");
                }
            }
        }
    }
}