package in.conceptarchitect.collections;

public class SurNameMatcher implements Matcher<String> {

	private String surName;

	public SurNameMatcher(String surName) {
		// TODO Auto-generated constructor stub
		this.surName=surName;
	}

	@Override
	public boolean isMatch(String name) {
		// TODO Auto-generated method stub
		
		return name.endsWith(surName);
	}

}
