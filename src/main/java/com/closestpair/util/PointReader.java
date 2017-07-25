package com.closestpair.util;

import com.closestpair.model.Point;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class PointReader {

    public static Point[] constructPoints(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        HashMap<Integer, double[]> coordinatesMap = new HashMap<>();

        AtomicInteger index = new AtomicInteger(1);
        bufferedReader.lines().map(line -> Stream.of(line.split("\t")))
                .map(s -> s.mapToDouble(Double::valueOf))
                .map(s -> s.toArray())
                .forEachOrdered(s -> coordinatesMap.put(index.getAndIncrement(), s));

        Point[] points = new Point[coordinatesMap.size()];
        for (int i = 0; i < coordinatesMap.size(); i++) {
            double[] coords = coordinatesMap.get(i + 1);
            setScale(coords);
            points[i] = new Point(i + 1, coords);
        }

        return points;
    }

    private static void setScale(double[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            BigDecimal bigDecimal = new BigDecimal(coordinates[i]).setScale(0, BigDecimal.ROUND_HALF_UP);
            coordinates[i] = bigDecimal.doubleValue();
        }
    }
}
