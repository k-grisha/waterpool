package gr.proga.waterpool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WaterCollector {
    private static final Integer MAX_SIZE = 32000;

    public static int handle(List<Integer> hills) {
        Integer maxHill = getMaxHillAndValid(hills);
        if (maxHill == 0) {
            return 0;
        }
        Integer collector = 0;

        for (int h = maxHill; h >= 0; h--) {
            List<Integer> hillsSection = new ArrayList<>();
            for (int i = 0; i < hills.size(); i++) {
                if (hills.get(i) >= h) {
                    hillsSection.add(i);
                }
            }

            for (int j = hillsSection.size() - 1; j > 0; j--) {
                collector += hillsSection.get(j) - hillsSection.get(j - 1) - 1;
            }
        }

        return collector;
    }

    private static Integer getMaxHillAndValid(List<Integer> hills) {
        if (hills.size() > MAX_SIZE) {
            throw new IllegalArgumentException();
        }
        if (hills.size() <= 2) {
            return 0;
        }
        Integer maxHill = hills.stream().max(Comparator.naturalOrder()).orElse(0);
        if (maxHill > MAX_SIZE) {
            throw new IllegalArgumentException();
        }
        return maxHill;
    }


}
