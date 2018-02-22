package gr.proga.waterpool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WaterCollectorImpl1 implements WaterCollector{
	private static final Integer MAX_SIZE = 32000;

	@Override
	public int handle(List<Integer> hills) {
		Integer maxHill = getMaxHillAndValid(hills);
		if (maxHill == 0) {
			return 0;
		}
		Integer minHill = getMinHillAndValid(hills);
		if (minHill.equals(maxHill)) {
			return 0;
		}

		Integer collector = 0;

		for (int h = maxHill; h >= minHill; h--) {
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

	private Integer getMaxHillAndValid(List<Integer> hills) {
		if (hills.size() > MAX_SIZE) {
			throw new IllegalArgumentException("Landscape too big. Max = " + MAX_SIZE);
		}
		if (hills.size() <= 2) {
			return 0;
		}
		Integer maxHill = hills.stream().max(Comparator.naturalOrder()).orElse(0);
		if (maxHill > MAX_SIZE) {
			throw new IllegalArgumentException("Hill too high. Max = " + MAX_SIZE);
		}

		return maxHill;
	}

	private Integer getMinHillAndValid(List<Integer> hills) {
		Integer minHill = hills.stream().min(Comparator.naturalOrder()).orElse(0);
		if (minHill < 0) {
			throw new IllegalArgumentException("Pits too low");
		}
		return minHill;
	}


}