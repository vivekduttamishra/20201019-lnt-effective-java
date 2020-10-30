package in.conceptarchitect.collections;

public class LinkedList {

	Node first;
	Node last;
	int count;
	
	public void add(String value) {
		Node newNode=new Node(value);
		
		if(size()==0) {
			first=newNode;
		} else {
			last.next=newNode;
			newNode.previous=last;
		}
		count++;
		last=newNode;
	}
	
	public String remove(int pos) {
		return null;
	}
	
	public String get(int pos) {
	
		return null;
	}
	
	public void set(int pos, String value) {
		
	}
	
	public int size() {
		return count;
	}
	
	@Override
	public String toString() {
		if(size()==0)
			return "LinkedList()";
		
		String str="LinkedList(\t";
		
		for(Node n=first;n!=null;n=n.next) {
			str+=n.value+"\t";
		}
		
		str+=")";
		
		return str;
	}
	
	
	
	
}
