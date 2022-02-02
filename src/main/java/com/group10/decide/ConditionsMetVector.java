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
        int size - this.pm.getNumPoints();
        // We need to compare 3 consecutive points, so if we have 2, return FALSE
        if (size < 3) {
            return Boolean.FALSE;
        }
        Vector<Point> pointsArray = this.pm.getPoints();
        double radius1 = this.pm.getLICParameter().getRadius1();
        for (int i = 0; i < size - 2; i++) {
            Point pointA = pointsArray.getValue(i);
            Point pointB = pointsArray.getValue(i + 1);
            Point pointC = pointsArray.getValue(i + 2);

            // we need sums to calculate centroid
            double sumX = pointA.getX() + pointB.getX() + pointC.getX();
            double sumY = pointA.getY() + pointB.getY() + pointC.getY();

            // centroid is the weighed sums, divide by 3
            Point centroid = new Point(sumX / 3, sumY / 3);
            // minimal radius is the distance from centroid to any point
            double minimalRadius = centroid.distance(pointA);

            // if these three points cannot be contained in a circle of radius radius1,
            if (radius1 < minimalRadius) {
                return Boolean.TRUE;
            }
        }

        return Boolean.False;
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
     * Computes the 7th Launch Interceptor Condition
     * True if there exists two points, separated by KPts intervening points, that are LENGTH1 distance apart
     *
     * @return Boolean
     */
    public Boolean LIC7() {
        if (pm.getNumPoints() < 3) {
            return Boolean.FALSE;
        }

        Vector<Point> points = pm.getPoints();
        int KPts = pm.getLICParameter().getKPts();
        double Length1 = pm.getLICParameter().getLength1();
        for (int i = 0; i < pm.getNumPoints() - KPts - 1; i++) {
            if (points.getValue(i).distance(points.getValue(i + KPts + 1)) > Length1) {
                return Boolean.TRUE;
            }
        }
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
