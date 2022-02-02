package com.group10.decide;

public class FinalUnlockingVector {
    ParameterManager pm;
    PreliminaryUnlockingMatrix preliminaryUnlockingMatrix;
    Vector<Boolean> finalUnlockingVector;

    public FinalUnlockingVector(ParameterManager pm, PreliminaryUnlockingMatrix preliminaryUnlockingMatrix) {
        this.pm = pm;
        this.preliminaryUnlockingMatrix = preliminaryUnlockingMatrix;
        this.finalUnlockingVector = new Vector<Boolean>(15);
    }
    public void setFUV() {
        Boolean value;
        for(int i = 0; i < 15; i++)
        {
            value = (pm.getPreliminaryUnlockingVector().getValue(i) == false) ||
                 preliminaryUnlockingMatrix.isRowAllTrue(i);
            finalUnlockingVector.setValue(i, value);
        }
    }
    
    public Vector<Boolean> getFUV() {
        return this.finalUnlockingVector;
    }

    public boolean hasAllTrueValues() {
        for(int i = 0; i < 15; i++)
        {
            if(finalUnlockingVector.getValue(i) == false)
                return false;
        }
        return true;
    }
}
