package gr.proga.waterpool;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaterCollectorTest {

    private WaterCollector wc1 = new WaterCollectorImpl1();
    private WaterCollector wc2 = new WaterCollectorImpl2();

    @Test(expected = IllegalArgumentException.class)
    public void handle_tooHigh_exception() {
        System.out.println(wc1.handle(Arrays.asList(5, 2, 3, 4, 5, 32001, 1, 3, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void handle_tooLow_exception() {
        System.out.println(wc1.handle(Arrays.asList(5, 2, 3, 4, 5, -1, 1, 3, 1)));
    }


    @Test
    public void handle_success() {
        handle_test(wc1);
        handle_test(wc2);


    }


    private void handle_test(WaterCollector waterCollector) {
        Assert.assertEquals(0, waterCollector.handle(Collections.emptyList()));
        Assert.assertEquals(0, waterCollector.handle(Arrays.asList(5, 2)));
        Assert.assertEquals(0, waterCollector.handle(Arrays.asList(0, 0, 0, 0)));
        Assert.assertEquals(8, waterCollector.handle(Arrays.asList(5, 2, 3, 4, 5, 4, 1, 3, 1)));
        Assert.assertEquals(0, waterCollector.handle(Arrays.asList(5, 5, 5, 5)));
        Assert.assertEquals(0, waterCollector.handle(Arrays.asList(1, 5, 8, 900, 99, 8, 6, 0)));
        Assert.assertEquals(2, waterCollector.handle(Arrays.asList(1, 0, 1, 0, 32000)));
        Assert.assertEquals(99, waterCollector.handle(Arrays.asList(100, 1, 100)));
        Assert.assertEquals(1, waterCollector.handle(Arrays.asList(100, 1, 2)));
        Assert.assertEquals(1, waterCollector.handle(Arrays.asList(3000, 3000, 2999, 3000, 3000)));
        Assert.assertEquals(0, waterCollector.handle(Arrays.asList(3000, 3000, 3000, 3000, 1)));
    }


}