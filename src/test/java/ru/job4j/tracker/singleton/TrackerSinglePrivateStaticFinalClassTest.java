package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackerSinglePrivateStaticFinalClassTest {

    @Test
    public void single() {
       TrackerSinglePrivateStaticFinalClass first =
               TrackerSinglePrivateStaticFinalClass.getInstance();
       TrackerSinglePrivateStaticFinalClass second =
               TrackerSinglePrivateStaticFinalClass.getInstance();
       assertSame(first, second);
    }
}