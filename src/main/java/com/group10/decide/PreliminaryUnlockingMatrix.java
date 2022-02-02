package com.group10.decide;

/**
 * Represents and calculates the Preliminary Unlocking Matrix
 *
 * @author Bror Sebastian Sjövald
 */
public class PreliminaryUnlockingMatrix {
    private final int N = 15;
    private Matrix<Boolean> pum;

    /**
     * Constructor for PreliminaryUnlockingMatrix class that takes in LCM and CMV
     *
     * @param logicalConnectorMatrix A 15x15 matrix indicating which boolean
     *                               operator should be used
     * @param conditionsMetVector    CMV of length 15 with which LICs are fulfilled
     */
    public PreliminaryUnlockingMatrix(Matrix<Connector> logicalConnectorMatrix, Vector<Boolean> conditionsMetVector) {
        this.pum = new Matrix<>(15, 15);
        this.calculatePUM(logicalConnectorMatrix, conditionsMetVector);
    }

    /**
     * Calculates the Preliminary Unlocking Matrix with values set in the object
     * 
     * @param lcm A 15x15 matrix indicating which boolean
     *            operator should be used
     * @param cmv CMV of length 15 with which LICs are fulfilled
     */
    public void calculatePUM(Matrix<Connector> lcm, Vector<Boolean> cmv) {
        Boolean pumVal;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                switch (lcm.getValue(i, j)) {
                    case NOTUSED:
                        pum.setValue(i, j, Boolean.TRUE);
                        pum.setValue(j, i, Boolean.TRUE);
                        break;
                    case ORR:
                        pumVal = cmv.getValue(i) || cmv.getValue(j);
                        pum.setValue(i, j, pumVal);
                        pum.setValue(j, i, pumVal);
                        break;
                    case ANDD:
                        pumVal = cmv.getValue(i) && cmv.getValue(j);
                        pum.setValue(i, j, pumVal);
                        pum.setValue(j, i, pumVal);
                        break;
                }
            }
        }
    }

    /**
     * Gets the PreliminaryUnlockingMatrix
     *
     * @return A 15x15 Matrix of Boolean values
     */
    public Matrix<Boolean> getPUM() {
        return this.pum;
    }

}
