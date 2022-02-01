package com.group10.decide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {
    Matrix<Integer> matrix;
    /**
     * Instantiates a new Matrix test.
     */
    @BeforeEach
    public void setUp(){
        matrix = new Matrix<>(2, 2);
        matrix.setValue(0, 0, 1);
        matrix.setValue(0, 1, 2);
        matrix.setValue(1, 0, 3);
        matrix.setValue(1, 1, 4);
    }
    /**
     * Test if getRows() returns the correct number of rows.
     */
    @Test
    @DisplayName("Get number of matrix rows")
    public void getRows() {
        assertEquals(2, matrix.getRowLength(), "Matrix rows should be 2");
    }
    /**
     * Test if getCols() returns the correct number of columns.
     */
    @Test
    @DisplayName("Get number of matrix cols")
    public void getCols() {
        assertEquals(2, matrix.getColLength(), "Matrix cols should be 2");
    }
    /**
     * Test if setValue() sets the value correctly and getValue() returns the correct value.
     */
    @Test
    @DisplayName("Get matrix value")
    public void getValue() {
        assertEquals(1, matrix.getValue(0, 0), "Matrix value should be 1");
    }
    /**
     * Test if getRow() returns the correct column.
     */
    @Test
    @DisplayName("Get matrix row")
    public void getRow() {
        Object[] row = matrix.getRow(0);
        assertEquals(1, row[0], "Matrix row should be 1");
        assertEquals(2, row[1], "Matrix row should be 2");
    }
    /**
     * Test if getCol() returns the correct column.
     */
    @Test
    @DisplayName("Get matrix col")
    public void getCol() {
        Object[] col = matrix.getCol(0);
        assertEquals(1, col[0], "Matrix col should be 1");
        assertEquals(3, col[1], "Matrix col should be 3");
    }
}
