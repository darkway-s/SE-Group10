package com.group10.decide;

import java.util.Arrays;

/**
 * Class for a Vector
 *
 * @author Amanda Krohn
 * */
public class Vector<T> {

    private int length;
    private T [] vector;

    /**
     * Constructor for Vector setting the length
     * @param length    The length of the vector
     */
    public Vector(int length){
        this.length = length;
        this.vector = (T[]) new Object[this.length];
        for(int i = 0; i < length; i++){
            this.vector[i] = null;
        }
    }

    /**
     * Constructor for Vector setting the length and initial values
     * @param length    The length of the vector
     * @param values    The initial values
     */
    public Vector(int length, T [] values){
        this.length = length;
        if(values.length != this.length) throw new IndexOutOfBoundsException("The specified length is not equal to the length of the intial values");
        this.vector = values;
    }

    /**
     * Sets a value on a specified index on the vector
     * @param index     The index of the value to be set
     * @param value     The value to be set
     */
    public void setValue(int index, T value){
        if(index > (this.length - 1) || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for vector length " + this.length);
        this.vector[index] = value;
    }

    /**
     * Get a value on a specified index on the vector
     * @param index     The index of the value
     * @return          The value on the specified index
     */
    public T getValue(int index){
        if(index > (this.length - 1) || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for vector length " + this.length);
        return this.vector[index];
    }

    /**
     * Get all values of the vector
     * @return      All the values of the vector
     */
    public T [] getValues(){
        return this.vector;
    }

    /**
     * Get the length of the vector
     * @return      The length of the vector
     */
    public int length(){
        return this.length;
    }

    /**
     * Convert the vector to a string
     * @return      The vector as a string
     */
    @Override
    public String toString(){
        return Arrays.toString(this.vector);
    }

}
