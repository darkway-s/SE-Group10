package com.group10.decide;

import java.util.Arrays;

public class Vector<T> {

    private int length;
    private T [] vector;

    public Vector(int length){
        this.length = length;
        this.vector = (T[]) new Object[this.length];
        for(int i = 0; i < length; i++){
            this.vector[i] = null;
        }
    }

    public Vector(int length, T [] values){
        this.length = length;
        this.vector = values;
    }

    public void setValue(int index, T value){
        if(index > (this.length - 1) || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for vector length " + this.length);
        this.vector[index] = value;
    }

    public T getValue(int index){
        if(index > (this.length - 1) || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for vector length " + this.length);
        return this.vector[index];
    }

    public T [] getValues(){
        return this.vector;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.vector);
    }

}
