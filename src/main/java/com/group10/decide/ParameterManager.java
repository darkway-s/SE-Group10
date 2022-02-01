package com.group10.decide;

public class ParameterManager {
    int numPoints;
    Point[] points;
    LICParameter licParameter;
    Matrix<Connector> logicalConnectorMatrix;
    Vector<Boolean> preliminaryUnlockingVector;

    /**
     * Consturctor
     * TODO
     */
    public ParameterManager(int NUMPOINTS, Point[] POINTS, LICParameter PARAMETERS,
                            Matrix<Connector> LCM, Vector<Boolean> PUV) 
    {
        //TODO
        this.numPoints = NUMPOINTS;
        this.points = POINTS;
        this.licParameter = PARAMETERS;
        this.logicalConnectorMatrix = LCM;
        this.preliminaryUnlockingVector = PUV;
    }


    /**
     * Get method for numPoints.
     * @return The num of points.
     */
    public int getNumPoints() {
        return numPoints;
    }

    /**
     * Get method for points.
     * @return The array of points.
     */
    public Point[] getPoints() {
        return points;
    }

    
    /** 
     * Get method for licParameter
     * @return LICParameter
     */
    public LICParameter getLicParameter() {
        return licParameter;
    }

}
