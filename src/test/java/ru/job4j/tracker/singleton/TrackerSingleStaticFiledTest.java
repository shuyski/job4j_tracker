package ru.job4j.tracker.singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;
import static org.junit.Assert.*;

public class TrackerSingleStaticFiledTest {

    @Test
    public void add() {
        Item item = new Item(1,"Name");
        Item rsl = TrackerSingleStaticFiled.getInstance().add(item);
        assertSame(item, rsl);
    }

}