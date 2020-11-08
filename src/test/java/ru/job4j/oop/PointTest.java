package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanse3d() {
      Point a = new Point(5, 4, 6);
      Point b = new Point(3, 0, 2);
      double v = a.distanse3d(b);
      assertThat(v, closeTo(6, 0.001));
    }

    @Test
    public void distanse() {
        Point a = new Point(5, 4);
        Point b = new Point(3, 0);
        double v = a.distanse3d(b);
        assertThat(v, closeTo(4.472, 0.001));
    }
}