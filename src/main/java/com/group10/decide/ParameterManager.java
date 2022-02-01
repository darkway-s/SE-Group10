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
     * @param scanner
     */
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

    
    /** 
     * @param inputFilePath
     */
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

    

    /** 
     * Accessor method
     * @return the number of points
     */
    public int getNumPoints() {
        return numPoints;
    }

    
    /** 
     * @return the points array
     */
    public Point[] getPoints() {
        return points;
    }

    /** 
     * @return LIC Parameter struct
     */
    public LICParameter getLicParameter(){
        return licParameter;
    }

    
    /** 
     * @return LCM matrix
     */
    public Matrix<Connector> getLCM(){
        return logicalConnectorMatrix;
    }

    
    /** 
     * @return PUV vector
     */
    public Vector<Boolean> getPUV() {
        return preliminaryUnlockingVector;
    }
    

}
