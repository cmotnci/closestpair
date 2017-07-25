package com.closestpair.strategy;

import com.closestpair.model.Pair;
import com.closestpair.model.Point;
import com.closestpair.comparator.*;

import java.util.Arrays;
import java.util.Date;

public class DivideAndConquerStrategy {

    public static Pair findClosestPair(Point[] points) {
        XComparator lessThanX = new XComparator();
        YComparator lessThanY = new YComparator();

        Date startTime = new Date();

        Point pointsByX[] = new Point[points.length];
        Point pointsByY[] = new Point[points.length];

        for (int j = 0; j < points.length; j++) {
            pointsByX[j] = points[j];
            pointsByY[j] = points[j];
        }

        Arrays.sort(pointsByX, lessThanX);
        Arrays.sort(pointsByY, lessThanY);

        int pointsCounted = pointsByX.length;
        Pair closestPair = findClosestPairHelper(pointsByX, pointsByY, pointsCounted,
                new Pair(null, null));

        Date endTime = new Date();
        long elapsedTime = endTime.getTime() - startTime.getTime();

        closestPair.elapsedTime = elapsedTime;

        return closestPair;
    }

    private static Pair findClosestPairHelper(Point[] pointsByX, Point[] pointsByY,
                                              int pointsCounted, Pair closest) {
        if (pointsCounted == 1) {
            return new Pair(null, null);
        }
        if (pointsCounted == 2) {
            return closest.returnMin(new Pair(pointsByX[0], pointsByX[1]));
        }

        int middle = (int) (Math.floor((pointsCounted / 2)));

        int lengthRight = pointsCounted - (middle);
        int lengthLeft = middle;
        Point[] xLeft = new Point[lengthLeft];
        Point[] xRight = new Point[lengthRight];
        System.arraycopy(pointsByX, 0, xLeft, 0, lengthLeft);
        System.arraycopy(pointsByX, lengthLeft, xRight, 0, lengthRight);

        Point[] yLeft = new Point[lengthLeft];
        Point[] yRight = new Point[lengthRight];
        int j = 0;
        int k = 0;

        for (int i = 0; i < pointsCounted; i++) {
            if (pointsByY[i].isLeftOf(pointsByX[middle])) {
                yLeft[j] = pointsByY[i];
                j++;
            } else {
                yRight[k] = pointsByY[i];
                k++;
            }
        }

        Pair closestLeftPair = findClosestPairHelper(xLeft, yLeft, lengthLeft, closest);
        Pair closestRightPair = findClosestPairHelper(xRight, yRight, lengthRight, closest);

        return combine(pointsByY, pointsByX[middle], closestLeftPair.returnMin(closestRightPair));
    }

    private static Pair combine(Point pointsByY[], Point midPoint, Pair closest) {
        int nPoints = pointsByY.length;
        Point[] yStripTemp = new Point[nPoints];
        int count = 0;

        for (int i = 0; i <= nPoints - 1; i++) {
            double xCoordOfY = pointsByY[i].coordinates[0];
            double xCoordOfMid = midPoint.coordinates[0];
            if (Math.abs(xCoordOfY - xCoordOfMid) < closest.getDist()) {
                yStripTemp[count] = pointsByY[i];
                count++;
            }
        }

        Point[] yStrip = new Point[count];
        System.arraycopy(yStripTemp, 0, yStrip, 0, count);
        Pair newPair = closest;

        for (int j = 0; j <= yStrip.length - 2; j++) {
            int k = j + 1;
            final double yCoordOfStripK = yStrip[k].coordinates[1];
            final double yCoordOfStripJ = yStrip[j].coordinates[1];

            while (k <= yStrip.length - 1 && (yCoordOfStripK - yCoordOfStripJ) < closest.getDist()) {
                Pair tempPair = new Pair(yStrip[j], yStrip[k]);
                newPair = newPair.returnMin(tempPair);
                k++;
            }
        }
        return newPair;
    }
}