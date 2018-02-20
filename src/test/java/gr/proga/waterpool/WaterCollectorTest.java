package gr.proga.waterpool;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static gr.proga.waterpool.WaterCollector.handle;

public class WaterCollectorTest {

    @Test(expected = IllegalArgumentException.class)
    public void handle_exception() {
        System.out.println(handle(Arrays.asList(5, 2, 3, 4, 5, 32001, 1, 3, 1)));
    }

    @Test
    public void handle_zero() {
        Assert.assertEquals(0, handle(Arrays.asList(5, 2)));
        Assert.assertEquals(0, handle(Arrays.asList(0, 0, 0, 0)));
    }

    @Test
    public void handle_success() {
        Assert.assertEquals(8, handle(Arrays.asList(5, 2, 3, 4, 5, 4, 1, 3, 1)));
        Assert.assertEquals(0, handle(Arrays.asList(1, 5, 8, 900, 99, 8, 6, 0)));
        System.out.println( handle(Arrays.asList(1, 0, 1, 0, 32000)));
    }

}