package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackerSingleStaticFinalFieldTest {

    @Test
    public void single() {
        TrackerSingleStaticFinalField first = TrackerSingleStaticFinalField.getInstance();
        TrackerSingleStaticFinalField second = TrackerSingleStaticFinalField.getInstance();
        assertSame(first, second);
    }

}