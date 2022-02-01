package com.group10.decide;

public class ConditionsMetVector {
    ParameterManager pm;
    int length;
    Vector<Boolean> conditionsMetVector;


    public ConditionsMetVector(ParameterManager pm) {
        this.length = 15;
        this.pm = pm;
    }

    public ConditionsMetVector(int length, ParameterManager pm) {
        this.length = length;
        this.pm = pm;
    }

    public void setConditionsVector(ParameterManager pm) {
        this.pm = pm;
    }
    
    
    /** 
     * There exists at least one set of two consecutive data points
     *  that are a distance greater than LENGTH1. (0 ≤ LENGTH1)
     * @return Boolean. True if there exists two consecutive data points, otherwise False
     */
    public Boolean LIC0() {
        int siz = this.pm.getNumPoints();
        Vector<Point> pointsArray =  this.pm.getPoints();
        double length1 = this.pm.getLICParameter().getLength1();
        for(int i = 0; i < siz - 1; i++)
        {
            if(pointsArray.getValue(i).distance(pointsArray.getValue(i+1)) > length1)
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
     * Computes the 3rd Launch Interceptor Condition
     * True if there exists 3 consecutive points that form the vertices of a triangle and that triangle has an area greater than pm.AREA1
     *
     * @return  Boolean
     */
    public Boolean LIC3() {
        Point pointOne, pointTwo, pointThree;
        Vector<Point> points = pm.getPoints();
        double area;
        for (int i = 0; i < pm.getNumPoints() - 2; i++) {
            pointOne = points.getValue(i);
            pointTwo = points.getValue(i + 1);
            pointThree = points.getValue(i + 2);
            area = Math.abs((pointOne.getX()*(pointTwo.getY() - pointThree.getY()) +
                    pointTwo.getX()*(pointThree.getY() - pointOne.getY()) +
                    pointThree.getX()*(pointOne.getY() - pointTwo.getY())) / 2);
            if (area > pm.getLICParameter().getArea1()) { return Boolean.TRUE; }
        }
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
