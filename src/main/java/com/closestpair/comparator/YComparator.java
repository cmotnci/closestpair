package com.closestpair.comparator;

import com.closestpair.model.Point;

import java.util.Comparator;

public class YComparator implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return (p1.isBelow(p2) ? -1 : (p2.isBelow(p1) ? 1 : 0));
    }
}
