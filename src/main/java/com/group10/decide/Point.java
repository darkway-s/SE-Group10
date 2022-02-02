package com.group10.decide;

public class Point {
    double x, y;

    /**
     * Constructor for Point setting the coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get method for x coordinate.
     * @return The x coordinate.
     */
    public double getX() {
        return x;
    }
    /**
     * Get method for y coordinate.
     * @return The y coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Set method for x coordinate.
     * @param x The x coordinate.
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Set method for y coordinate.
     * @param y The y coordinate.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Method to return the euqlidian distance between two points.
     * @param p The point to calculate the distance to.
     * @return The distance between the two points.
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.getX() - this.getX(), 2) + Math.pow(p.getY() - this.getY(), 2));
    }

    /**
     * Method calculating the distance to the line created by two points.
     * Formula from https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line (Line defined by two points)
     * @param p1    the starting point of the line
     * @param p2    the ending point of the line
     * @return      the distance
     * */
    public double distanceToLine(Point p1, Point p2){
        return Math.abs(((p2.getX() - p1.getX()) * (p1.getY() - this.getY()))
                - ((p1.getX() - this.getX()) * (p2.getY() - p1.getY()))) / p1.distance(p2);
    }

    /**
     * Method calculating the area of a triangle from three points.
     * @param p2 The second point.
     * @param p3 The third point.
     * @return double The area of the triangle.
     */
    public double triangleArea(Point p2, Point p3) {
        return Math.abs((this.getX()*(p2.getY() - p3.getY()) +
                p2.getX()*(p3.getY() - this.getY()) +
                p3.getX()*(this.getY() - p2.getY())) / 2);
    }

    /**
     * Method calculating the minimal radius from the three points (this, p1, p2).
     * @param p1 The    second point.
     * @param p2 The    third point.
     * @return double   The minimal radius of the circle.
     */
    public double minimalRadiusFromThreePoints(Point p1, Point p2){
        double a = this.distance(p2);
        double b = p1.distance(this);
        double c = p1.distance(p2);

        // using the formula of circumscribed circle's radius
        double lengthProduct = a * b * c;
        double s = (a + b + c) / 2;
        double diffLengthProduct = s * (s - a) * (s - b) * (s - c);
        double minimalRadius = lengthProduct / (4 * Math.sqrt(diffLengthProduct));

        return minimalRadius;
    }

    /**
     * Method to return determine if two point are on the same location.
     * @param p The point to compare to.
     * @return  If they are on the same location.
     */
    public boolean hasSameLocation(Point p){
        if (p.getY() == this.getY() && p.getX() == this.getX()) return true;
        return false;
    }

}
