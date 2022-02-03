package com.group10.decide;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Locale; //Used to handle dots in decimal format scanning
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * Manages initialization, mutation and I/O of all input
 * @author Sefik-Palazoglu
 */
public class ParameterManager {
    private int numPoints;
    private Vector<Point> points;
    private LICParameter licParameter;
    private Matrix<Connector> logicalConnectorMatrix;
    private Vector<Boolean> preliminaryUnlockingVector;

    /**
     * Read the NUMPOINTS and POINT input from file
     * @param scanner   Scanner object linked to the input file
     */
    private void readPoints(Scanner scanner) {
        // Get the number of points in this input
        this.numPoints = scanner.nextInt();
        this.points = new Vector<Point>(numPoints);
        // Get the points data
        for (int i = 0; i < this.numPoints; i++) {
            double X = scanner.nextDouble();
            double Y = scanner.nextDouble();
            Point newPoint = new Point(X, Y);
            this.points.setValue(i, newPoint);
        }
    }

    /**
     * Read the 19 LIC Parameters input from file
     * @param scanner   Scanner object linked to the input file
     */
    private void readParameters(Scanner scanner) {
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
        this.licParameter = new LICParameter(length1, radius1, epsilon, area1, 
                                        dist, length2, radius2, area2, q_pts, 
                                        quads, n_pts, k_pts, a_pts, b_pts, 
                                        c_pts, d_pts, e_pts, f_pts, g_pts);
    }

    /**
     * Parses integer input into Connector enum
     * @param input the integer input
     */
    private Connector parseConnectorInput(int input) {
        if (input == 0) {
            return Connector.ANDD;
        } else if (input == 1) {
            return Connector.ORR;
        } else {
            return Connector.NOTUSED;
        }
    }


    /**
     * Read the Logical Connector Matrix input from file
     * @param scanner   Scanner object linked to the input file
     */
    private void readLCM(Scanner scanner) {
        int LCMRowSize = 15;
        int LCMColSize = 15;
        this.logicalConnectorMatrix = new Matrix<Connector>(LCMRowSize, LCMColSize);
        for (int curRow = 0; curRow < LCMRowSize; ++curRow) {
            for (int curCol = 0; curCol < LCMColSize; ++curCol) {
                int input = scanner.nextInt();
                this.logicalConnectorMatrix.setValue(curRow, curCol, parseConnectorInput(input));
            }
        }
    }

    /**
     * Read the Preliminary Unlocking Vector input from file
     * @param scanner   Scanner object linked to the input file
     */
    private void readPUV(Scanner scanner) {
        int PUVSize = 15;
        preliminaryUnlockingVector = new Vector<Boolean>(PUVSize);
        for (int curPUV = 0; curPUV < PUVSize; ++curPUV) {
            // input is true if it is equal to 1, false if it is false
            Boolean parsedInput = (scanner.nextInt() == 1);
            preliminaryUnlockingVector.setValue(curPUV, parsedInput);
        }
    }

    /**
     * Initializes all fields of Parameter Manager from given input field
     * @param inputFilePath absolute path to the input file
     */
    private void initFromFile(String inputFilePath) {
        try {
            File inputFile = new File(inputFilePath);
            Scanner inputReader = new Scanner(inputFile).useLocale(Locale.US);;
            readPoints(inputReader);
            readParameters(inputReader);
            readLCM(inputReader);
            readPUV(inputReader);
        } catch (FileNotFoundException e) {
            System.out.println("ParameterManager.initFromFile: File not Found");
            e.printStackTrace();
        }
    }

    /**
     * Default constructor
     */
    public ParameterManager() { }

    /**
     * This constructor initializes the fields with the input from an input file
     * @param inputFilePath absolute path to the input file
     */
    public ParameterManager(String inputFilePath) {
        initFromFile(inputFilePath);
    }

    /**
     * @return the numPoints
     * */
    public int getNumPoints(){
        return this.numPoints;
    }

    /**
     * Setter for numPoints field
     * @param value number of points in the input
     */
    public void setNumPoints(int value) {
        this.numPoints = value;
    }

    /**
     * @return the points
     * */
    public Vector<Point> getPoints(){
        return this.points;
    }

    /**
     * Setter for points field
     * @param value vector of points 
     */
    public void setPoints(Vector<Point> value) {
        this.points = value;
    }

    /**
     * @return the LIC parameters
     * */
    public LICParameter getLICParameter(){
        return this.licParameter;
    }

    /**
     * Setter for LIC Parameter field
     * @param value given LIC Parameters
     */
    public void setLICParameter(LICParameter value) {
        this.licParameter = value;
    }

    /**
     * @return the LCM
     * */
    public Matrix<Connector> getLogicalConnectorMatrix(){
        return this.logicalConnectorMatrix;
    }

    /**
     * Setter for logicalConnectorMatrix field
     * @param value given LCM
     */
    public void setLogicalConnectorMatrix(Matrix<Connector> value) {
        this.logicalConnectorMatrix = value;
    }

    /**
     * @return the PUV
     * */
    public Vector<Boolean> getPreliminaryUnlockingVector(){
        return this.preliminaryUnlockingVector;
    }

    /**
     * Setter for preliminaryUnlockingVector field
     * @param value given PUV
     */
    public void setPreliminaryUnlockingVector(Vector<Boolean> value) {
        this.preliminaryUnlockingVector = value;
    }
}
