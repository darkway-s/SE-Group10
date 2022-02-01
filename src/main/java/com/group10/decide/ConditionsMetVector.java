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

    public Boolean LIC0() {
        return Boolean.FALSE;
    }

    public Boolean LIC1() {
        return Boolean.FALSE;
    }

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
            System.out.println(area);
            if (area > pm.getLICParameter().getArea1()) { return Boolean.TRUE; }
        }
        return Boolean.FALSE;
    }

    public Boolean LIC4() { return Boolean.FALSE; }

    public Boolean LIC5() {
        return Boolean.FALSE;
    }

    public Boolean LIC6() {
        return Boolean.FALSE;
    }

    public Boolean LIC7() {
        return Boolean.FALSE;
    }

    public Boolean LIC8() {
        return Boolean.FALSE;
    }

    public Boolean LIC9() {
        return Boolean.FALSE;
    }

    public Boolean LIC10() {
        return Boolean.FALSE;
    }

    public Boolean LIC11() {
        return Boolean.FALSE;
    }

    public Boolean LIC12() {
        return Boolean.FALSE;
    }

    public Boolean LIC13() {
        return Boolean.FALSE;
    }

    public Boolean LIC14() {
        return Boolean.FALSE;
    }

    public Vector<Boolean> getConditionsMetVector() {
        return this.conditionsMetVector;
    }
}
