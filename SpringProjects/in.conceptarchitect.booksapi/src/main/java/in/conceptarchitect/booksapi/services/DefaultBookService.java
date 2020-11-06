package in.conceptarchitect.booksapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.repository.BooksRepository;

@Service
public class DefaultBookService implements BookService {
	
	

	@Autowired BooksRepository books;
	
	@Override
	public void addBook(Book book) {
		books.save(book);
	}
	
	@Override
	public List<Book> getAllBooks(){
		return books.findAll();
	}
	
	@Override
	public Book getBookByIsbn(String isbn) {
		return books.findById(isbn).orElse(null);
	}

	@Override
	public void removeBook(String isbn) {
		books.deleteById(isbn);
	}
	
	@Override
	public void updateBook(Book book) {
		Book existing=getBookByIsbn(book.getIsbn());
		if(existing==null)
			return;
		
		existing.setTitle(book.getTitle());
		existing.setAuthor(book.getAuthor());
		existing.setDescription(book.getDescription());
		existing.setTags(book.getTags());
		existing.setCover(book.getCover());
		existing.setPrice(book.getPrice());
		existing.setRating(book.getRating());
		
		books.save(existing);
		
		
		
	}
	
	@Override
	public List<Book> getBooksByAuthor(String authorName){
		return books.findByAuthorContainingIgnoreCase(authorName);
	}
	
	@Override
	public List<Book> getBooksInPriceRange(int min,int max){
		return books.findByPriceBetween(min,max);
	}
	
	@Override
	public List<Book> getBooksInRatingRange(int min,int max){
		return books.findByRatingBetween(min,max);
	}
	
}
