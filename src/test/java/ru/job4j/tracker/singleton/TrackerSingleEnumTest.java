package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;
import static org.junit.Assert.*;

public class TrackerSingleEnumTest {

    @Test
    public void add() {
        Item item = new Item(1,"Name");
        Item rsl = TrackerSingleEnum.INSTANCE.add(item);
        Item extend = TrackerSingleEnum.INSTANCE.findById(item.getId());
        assertSame(extend, rsl);
    }
}