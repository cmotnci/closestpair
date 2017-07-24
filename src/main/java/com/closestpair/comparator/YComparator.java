package com.closestpair.comparator;

import com.closestpair.model.XYPoint;

import java.util.Comparator;

public class YComparator implements Comparator<XYPoint> {
    public int compare(XYPoint p1, XYPoint p2) {
        return (p1.isBelow(p2) ? -1 : (p2.isBelow(p1) ? 1 : 0));
    }
}
