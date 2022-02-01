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

    private Connector parseConnectorInput(int input) {
        if (input == 0) {
            return ANDD;
        } else if (input == 1) {
            return ORR;
        } else {
            return NOTUSED;
        }
    }

    //private void readLCM(Scanner scanner) {

    //}

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

}
