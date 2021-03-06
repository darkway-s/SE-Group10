package com.group10.decide;

/**
 * Decider class which can be called to sequentially computes the CMV, PUM and
 * FUV.
 * 
 * @author Bror Sebastian Sjovald
 */
public class Decider {
    ParameterManager pm;

    /**
     * Constructor for the Decider class. Takes in everything needed to calculate
     * CMV, PUM and FUV.
     * 
     * @param pm Parameters used by the "Decide" program
     */
    public Decider(ParameterManager pm) {
        this.pm = pm;
    }

    /**
     * Calculates the CMV, PUM and FUV sequentially to decide whether to LAUNCH or
     * not
     * 
     * @return A boolean signal that indicates the LAUNCH decision
     */
    public boolean decide() {
        ConditionsMetVector cmv = new ConditionsMetVector(pm);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(pm.getLogicalConnectorMatrix(),
        cmv.getConditionsMetVector());

        FinalUnlockingVector fuv = new FinalUnlockingVector(pm, pum);
        return fuv.hasAllTrueValues();
    }
}