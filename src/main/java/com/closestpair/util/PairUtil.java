package com.closestpair.util;

import com.closestpair.model.Pair;
import com.closestpair.model.Point;

public class PairUtil {

    public static String constructMessage(Pair pairDC, Pair pairNaive) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Divide and conquer strategy : ");
        stringBuilder.append(pairDC.one.line);
        stringBuilder.append(":");
        stringBuilder.append(getCoordinatesAsString(pairDC.one.coordinates));
        stringBuilder.append(" | ");
        stringBuilder.append(pairDC.two.line);
        stringBuilder.append(":");
        stringBuilder.append(getCoordinatesAsString(pairDC.two.coordinates));
        stringBuilder.append("  ");
        stringBuilder.append("Elapsed time : ");
        stringBuilder.append(pairDC.elapsedTime);
        stringBuilder.append("----");
        stringBuilder.append("Naive strategy : ");
        stringBuilder.append(pairNaive.one.line);
        stringBuilder.append(":");
        stringBuilder.append(getCoordinatesAsString(pairNaive.one.coordinates));
        stringBuilder.append(" | ");
        stringBuilder.append(pairNaive.two.line);
        stringBuilder.append(":");
        stringBuilder.append(getCoordinatesAsString(pairNaive.two.coordinates));
        stringBuilder.append("  ");
        stringBuilder.append("Elapsed time : ");
        stringBuilder.append(pairNaive.elapsedTime);

        return stringBuilder.toString();
    }

    public static String constructMessage(Pair pairNaive) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Naive strategy : ");
        stringBuilder.append(pairNaive.one.line);
        stringBuilder.append(":");
        stringBuilder.append(getCoordinatesAsString(pairNaive.one.coordinates));
        stringBuilder.append(" | ");
        stringBuilder.append(pairNaive.two.line);
        stringBuilder.append(":");
        stringBuilder.append(getCoordinatesAsString(pairNaive.two.coordinates));
        stringBuilder.append("  ");
        stringBuilder.append("Elapsed time : ");
        stringBuilder.append(pairNaive.elapsedTime);

        return stringBuilder.toString();
    }

    private static String getCoordinatesAsString(double[] coordinates) {
        String coordinatesStr = "";

        for (double coordinate : coordinates) {
            coordinatesStr += String.valueOf(coordinate) + " ";
        }

        return coordinatesStr;
    }

    public static boolean greaterThanTwoDimensions(Point point) {
        return point.dimensions > 2;
    }
}
