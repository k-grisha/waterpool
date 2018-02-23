package gr.proga.waterpool;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public interface WaterCollector {
	Integer MAX_SIZE = 32000;

	int handle(List<Integer> hills);

	default void validate(List<Integer> hills) {
		if (hills.size() > MAX_SIZE) {
			throw new IllegalArgumentException();
		}
		IntSummaryStatistics stat = hills.stream().collect(Collectors.summarizingInt(Integer::intValue));
		if (stat.getMax() > MAX_SIZE || stat.getMin() < 0) {
			throw new IllegalArgumentException();
		}
	}
}
