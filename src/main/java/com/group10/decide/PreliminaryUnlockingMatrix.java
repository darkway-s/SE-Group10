package com.group10.decide;


/**
 * Represents and calculates the Preliminary Unlocking Matrix
 *
 * @author Bror Sebastian Sjövald
 */
public class PreliminaryUnlockingMatrix {
    private Matrix<Connector> lcm;
    private int rows, cols;
    private Vector<Boolean> cmv;
    private Matrix<Boolean> pum;

    /**
     * Constructor for PreliminaryUnlockingMatrix class with option to explicitly set rows and cols
     *
     * @param pm                    ParameterManager containing LCM
     * @param rows                  Rows of PUM
     * @param cols                  Cols of PUM
     * @param conditionsMetVector   CMV with which LICs are fulfilled
     */
    public PreliminaryUnlockingMatrix(ParameterManager pm, int rows, int cols, Vector<Boolean> conditionsMetVector) {
        this.lcm = pm.getLogicalConnectorMatrix();
        this.rows = rows;
        this.cols = cols;
        this.cmv = conditionsMetVector;
        this.pum = new Matrix<>(rows, cols);
        this.calculatePUM();
    }

    /**
     * Constructor for PreliminaryUnlockingMatrix class with option to give LCM without a ParameterManager
     *
     * @param logicalConnectorMatrix    A 15x15 matrix indicating which boolean operator should be used
     * @param conditionsMetVector       CMV with which LICs are fulfilled
     */
    public PreliminaryUnlockingMatrix(Matrix<Connector> logicalConnectorMatrix, Vector<Boolean> conditionsMetVector) {
        this.lcm = logicalConnectorMatrix;
        this.cmv = conditionsMetVector;
        this.rows = 15;
        this.cols = 15;
        this.pum = new Matrix<>(15, 15);
        this.calculatePUM();
    }

    /**
     * Calculates the Preliminary Unlocking Matrix with values set in the object
     */
    public void calculatePUM() {
        Boolean pumVal;
        for (int i = 0; i < rows; i++) {
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
