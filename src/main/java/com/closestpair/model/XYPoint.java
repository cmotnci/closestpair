package com.closestpair.model;

public class XYPoint {

    public double x;
    public double y;
    public int line;
    static int counter = 1;

    public XYPoint(double xcoord, double ycoord) {
        x = xcoord;
        y = ycoord;
        line = counter++;
    }

    public double dist(XYPoint other) {
        double deltaX = (x - other.x);
        double deltaY = (y - other.y);
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public boolean isLeftOf(XYPoint other) {
        return (x < other.x || (x == other.x && line < other.line));
    }

    public boolean isBelow(XYPoint other) {
        return (y < other.y || (y == other.y && line < other.line));
    }
}