package com.closestpair.service;

import com.closestpair.model.Pair;
import com.closestpair.model.XYPoint;
import com.closestpair.strategy.DivideAndConquerStrategy;
import com.closestpair.strategy.NaiveStrategy;
import com.closestpair.util.PairUtil;
import com.closestpair.util.PointReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class DistanceService {

  public String findClosestPointsAndConstructMessage(MultipartFile multipartFile)
      throws IOException {

    XYPoint[] points = PointReader.constructPoints(multipartFile);
    Pair closestPairDivideAndConquer = DivideAndConquerStrategy.findClosestPair(points);
    Pair closestPairNaive = NaiveStrategy.findClosestPair(points);

    return PairUtil.constructMessage(closestPairDivideAndConquer, closestPairNaive);
  }
}
