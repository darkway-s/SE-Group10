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
     * Method to return determine if two point are on the same location.
     * @param p The point to compare to.
     * @return  If they are on the same location.
     */
    public boolean hasSameLocation(Point p){
        if (p.getY() == this.getY() && p.getX() == this.getX()) return true;
        return false;
    }

}
