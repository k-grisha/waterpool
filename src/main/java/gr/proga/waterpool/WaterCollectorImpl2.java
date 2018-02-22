package gr.proga.waterpool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterCollectorImpl2 implements WaterCollector {

    @Override
    public int handle(List<Integer> hills) {
        Streams streams = new Streams();
        Integer previousHill = 0;
        Integer peak = 0;
        int collector = 0;
        for (Integer hill : hills) {
            if (hill >= peak) {
                peak = hill;
                collector += streams.collectAll();
            }else if (hill <= previousHill) {
                for (Integer i = hill + 1; i <= peak; i++) {
                    streams.increase(i);
                }
            }
            else {
                for (Integer i = previousHill + 1; i <= hill; i++) {
                    collector += streams.collect(i);
                }
                for (Integer i = hill + 1; i <= peak; i++) {
                    streams.increase(i);
                }
            }
            previousHill = hill;
        }
        return collector;
    }


    class Streams {
        Map<Integer, Integer> streams = new HashMap<>();

        public void increase(Integer i) {
            Integer stream = streams.get(i);
            if (stream == null) {
                streams.put(i, 1);
            } else {
                streams.put(i, ++stream);
            }
        }

        public int collectAll() {
            int res = 0;
            for (Integer val : streams.values()) {
                res += val;
            }
            streams.clear();
            return res;
        }

        public int collect(Integer i) {
            int res = streams.get(i);
            streams.remove(i);
            return res;
        }
    }

}
