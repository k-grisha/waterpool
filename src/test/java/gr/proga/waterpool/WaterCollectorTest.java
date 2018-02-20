package gr.proga.waterpool;

import org.junit.Test;

import static gr.proga.waterpool.WaterCollector.handle;

public class WaterCollectorTest {

    @Test
    public void handleTest() {
        System.out.println(handle(new int[]{1, 2, 3}));
    }


}