package com.group10.decide;

public class Point {
    int x, y;

    /**
     * Constructor for Point setting the coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get method for x coordinate.
     * @return The x coordinate.
     */
    public int getX() {
        return x;
    }
    /**
     * Get method for y coordinate.
     * @return The y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Set method for x coordinate.
     * @param x The x coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Set method for y coordinate.
     * @param y The y coordinate.
     */
    public void setY(int y) {
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
    

}
