package com.closestpair.model;

public class Point {

    public double[] coordinates;
    public int line;
    public int dimensions;

    public Point(int line, double[] coordinates) {
        this.line = line;
        this.coordinates = coordinates;
        this.dimensions = coordinates.length;
    }

    public double dist(Point other) {
        double sumDeltas = 0;

        for (int i = 0; i < coordinates.length; i++) {
            sumDeltas += (coordinates[i] - other.coordinates[i]) * (coordinates[i] - other.coordinates[i]);
        }

        return Math.sqrt(sumDeltas);
    }

    public boolean isLeftOf(Point other) {
        final double xCoordinate = coordinates[0];
        final double xCoordinateOther = other.coordinates[0];

        return (xCoordinate < xCoordinateOther || (xCoordinate == xCoordinateOther && line < other.line));
    }

    public boolean isBelow(Point other) {
        final double yCoordinate = coordinates[1];
        final double yCoordinateOther = other.coordinates[1];

        return (yCoordinate < yCoordinateOther || (yCoordinate == yCoordinateOther && line < other.line));
    }
}