package gr.proga.waterpool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterCollectorImpl2 implements WaterCollector {

	@Override
	public int handle(List<Integer> hills) {
		Liquid liquid = new Liquid();
		Integer previousHill = 0;
		Integer peak = 0;
		int collector = 0;
		for (Integer hill : hills) {
			if (hill >= peak) {
				peak = hill;
				collector += liquid.collectAll();
			} else if (hill <= previousHill) {
				for (Integer i = hill + 1; i <= peak; i++) {
					liquid.increase(i);
				}
			} else {
				for (Integer i = previousHill + 1; i <= hill; i++) {
					collector += liquid.collect(i);
				}
				for (Integer i = hill + 1; i <= peak; i++) {
					liquid.increase(i);
				}
			}
			previousHill = hill;
		}
		return collector;
	}


	class Liquid {
		Map<Integer, Integer> streams = new HashMap<>();

		void increase(Integer i) {
			Integer stream = streams.get(i);
			if (stream == null) {
				streams.put(i, 1);
			} else {
				streams.put(i, ++stream);
			}
		}

		int collectAll() {
			int res = 0;
			for (Integer val : streams.values()) {
				res += val;
			}
			streams.clear();
			return res;
		}

		int collect(Integer i) {
			int res = streams.get(i);
			streams.remove(i);
			return res;
		}
	}

}
