package com.group10.decide;

public class FinalUnlockingVector {
    ParameterManager pm;
    int length;
    Matrix<Boolean> preliminaryUnlockingMatrix;
    Vector<Boolean> finalUnlockingVector;

    public FinalUnlockingVector(ParameterManager pm, int length, Matrix<Boolean> preliminaryUnlockingMatrix) {}

    public void setFUV() {}
    
    public Vector<Boolean> getFUV() {
        return this.finalUnlockingVector;
    }

    public boolean hasAllTrueValues() {
        return false;
    }
}
