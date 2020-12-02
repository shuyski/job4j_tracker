package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackerSingleStaticFiledTest {

    @Test
    public void Single() {
        TrackerSingleStaticFiled first = TrackerSingleStaticFiled.getInstance();
        TrackerSingleStaticFiled second = TrackerSingleStaticFiled.getInstance();
        assertSame(first, second);
    }

}