package gr.proga.waterpool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WaterCollector {

    public static int handle(int[] hills) {
        return handle(Arrays.stream(hills).boxed().collect(Collectors.toList()));
    }

    public static int handle(List<Integer> hills) {

        return hills.size();
    }
}
