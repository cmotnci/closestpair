package com.closestpair.strategy;

import com.closestpair.model.Pair;
import com.closestpair.model.XYPoint;

import java.util.Date;

public class NaiveStrategy {

  public static Pair findClosestPair(XYPoint points[]) {
    Date startTimeNaive = new Date();
    Pair closestPair = findClosestPairHelper(points);
    Date endTimeNaive = new Date();
    long elapsedTime = endTimeNaive.getTime() - startTimeNaive.getTime();
    closestPair.elapsedTime = elapsedTime;

    return closestPair;
  }

  private static Pair findClosestPairHelper(XYPoint points[]) {
    Pair closest = new Pair(null, null);
    int j = 0;
    while (j <= points.length - 2) {
      int k = j + 1;
      while (k <= points.length - 1) {
        Pair tempPair = new Pair(points[j], points[k]);
        closest = closest.returnMin(tempPair);
        k++;
      }
      j++;
    }
    return closest;
  }
}
