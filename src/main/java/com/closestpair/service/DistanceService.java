package com.closestpair.service;

import com.closestpair.model.Pair;
import com.closestpair.model.Point;
import com.closestpair.strategy.DivideAndConquerStrategy;
import com.closestpair.strategy.NaiveStrategy;
import com.closestpair.util.PairUtil;
import com.closestpair.util.PointReader;

import java.io.IOException;
import java.io.InputStream;

public class DistanceService {

    public String findClosestPointsAndConstructMessage(InputStream inputStream)
            throws IOException {

        final Point[] points = PointReader.constructPoints(inputStream);
        final Point basePoint = points[0];

        if (PairUtil.greaterThanTwoDimensions(basePoint)) {
            Pair closestPairNaive = NaiveStrategy.findClosestPair(points);

            return PairUtil.constructMessage(closestPairNaive);
        }

        Pair closestPairDivideAndConquer = DivideAndConquerStrategy.findClosestPair(points);
        Pair closestPairNaive = NaiveStrategy.findClosestPair(points);

        return PairUtil.constructMessage(closestPairDivideAndConquer, closestPairNaive);
    }
}
