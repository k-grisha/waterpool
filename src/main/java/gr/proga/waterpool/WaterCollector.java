package gr.proga.waterpool;

import java.util.List;

public interface WaterCollector {
	Integer MAX_SIZE = 32000;

	int handle(List<Integer> hills);

	default void validate(List<Integer> hills) {
		if (hills.size() > MAX_SIZE) {
			throw new IllegalArgumentException();
		}
	}
}
