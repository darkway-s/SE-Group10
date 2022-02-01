package com.group10.decide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {
    /**
     * Test if getRows() returns the correct number of rows.
     */
    @Test
    @DisplayName("Get matrix rows")
    public void getRows() {
        Matrix<Integer> matrix = new Matrix<>(2, 2);
        assertEquals(2, matrix.getRows(), "Matrix rows should be 2");
    }
    /**
     * Test if getCols() returns the correct number of columns.
     */
    @Test
    @DisplayName("Get matrix cols")
    public void getCols() {
        Matrix<Integer> matrix = new Matrix<>(2, 2);
        assertEquals(2, matrix.getCols(), "Matrix cols should be 2");
    }
    /**
     * Test if setValue() sets the value correctly and getValue() returns the correct value.
     */
    @Test
    @DisplayName("Get matrix value")
    public void getValue() {
        Matrix<Integer> matrix = new Matrix<>(2, 2);
        matrix.setValue(0, 0, 1);
        assertEquals(1, matrix.getValue(0, 0), "Matrix value should be 1");
    }
}
