package in.conceptarchitect.utils;

import in.conceptarchitect.collections.Matcher;

public class EvenNumberMatcher implements Matcher<Integer> {

	@Override
	public boolean isMatch(Integer value) {
		// TODO Auto-generated method stub
		return value%2==0;
	}

}
