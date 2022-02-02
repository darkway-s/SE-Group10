package com.group10.decide;

/**
 * Class for the final unlocking vector
 * */
public class FinalUnlockingVector {
    ParameterManager pm;
    PreliminaryUnlockingMatrix preliminaryUnlockingMatrix;
    Vector<Boolean> finalUnlockingVector;

    /**
     * Default constructor
     * @param preliminaryUnlockingMatrix    the PUV
     * @param pm    a ParameterManager object which conatins all necesarry parameters
     * */
    public FinalUnlockingVector(ParameterManager pm, PreliminaryUnlockingMatrix preliminaryUnlockingMatrix) {
        this.pm = pm;
        this.preliminaryUnlockingMatrix = preliminaryUnlockingMatrix;
        this.finalUnlockingVector = new Vector<Boolean>(15);

        setFUV();
    }


    /** 
     * Sets the values of the final unlocking vector
     */
    public void setFUV() {
        Boolean value;
        for(int i = 0; i < 15; i++) {
            value = (pm.getPreliminaryUnlockingVector().getValue(i) == false) ||
                 preliminaryUnlockingMatrix.isRowAllTrue(i);
            finalUnlockingVector.setValue(i, value);
        }
    }
    
    
    /**
     * Gets the final unlocking vector
     * @return the final unlocking vector
     */
    public Vector<Boolean> getFUV() {
        return this.finalUnlockingVector;
    }

    
    /** 
     * Checks if all the elements in FUV are true
     * @return  if all elements of the vector is true
     */
    public boolean hasAllTrueValues() {
        for(int i = 0; i < 15; i++) {
            if(finalUnlockingVector.getValue(i) == false)
                return false;
        }
        return true;
    }
}
