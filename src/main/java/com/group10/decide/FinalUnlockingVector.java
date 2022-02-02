package com.group10.decide;

public class FinalUnlockingVector {
    ParameterManager pm;
    Matrix<Boolean> preliminaryUnlockingMatrix;
    Vector<Boolean> finalUnlockingVector;

    public FinalUnlockingVector(ParameterManager pm, Matrix<Boolean> preliminaryUnlockingMatrix) {
        this.pm = pm;
        this.preliminaryUnlockingMatrix = preliminaryUnlockingMatrix;
    }

    public void setFUV() {}
    
    public Vector<Boolean> getFUV() {
        return this.finalUnlockingVector;
    }

    public boolean hasAllTrueValues() {
        return false;
    }
}
