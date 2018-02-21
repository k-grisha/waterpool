package gr.proga.waterpool;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class WaterCollectorTest {

    @Test(expected = IllegalArgumentException.class)
    public void handle_tooHigh_exception() {
        System.out.println(WaterCollector1.handle(Arrays.asList(5, 2, 3, 4, 5, 32001, 1, 3, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void handle_tooLow_exception() {
        System.out.println(WaterCollector1.handle(Arrays.asList(5, 2, 3, 4, 5, -1, 1, 3, 1)));
    }

    @Test
    public void handle_zero() {
        Assert.assertEquals(0, WaterCollector1.handle(Collections.emptyList()));
        Assert.assertEquals(0, WaterCollector1.handle(Arrays.asList(5, 2)));
        Assert.assertEquals(0, WaterCollector1.handle(Arrays.asList(0, 0, 0, 0)));
    }

    @Test
    public void handle_success() {
        Assert.assertEquals(8, WaterCollector1.handle(Arrays.asList(5, 2, 3, 4, 5, 4, 1, 3, 1)));
        Assert.assertEquals(0, WaterCollector1.handle(Arrays.asList(5, 5, 5, 5)));
        Assert.assertEquals(0, WaterCollector1.handle(Arrays.asList(1, 5, 8, 900, 99, 8, 6, 0)));
        Assert.assertEquals(2, WaterCollector1.handle(Arrays.asList(1, 0, 1, 0, 32000)));
        Assert.assertEquals(99, WaterCollector1.handle(Arrays.asList(100, 1, 100)));
        Assert.assertEquals(1, WaterCollector1.handle(Arrays.asList(100, 1, 2)));
        Assert.assertEquals(1, WaterCollector1.handle(Arrays.asList(3000, 3000, 2999, 3000, 3000)));
        Assert.assertEquals(0, WaterCollector1.handle(Arrays.asList(3000, 3000, 3000, 3000, 1)));
    }

    @Test
    public void handle2_success() {
        Assert.assertEquals(8, WaterCollector2.handle(Arrays.asList(5, 2, 3, 4, 5, 4, 1, 3, 1)));
        Assert.assertEquals(0, WaterCollector2.handle(Arrays.asList(1, 5, 8, 900, 99, 8, 6, 0)));
        Assert.assertEquals(2, WaterCollector2.handle(Arrays.asList(1, 0, 1, 0, 32000)));
        Assert.assertEquals(99, WaterCollector2.handle(Arrays.asList(100, 1, 100)));
    }

}