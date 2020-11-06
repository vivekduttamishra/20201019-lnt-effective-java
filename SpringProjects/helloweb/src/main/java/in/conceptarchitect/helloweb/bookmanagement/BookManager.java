package in.conceptarchitect.helloweb.bookmanagement;

import java.util.Collection;
import java.util.HashMap;

public class BookManager {

	static HashMap<Integer, Book> books=new HashMap<Integer,Book>();
	static int bookCount=0;
	
	public static int add(Book book) {
		book.setId(++bookCount);
		books.put(book.getId(), book);
		return book.getId();
	}
	
	public static Collection<Book> getAll(){
		if(books.size()==0)
			seed();
		return books.values();
	}
	
	public static Book getBookById(int id) {
		if(books.containsKey(id))
			return books.get(id);
		return null;
	}

	private static void seed() {
		// TODO Auto-generated method stub
		add(new Book(0, "The Accursed God", "Vivek Dutta Mishra", 299));
		add(new Book(0, "Freedom at Midnight", "Larry Collins", 300));
		add(new Book(0, "My Experiments with truth", "Mahatma Gandhi", 120));
	}
	
	
	
	
	

}
