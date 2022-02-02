package com.group10.decide;

import java.util.Set;
import java.util.HashSet;

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
        int size = this.pm.getNumPoints();
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

            double a = pointC.distance(pointB);
            double b = pointA.distance(pointC);
            double c = pointA.distance(pointB);

            // using the formula of circumscribed circle's radius
            double lengthProduct = a * b * c;
            double s = (a + b + c) / 2;
            double diffLengthProduct = s * (s - a) * (s - b) * (s - c);
            double minimalRadius = lengthProduct / (4 * Math.sqrt(diffLengthProduct));

            // if these three points cannot be contained in a circle of radius radius1,
            if (radius1 < minimalRadius) {
                return Boolean.TRUE;
            }
        }

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
            area = pointOne.triangleArea(pointTwo, pointThree);
            if (area > pm.getLICParameter().getArea1()) { return Boolean.TRUE; }
        }
        return Boolean.FALSE;
    }


    /** Checking that at least one set of qPts number of consecutive points lies
     *  in more than quads number of quadrants.
     * @return Boolean True if there exist at least one set. False if not.
     */
    public Boolean LIC4() {
        int qPts = pm.getLICParameter().getQPts();
        int quads = pm.getLICParameter().getQuads();
        Vector<Point> points = pm.getPoints();
        int length = pm.getNumPoints();
        //Going through each point and checking if the nr of unique quadrants represented by the point is more than quads
        for (int i = 0; i < length - qPts +1; i++) {
            Set<Integer> uniqeQuadrants = new HashSet<Integer>();
            for (int j = 0; j < qPts; j++) {
                if (points.getValue(i + j).getX() > 0 && points.getValue(i + j).getY() > 0) {
                    uniqeQuadrants.add(1);
                }
                if (points.getValue(i + j).getX() < 0 && points.getValue(i + j).getY() > 0) {
                    uniqeQuadrants.add(2);
                }
                if (points.getValue(i + j).getX() < 0 && points.getValue(i + j).getY() < 0) {
                    uniqeQuadrants.add(3);
                }
                if (points.getValue(i + j).getX() > 0 && points.getValue(i + j).getY() < 0) {
                    uniqeQuadrants.add(4);
                }
            }
            if (uniqeQuadrants.size() > quads) {
                return Boolean.TRUE;
            }
        }
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
     * <h3>Computes the 14th Launch Interceptor Condition</h3>
     *
     * <b>True</b> if there exists three points separated by EPts and FPts intervening points that form the vertices of
     * a triangle with an area greater than area1 and three more points that are separated by the same conditions
     * but could be the same which form the vertices of a triangle with an area less than area2. <b>False</b> otherwise.
     *
     * @return Boolean
     */
    public Boolean LIC14() {
        if (pm.getNumPoints() < 5) {
            return Boolean.FALSE;
        }

        Point pointOne, pointTwo, pointThree;
        Vector<Point> points = pm.getPoints();
        LICParameter lic = pm.getLICParameter();
        double  area,
                area1 = lic.getArea1(),
                area2 = lic.getArea2();
        int     EPts = lic.getEPts(),
                FPts = lic.getFPts();
        boolean greaterThanArea1 = false,
                lesserThanArea2 = false;
        for (int i = 0; i < pm.getNumPoints() - EPts - FPts - 2; i++) {
            pointOne = points.getValue(i);
            pointTwo = points.getValue(i + EPts + 1);
            pointThree = points.getValue(i + EPts + FPts + 2);
            area = pointOne.triangleArea(pointTwo, pointThree);
            if (area > area1) { greaterThanArea1 = true; }
            if (area < area2) { lesserThanArea2 = true; }
            if (greaterThanArea1 && lesserThanArea2) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    
    /** 
     * @return Vector<Boolean>
     */
    public Vector<Boolean> getConditionsMetVector() {
        return this.conditionsMetVector;
    }
}
