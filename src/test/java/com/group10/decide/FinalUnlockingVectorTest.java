package com.group10.decide;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for FinalUnlockingVector.
 */
public class FinalUnlockingVectorTest {
    FinalUnlockingVector fuv;
    ParameterManager pm;
    static String dir;


    @BeforeAll
    public static void setUp(){
        String root = System.getProperty("user.dir");
        dir = root + "/test-inputs/";
    }

    @Test
    public void FUV1()
    {
        pm = new ParameterManager(dir + "/test-2p-0.txt");
        ConditionsMetVector cmv = new ConditionsMetVector(pm);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(pm.getLogicalConnectorMatrix(),
            cmv.getConditionsMetVector());
        fuv = new FinalUnlockingVector(pm, pum);
        //Test
        System.out.println("\nfuv:----------\n");
        for(int i = 0; i < 15; i++)
            System.out.println(fuv.getFUV().getValue(i));
            System.out.println(" ");
        assertEquals(false, fuv.getFUV().getValue(0), "should be false");
    }
}