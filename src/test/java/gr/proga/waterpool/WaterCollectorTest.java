package gr.proga.waterpool;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static gr.proga.waterpool.WaterCollector.MAX_SIZE;
import static gr.proga.waterpool.WaterCollector.handle;

public class WaterCollectorTest {


    @Test
    public void handle_success() {
        Assert.assertEquals(8, handle(Arrays.asList(5, 2, 3, 4, 5, 4, 1, 3, 1)));
        Assert.assertEquals(0, handle(Arrays.asList(5, 5, 5, 5)));
        Assert.assertEquals(0, handle(Arrays.asList(1, 5, 8, 900, 99, 8, 6, 0)));
        Assert.assertEquals(2, handle(Arrays.asList(1, 0, 1, 0, 32000)));
        Assert.assertEquals(99, handle(Arrays.asList(100, 1, 100)));
        Assert.assertEquals(1, handle(Arrays.asList(3000, 3000, 2999, 3000, 3000)));
        Assert.assertEquals(0, handle(Arrays.asList(3000, 3000, 3000, 3000, 1)));
        Assert.assertEquals(0, handle(Collections.emptyList()));
        Assert.assertEquals(0, handle(Arrays.asList(5, 2)));
        Assert.assertEquals(0, handle(Arrays.asList(0, 0, 0, 0)));
    }


    @Test
    public void performance_test() {
        Random rnd = new Random();
        List<Integer> hills = new ArrayList<>(MAX_SIZE);
        for (int i = 0; i < 10; i++) {
            hills.add(rnd.nextInt(100));
        }

        Stopwatch stopwatch1 = Stopwatch.createStarted();
        int res1 = handle(hills);
        stopwatch1.stop();

        System.out.println("res= " + res1 + " t1= " + stopwatch1 );

    }

}