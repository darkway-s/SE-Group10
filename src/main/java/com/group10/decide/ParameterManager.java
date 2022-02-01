package com.group10.decide;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ParameterManager {
    private int numPoints;
    private Point[] points;
    private LICParameter licParameter;
    private Matrix<Connector> logicalConnectorMatrix;
    private Vector<Boolean> preliminaryUnlockingVector;

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

    private void readPoints(Scanner scanner) {
        // Get the number of points in this input
        numPoints = scanner.nextInt();
        points = new Point[numPoints];
        // Get the points data
        for (int i = 0; i < numPoints; ++i) {
            points[i].setX(scanner.nextInt());
            points[i].setY(scanner.nextInt());
        }
    }

    private void initFromFile(String inputFilePath) {
        try {
            File inputFile = new File(inputFilePath);
            Scanner inputReader = new Scanner(inputFile);
            readPoints(inputReader);
        } catch (FileNotFoundException e) {
            System.out.println("ParameterManager.initFromFile: File not Found");
            e.printStackTrace();
        }

    }

}
