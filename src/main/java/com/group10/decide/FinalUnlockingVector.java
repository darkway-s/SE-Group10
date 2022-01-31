package com.group10.decide;

public class FinalUnlockingVector {
    ParameterManager pm;
    int length;
    Matrix<boolean> preliminaryUnlockingMatrix;
    Vector<boolean> finalUnlockingVector;

    public FinalUnlockingVector(ParameterManager pm, int length, Matrix<boolean> preliminaryUnlockingMatrix) {}

    public void setFUV() {}
    
    public Vector<boolean> getFUV() {
        return this.finalUnlockingVector;
    }

    public boolean hasAllTrueValues() {}
}
