package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void maxFour() {
        int rsl = Max.max(1, 4, 3, 2);
        assertThat(rsl, is(4));
    }

    @Test
    public void maxThree() {
        int rsl = Max.max(30, 20, 10);
        assertThat(rsl, is(30));
    }

}