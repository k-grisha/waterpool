package gr.proga.waterpool;

import java.util.ArrayList;
import java.util.List;

public class WaterCollectorImpl1 implements WaterCollector {

	@Override
	public int handle(List<Integer> hills) {
		validate(hills);
		Integer collector = 0;
		for (int h = 0; h <= MAX_SIZE; h++) {
			List<Integer> hillsSection = new ArrayList<>(hills.size());
			for (int i = 0; i < hills.size(); i++) {
				if (hills.get(i) >= h) {
					hillsSection.add(i);
				}
			}
			if (hillsSection.size() == 0) {
				break;
			}
			for (int j = hillsSection.size() - 1; j > 0; j--) {
				collector += hillsSection.get(j) - hillsSection.get(j - 1) - 1;
			}
		}
		return collector;
	}

}
