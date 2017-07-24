package com.closestpair.strategy;

import com.closestpair.model.Pair;
import com.closestpair.model.XYPoint;
import com.closestpair.comparator.*;

import java.util.Arrays;
import java.util.Date;

public class DivideAndConquerStrategy {

  public static Pair findClosestPair(XYPoint[] points) {
    XComparator lessThanX = new XComparator();
    YComparator lessThanY = new YComparator();

    Date startTime = new Date();

    XYPoint pointsByX[] = new XYPoint[points.length];
    XYPoint pointsByY[] = new XYPoint[points.length];

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

  private static Pair findClosestPairHelper(XYPoint[] pointsByX, XYPoint[] pointsByY,
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
    XYPoint[] xLeft = new XYPoint[lengthLeft];
    XYPoint[] xRight = new XYPoint[lengthRight];
    System.arraycopy(pointsByX, 0, xLeft, 0, lengthLeft);
    System.arraycopy(pointsByX, lengthLeft, xRight, 0, lengthRight);

    XYPoint[] yLeft = new XYPoint[lengthLeft];
    XYPoint[] yRight = new XYPoint[lengthRight];
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

  private static Pair combine(XYPoint pointsByY[], XYPoint midPoint, Pair closest) {
    int nPoints = pointsByY.length;
    XYPoint[] yStripTemp = new XYPoint[nPoints];
    int count = 0;

    for (int i = 0; i <= nPoints - 1; i++) {
      if (Math.abs(pointsByY[i].x - midPoint.x) < closest.getDist()) {
        yStripTemp[count] = pointsByY[i];
        count++;
      }
    }

    XYPoint[] yStrip = new XYPoint[count];
    System.arraycopy(yStripTemp, 0, yStrip, 0, count);
    Pair newPair = closest;

    for (int j = 0; j <= yStrip.length - 2; j++) {
      int k = j + 1;
      while (k <= yStrip.length - 1 && (yStrip[k].y - yStrip[j].y) < closest.getDist()) {
        Pair tempPair = new Pair(yStrip[j], yStrip[k]);
        newPair = newPair.returnMin(tempPair);
        k++;
      }
    }
    return newPair;
  }
}