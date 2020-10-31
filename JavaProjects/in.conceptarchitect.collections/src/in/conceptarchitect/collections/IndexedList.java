package in.conceptarchitect.collections;



public interface IndexedList<Data> {

	IndexedList<Data> add(Data value);

	Data get(int pos);

	IndexedList<Data> set(int pos, Data value);

	int size();
	
	//useful default methods
	
	default boolean isEmpty() {
		return size()==0;
	}
	
	default IndexedList<Data> addMany(Data ...values) {
		for(Data value: values)
			add(value);
		
		return this;
	}

	
	default IndexedList<Data> fill(Data data){
		for(int i=0;i<size();i++)
			set(i,data);
		
		return this;
	}
	
	default IndexedList<Data> spread(int start, Data...values){
		for(Data value:values) {
			set(start++, value);
		}
		
		return this;
	}
	
	default boolean contains(Data value) {
		for(int i=0;i<size();i++) {
			if(get(i).equals(value))
				return true;
		}
		
		return false;
	}
	
	default boolean containsAll(Data... values) {
		for(Data value: values )
			if(!contains(value))
				return false;
		
		return true;
	}
	
	default boolean containsAny(Data... values) {
		for(Data value: values )
			if(contains(value))
				return true;
		
		return false;
	}
	
	
	default IndexedList<Data> search(Matcher<Data> matcher){
		LinkedList<Data> result=new LinkedList<>();
		for(int i=0;i<size();i++) {
			Data value= get(i);
			if(matcher.isMatch(value))
				result.add(value);
		}
		
		return result;
	}
	
	
	static <E> IndexedList<E> createList(E...values){
		
		return new LinkedList<E>().addMany(values);			
		
	}
	
	static <E> IndexedList<E> createArray(E...values){
		
		return new DynamicArray<E>(values.length).addMany(values);			
		
	}
	
	
	
	
	
	
	
	
}