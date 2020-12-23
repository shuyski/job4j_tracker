package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackerSingleEnumTest {

    @Test
    public void single() {
        TrackerSingleEnum first = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum second = TrackerSingleEnum.INSTANCE;
        assertSame(first, second);
    }
}