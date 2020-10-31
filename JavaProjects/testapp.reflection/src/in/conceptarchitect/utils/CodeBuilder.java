package in.conceptarchitect.utils;


public class CodeBuilder {
	

	StringBuilder builder=new StringBuilder();
	String tabs="";
	
	public CodeBuilder append(String format, Object...args) {
		String str=String.format(format, args);
		builder.append(str);
		return this;
	}
	
	public CodeBuilder append(Object o) {
		builder.append(o.toString()+" ");
		return this;
	}
	
			
	public CodeBuilder indent() {
		tabs+='\t';
		return this;
	}
	
	public CodeBuilder unindent() {
		if(tabs!="" && tabs!=null)
			tabs=tabs.substring(1);
		return this;
	}
	
	public CodeBuilder nextLine() {
		builder.append("\n");
		builder.append(tabs);
		return this;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return builder.toString();
	}

}
