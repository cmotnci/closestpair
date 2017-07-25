package com.closestpair.comparator;

import com.closestpair.model.Point;

import java.util.Comparator;

public class XComparator implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return (p1.isLeftOf(p2) ? -1 : (p2.isLeftOf(p1) ? 1 : 0));
    }
}
