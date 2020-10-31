package in.conceptarchitect.collections;



@FunctionalInterface
public interface Matcher<T> {

	boolean isMatch(T value);
	
	default boolean isMismatch(T value) {
		return !isMatch(value);
	}
	
}
