package gr.proga.waterpool;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

        Stopwatch stopwatch1 = Stopwatch.createStarted();
        handle_test(wc1);
        stopwatch1.stop();

        Stopwatch stopwatch2 = Stopwatch.createStarted();
        handle_test(wc2);
        stopwatch2.stop();

        System.out.println(" t1= " + stopwatch1 + " t2= " + stopwatch2);

    }

    private void handle_test(WaterCollector waterCollector) {
        for (int i = 0; i < 10000; i++) {
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

    @Test
    public void bugFix() {
        Assert.assertEquals(8, wc2.handle(Arrays.asList(6, 0, 2, 5)));
    }

    @Test
    public void performance_test() {
        Random rnd = new Random();
        List<Integer> hills = new ArrayList<>(32000);
        for (int i = 0; i < 7; i++) {
            hills.add(rnd.nextInt(10));
        }

        Stopwatch stopwatch1 = Stopwatch.createStarted();
        int res1 = wc1.handle(hills);
        stopwatch1.stop();

        Stopwatch stopwatch2 = Stopwatch.createStarted();
        int res2 = wc2.handle(hills);
        stopwatch2.stop();
        System.out.println(hills);
        Assert.assertEquals(res1, res2);

        System.out.println("res= " + res1 + " t1= " + stopwatch1 + " t2= " + stopwatch2);

    }
}