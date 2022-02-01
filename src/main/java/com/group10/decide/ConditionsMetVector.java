package com.group10.decide;

public class ConditionsMetVector {
    ParameterManager pm;
    int length;
    Vector<Boolean> conditionsMetVector;


    public ConditionsMetVector(int length, ParameterManager pm) {
        this.length = length;
        this.pm = pm;
    }

    public void setConditionsVector() {

    }
    
    
    /** 
     * There exists at least one set of two consecutive data points
     *  that are a distance greater than LENGTH1. (0 ≤ LENGTH1)
     * @return Boolean. True if there exists two consecutive data points, otherwise false
     */
    public Boolean LIC0() {
        int siz = this.pm.getNumPoints();
        Point[] pointsArray =  this.pm.getPoints();
        double length1 = this.pm.licParameter.getLength1();
        for(int i = 0; i < siz - 1; i++)
        {
            if(pointsArray[i].distance(pointsArray[i+1]) > length1)
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC1() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC2() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC3() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC4() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC5() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC6() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC7() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC8() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC9() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC10() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC11() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC12() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC13() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean LIC14() {
        return Boolean.FALSE;
    }

    
    /** 
     * @return Vector<Boolean>
     */
    public Vector<Boolean> getConditionsMetVector() {
        return this.conditionsMetVector;
    }
}
