package com.group10.decide;

/**
 * Matrix class for type generic type T.
 */
public class Matrix<T> {    
    
    private int rows;
    private int cols;
    private T[][] matrix;


    /**
     * Matrix constructor with size and specified values.
     * @param rows number of rows
     * @param cols number of columns
     * @param values values to be set
     */
    public Matrix(int rows, int cols, T[][] values) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = values;
    }
    /**
     * Matrix constructor with size.
     * @param rows number of rows
     * @param cols number of columns
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = (T[][]) new Object[rows][cols];
    }

    /**
     * Get a specific row from the matrix by index.
     * @return list of values in the row
     */
    public T[] getRow(int rowIndex) {
        return matrix[rowIndex];
    }
    /**
     * Get a specific column from the matrix by index.
     * @return list of values in the column
     */
    public T[] getCol(int colIndex) {
        T[] col = (T[]) new Object[rows];
        for (int i = 0; i < rows; i++) {
            col[i] = matrix[i][colIndex];
        }
        return col;
    }

    /**
     * Get number of rows.
     * @return number of rows
     */
    public int getRowLength() {
        return rows;
    }
    /**
     * Get number of columns.
     * @return number of columns
     */
    public int getColLength() {
        return cols;
    }
    /**
     * Get matrix
     * @return matrix
     */
    public T[][] getMatrix() {
        return matrix;
    }
    /**
     * Set matrix value.
     * @param value value to be set
     */
    public void setMatrix(T[][] matrix) {
        this.matrix = matrix;
    }
    /**
     * Get matrix value at specified row and column.
     * @param row row index
     * @param col column index
     * @return value at specified row and column
     */
    public T getValue(int row, int col) {
        return matrix[row][col];
    }
    /**
     * Set matrix value at specified row and column.
     * @param row row index
     * @param col column index
     * @param value value to be set
     */
    public void setValue(int row, int col, T value) {
        matrix[row][col] = value;
    }
}
