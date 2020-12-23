package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenRightLessThanLeftResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanova",
                "Ivanov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void whenLeftEmpty() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                "Ivanov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenNumber() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Pe435va",
                "Ivanov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void whenEmpty() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "",
                ""
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLongLength() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov Petr Semenovich",
                "Smirnov Oleg"
        );
        assertThat(rst, lessThan(0));
    }
}