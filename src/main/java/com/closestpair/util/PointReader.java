package com.closestpair.util;

import com.closestpair.model.XYPoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.springframework.web.multipart.MultipartFile;

public class PointReader {

    public static XYPoint[] constructPoints(MultipartFile multipartFile) throws IOException {
        XYPoint[] points = new XYPoint[8]; //TODO : will refactor
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));

        AtomicInteger index = new AtomicInteger(0);
        bufferedReader.lines().map(line -> Stream.of(line.split("\t")))
            .map(s -> s.mapToDouble(Double::valueOf))
            .map(s -> s.toArray())
            .forEachOrdered(s -> points[index.getAndIncrement()] = new XYPoint(s[0], s[1]));

        return points;
    }
}
