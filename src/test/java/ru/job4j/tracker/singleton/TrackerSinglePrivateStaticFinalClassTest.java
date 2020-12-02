package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;
import static org.junit.Assert.*;

public class TrackerSinglePrivateStaticFinalClassTest {

    @Test
    public void add() {
        Item item = new Item(1,"Name");
        Item rsl = TrackerSinglePrivateStaticFinalClass.getInstance().add(item);
        Item extend = TrackerSinglePrivateStaticFinalClass.getInstance().findById(item.getId());
        assertSame(extend, rsl);
    }
}