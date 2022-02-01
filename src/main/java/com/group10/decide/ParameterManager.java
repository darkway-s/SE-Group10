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

    private void readLICParameters(Scanner scanner) {
        double length1 = scanner.nextDouble();
        double radius1 = scanner.nextDouble();
        double epsilon = scanner.nextDouble();
        double area1 = scanner.nextDouble();
        int q_pts = scanner.nextInt();
        int quads = scanner.nextInt();
        double dist = scanner.nextDouble();
        int n_pts = scanner.nextInt();
        int k_pts = scanner.nextInt();
        int a_pts = scanner.nextInt();
        int b_pts = scanner.nextInt();
        int c_pts = scanner.nextInt();
        int d_pts = scanner.nextInt();
        int e_pts = scanner.nextInt();
        int f_pts = scanner.nextInt();
        int g_pts = scanner.nextInt();
        double length2 = scanner.nextDouble();
        double radius2 = scanner.nextDouble();
        double area2 = scanner.nextDouble();
        licParameter = new LICParameter(length1, radius1, epsilon, area1, 
                                        dist, length2, radius2, area2, q_pts, 
                                        quads, n_pts, k_pts, a_pts, b_pts, 
                                        c_pts, d_pts, e_pts, f_pts, g_pts);
    }

    private void initFromFile(String inputFilePath) {
        try {
            File inputFile = new File(inputFilePath);
            Scanner inputReader = new Scanner(inputFile);
            readPoints(inputReader);
            readLICParameters(inputReader);
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
