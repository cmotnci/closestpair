package com.closestpair.strategy;

import com.closestpair.model.Pair;
import com.closestpair.model.XYPoint;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DivideAndConquerStrategyTest {

    @Test
    public void shouldReturnEmptyPairObjectIfArrayContainsOnePoint() {
        XYPoint[] points = new XYPoint[1];
        points[0] = new XYPoint(123213, 3434);

        final Pair pair = DivideAndConquerStrategy.findClosestPair(points);

        assertThat("1st pair should be null", pair.one == null, equalTo(true));
        assertThat("2nd pair should be null", pair.two == null, equalTo(true));
    }

    @Test
    public void shouldFindClosestPair() throws Exception {
        XYPoint[] points = constructDummyPoints();

        Pair pairDC = DivideAndConquerStrategy.findClosestPair(points);
        Pair pairNaive = NaiveStrategy.findClosestPair(points);

        boolean found = pairDC.one != null && pairDC.two != null & pairNaive.one != null & pairNaive.two != null;
        assertThat("Should find pair", found, equalTo(true));
    }

    @Test
    public void shouldFindOnePairIfThereIsAnotherPairWithSameDistance() {
        XYPoint[] points = new XYPoint[4];
        points[0] = new XYPoint(-1, 1);
        points[1] = new XYPoint(1, 1);
        points[2] = new XYPoint(-1, -1);
        points[3] = new XYPoint(1, -1);

        final Pair pair = DivideAndConquerStrategy.findClosestPair(points);
        assertThat("Not null", pair == null, equalTo(false));
    }

    @Test
    public void shouldFindExactPair() throws Exception {
        XYPoint[] points = constructDummyPoints();

        Pair pairDC = DivideAndConquerStrategy.findClosestPair(points);
        Pair pairNaive = NaiveStrategy.findClosestPair(points);

        boolean correct = (pairDC.one.line == 6 || pairDC.one.line == 3) && (pairDC.two.line == 6 || pairDC.two.line == 3) &&
                (pairNaive.one.line == 6 || pairNaive.one.line == 3) && (pairNaive.two.line == 6 || pairNaive.two.line == 3);

        assertThat("Should find pair", correct, equalTo(true));
    }

    @Test
    public void shouldHaveSameResultBothStrategies() throws Exception {
        XYPoint[] points = constructDummyPoints();

        Pair pairDC = DivideAndConquerStrategy.findClosestPair(points);
        Pair pairNaive = NaiveStrategy.findClosestPair(points);

        boolean sameResult = (pairDC.one.line == pairNaive.one.line && pairDC.two.line == pairNaive.two.line) || (pairDC.one.line == pairNaive.two.line && pairDC.two.line == pairNaive.one.line);

        assertThat("Should be same result", sameResult, equalTo(true));
    }

    private XYPoint[] constructDummyPoints() {
        XYPoint[] points = new XYPoint[8];
        points[0] = new XYPoint(-262972, 508697);
        points[1] = new XYPoint(-311943.65362731507, 370239.3559213022);
        points[2] = new XYPoint(742431, -772652);
        points[3] = new XYPoint(-346046, 696615.3537438104);
        points[4] = new XYPoint(194172, 103527);
        points[5] = new XYPoint(726621.8167057682, -813087.8844925504);
        points[6] = new XYPoint(167923, -312455.0459619701);
        points[7] = new XYPoint(499664.42762545496, 72395.09685360803);

        return points;
    }
}