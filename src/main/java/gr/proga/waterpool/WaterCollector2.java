package gr.proga.waterpool;

import java.util.List;

public class WaterCollector2 {

    public static int handle(List<Integer> hills) {

        int collector = 0;
        int potential = 0;
        int previousHill = 0;
        int peak = 0;
        for (Integer hill : hills) {
            if (hill >= peak) {
                peak = hill;
                collector += potential;
                potential = 0;
            }
            else if (hill <= previousHill) {
                potential += peak - hill;
            }
            else{
                collector += hill - previousHill;
                potential += (peak - hill) - (hill - previousHill);
            }
            previousHill = hill;
        }
        return collector;
    }
}
