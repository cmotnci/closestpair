package com.closestpair.util;

import com.closestpair.model.Pair;

public class PairUtil {

    public static String constructMessage(Pair pairDC, Pair pairNaive) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Divide and conquer strategy : ");
        stringBuilder.append(pairDC.one.line);
        stringBuilder.append(pairDC.one.x);
        stringBuilder.append("  ");
        stringBuilder.append(pairDC.one.y);
        stringBuilder.append(" | ");
        stringBuilder.append(pairDC.two.line);
        stringBuilder.append(pairDC.two.x);
        stringBuilder.append("  ");
        stringBuilder.append(pairDC.two.y);
        stringBuilder.append(" | ");
        stringBuilder.append("Elapsed time : ");
        stringBuilder.append(pairDC.elapsedTime);
        stringBuilder.append("|||");
        stringBuilder.append("Naive strategy : ");
        stringBuilder.append(pairNaive.one.line);
        stringBuilder.append(pairNaive.one.x);
        stringBuilder.append("  ");
        stringBuilder.append(pairNaive.one.y);
        stringBuilder.append(" | ");
        stringBuilder.append(pairNaive.two.line);
        stringBuilder.append(pairNaive.two.x);
        stringBuilder.append("  ");
        stringBuilder.append(pairNaive.two.y);
        stringBuilder.append(" | ");
        stringBuilder.append("Elapsed time : ");
        stringBuilder.append(pairNaive.elapsedTime);

        return stringBuilder.toString();
    }
}
