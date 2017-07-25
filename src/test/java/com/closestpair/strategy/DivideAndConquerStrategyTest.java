package com.closestpair.strategy;

import com.closestpair.model.Pair;
import com.closestpair.model.Point;
import com.closestpair.util.PointReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DivideAndConquerStrategyTest {

    @Test
    public void shouldReturnEmptyPairObjectIfArrayContainsOnePoint() {
        Point[] points = new Point[1];
        double[] coords = {23123, 2323};
        points[0] = new Point(1, coords);

        final Pair pair = DivideAndConquerStrategy.findClosestPair(points);

        assertThat("1st pair should be null", pair.one == null, equalTo(true));
        assertThat("2nd pair should be null", pair.two == null, equalTo(true));
    }

    @Test
    public void shouldFindClosestPair() throws Exception {
        Point[] points = constructDummy2dPoints();

        Pair pairDC = DivideAndConquerStrategy.findClosestPair(points);
        Pair pairNaive = NaiveStrategy.findClosestPair(points);

        boolean found = pairDC.one != null && pairDC.two != null & pairNaive.one != null & pairNaive.two != null;
        assertThat("Should find pair", found, equalTo(true));
    }

    @Test
    public void shouldFindOnePairIfThereIsAnotherPairWithSameDistance() {
        Point[] points = new Point[4];
        double[] coord0 = {-1, 1};
        double[] coord1 = {1, 1};
        double[] coord2 = {-1, -1};
        double[] coord3 = {1, -1};
        points[0] = new Point(1, coord0);
        points[1] = new Point(2, coord1);
        points[2] = new Point(3, coord2);
        points[3] = new Point(4, coord3);

        final Pair pair = DivideAndConquerStrategy.findClosestPair(points);
        assertThat("Not null", pair == null, equalTo(false));
    }

    @Test
    public void shouldFindExactPair() throws Exception {
        Point[] points = constructDummy2dPoints();

        Pair pairDC = DivideAndConquerStrategy.findClosestPair(points);
        Pair pairNaive = NaiveStrategy.findClosestPair(points);

        boolean correct = (pairDC.one.line == 6 || pairDC.one.line == 3) && (pairDC.two.line == 6 || pairDC.two.line == 3) &&
                (pairNaive.one.line == 6 || pairNaive.one.line == 3) && (pairNaive.two.line == 6 || pairNaive.two.line == 3);

        assertThat("Should find pair", correct, equalTo(true));
    }

    @Test
    public void shouldHaveSameResultBothStrategies() throws Exception {
        Point[] points = constructDummy2dPoints();

        Pair pairDC = DivideAndConquerStrategy.findClosestPair(points);
        Pair pairNaive = NaiveStrategy.findClosestPair(points);

        boolean sameResult = (pairDC.one.line == pairNaive.one.line && pairDC.two.line == pairNaive.two.line) || (pairDC.one.line == pairNaive.two.line && pairDC.two.line == pairNaive.one.line);

        assertThat("Should be same result", sameResult, equalTo(true));
    }

    private Point[] constructDummy2dPoints() throws IOException {
        final InputStream inputStream = this.getClass().getResourceAsStream("/sample/sample_input_2_8.tsv");
        return PointReader.constructPoints(inputStream);
    }
}