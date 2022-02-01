package com.group10.decide;

/**
 * Decider class which can be called to sequentially computes the CMV, PUM and FUV.
 * @author Bror Sebastian Sjovald
 */
public class Decider {
    ParameterManager pm;

    /**
     * Constructor for the Decider class. Takes in everything needed to calculate CMV, PUM and FUV.
     * @param pm    Parameters used by the "Decide" program
     */
    public Decider(ParameterManager pm) {
        this.pm = pm;
    }

    /**
     * Calculates the CMV, PUM and FUV sequentially to decide whether to LAUNCH or not
     * @return A boolean signal that indicates the LAUNCH decision
     */
    public boolean decide() {
        ConditionsMetVector cmv = new ConditionsMetVector(15, pm);
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(pm, 15, 15, cmv.getConditionsMetVector());
        FinalUnlockingVector fuv = new FinalUnlockingVector(pm, 15, pum.getPUM());
        return fuv.hasAllTrueValues();
    }
}