package com.closestpair.model;

public class Pair {

  public XYPoint one;
  public XYPoint two;
  public long elapsedTime;

  public Pair(XYPoint newone, XYPoint newtwo) {
    one = newone;
    two = newtwo;
    elapsedTime = 0L;
  }

  public double getDist() {
    if (one == null || two == null) {
      return java.lang.Double.POSITIVE_INFINITY;
    }

    return one.dist(two);
  }

  public Pair returnMin(Pair other) {
    if (this.getDist() < other.getDist()) {
      return this;
    } else {
      return other;
    }
  }
}
