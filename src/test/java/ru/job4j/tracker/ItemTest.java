package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void compareTo() {
        List<Item> item = Arrays.asList(
                new Item(21, "Ryslan"),
                new Item(78, "Ruslan"),
                new Item(12, "Rys")
        );
        List<Item> expected = Arrays.asList(
                new Item(12, "Rys"),
                new Item(21, "Ryslan"),
                new Item(78, "Ruslan")
        );
        Collections.sort(item);
        assertThat(item, is(expected));
    }

    @Test
    public void comparator() {
        List<Item> item = Arrays.asList(
                new Item(21, "Ryslan"),
                new Item(78, "Ruslan"),
                new Item(12, "Rys")
        );
        List<Item> expected = Arrays.asList(
                new Item(78, "Ruslan"),
                new Item(21, "Ryslan"),
                new Item(12, "Rys")
        );
        item.sort(new ItemSortById());
        assertThat(item, is(expected));
    }
}