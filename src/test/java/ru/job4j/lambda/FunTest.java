package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Fun.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        System.out.println(result);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        List<Double> result = Fun.diapason(2, 5, x -> 4 * Math.pow(x, 2) + x + 8);
        List<Double> expected = Arrays.asList(26D, 47D, 76D);
        System.out.println(result);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndexFunctionThenLinearResults() {
        List<Double> result = Fun.diapason(2, 5, x -> 4 * Math.pow(2, x) + 8);
        List<Double> expected = Arrays.asList(24D, 40D, 72D);
        System.out.println(result);
        assertThat(result, is(expected));
    }
}