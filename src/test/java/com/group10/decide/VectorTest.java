package com.group10.decide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Vector class.
 */
public class VectorTest {

    Vector vectorWithNoInitialValues;
    Vector vectorWithInitialValues;
    Boolean[] vectorValues;

    /**
     * Instantiate two new Vector object used for testing.
     * One vector object without initial values set and one with initial values set.
     * */
    @BeforeEach
    public void setUp() {
        vectorValues = new Boolean[] { true, true, false, false, true };
        vectorWithInitialValues = new Vector<Boolean>(5, vectorValues);
        vectorWithNoInitialValues = new Vector<Boolean>(5);
    }

    /**
     * Test if possible to set and get a value from Vector object
     * that has been initialized with specific values.
     */
    @Test
    @DisplayName("Set value on vector with initial values")
    public void testSetValues() {
        vectorWithInitialValues.setValue(1, false);
        assertEquals(false, vectorWithInitialValues.getValue(1), "Expected value on index 1 to be false.");
    }

    /**
     * Test if possible to set and get a value from Vector object
     * that has not been initialized with specific values.
     */
    @Test
    @DisplayName("Set values on vector without initial values")
    public void testSetValueWithoutInitialValues() {
        vectorWithNoInitialValues.setValue(1, false);
        assertEquals(false, vectorWithNoInitialValues.getValue(1), "Expected value on index 1 to be false.");
    }

    /**
     * Test if possible to get a value that has not been set yet
     * from a Vector object.
     */
    @Test
    @DisplayName("Get values from vector without initial values and no set values")
    public void testGetValueWithoutValuesSet() {
        assertEquals(null, vectorWithNoInitialValues.getValue(1), "Expected to be null");
    }

    /**
     * Test if possible to get a value that has been set from a Vector object.
     * */
    @Test
    @DisplayName("Get values in vector with all set values")
    public void testGetValuesWithValuesSet() {
        assertEquals(vectorValues, vectorWithInitialValues.getValues(), "Expected to be [true, true, false, false, true]");
    }

    /**
     * Test if getting a value from an invalid index throws an IndexOutOfBounds exception.
     * */
    @Test
    @DisplayName("Get value on invalid index")
    public void testGetValueWithInvalidIndex() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            vectorWithInitialValues.getValue(6);
        });
        assertEquals("Index " + 6 + " out of bounds for vector length " + 5, exception.getMessage());
    }

    /**
     * Test if setting a value on an invalid index throws an IndexOutOfBounds exception.
     * */
    @Test
    @DisplayName("Set value on invalid index")
    public void testSetValueWithInvalidIndex() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            vectorWithInitialValues.setValue(6, false);
        });
        assertEquals("Index " + 6 + " out of bounds for vector length " + 5, exception.getMessage());
    }

    /**
     * Test if initializing a Vector with more values than vector
     * length throws an IndexOutOfBounds exception.
     * */
    @Test
    @DisplayName("Initialize vector with values.length != vector.length")
    public void testSetVectorWithMoreValuesThanLength() {
        Boolean[] vectorValues = new Boolean[] { true, true, false, false, true };

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            new Vector<Boolean>(4, vectorValues);
        });
        assertEquals("The specified length is not equal to the length of the intial values", exception.getMessage());
    }


    /**
     * Test if Vector object is string formatted correctly.
     * */
    @Test
    @DisplayName("toString formatting for vector with values.")
    public void testStringFormattning() {
        assertEquals("[true, true, false, false, true]", vectorWithInitialValues.toString(), "Expected to be [true, true, false, false, true].");
    }

    /**
     * Test if Vector object is string formatted correctly, with null values.
     * */
    @Test
    @DisplayName("toString formatting for vector with missing values.")
    public void testStringFormattningWithMissingValues() {
        vectorWithNoInitialValues.setValue(1, true);
        assertEquals("[null, true, null, null, null]", vectorWithNoInitialValues.toString(), "Expected to be [null, true, null, null, null].");
    }
}

