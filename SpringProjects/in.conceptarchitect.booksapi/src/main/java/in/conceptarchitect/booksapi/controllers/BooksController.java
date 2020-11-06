package in.conceptarchitect.booksapi.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.conceptarchitect.booksapi.booksmodel.Book;
import in.conceptarchitect.booksapi.services.BookService;

@RestController()
//@RequestMapping("/api/books/")
public class BooksController {

	@Autowired BookService service;
	
	
	@GetMapping("/api/books")
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@GetMapping("/api/books/{isbn}")
	public Book getBookById(@PathVariable("isbn") String isbn) {
		return service.getBookByIsbn(isbn);
	}
	
	@GetMapping("/api/books/by/{author}")
	public List<Book> getBooksByAuthor(@PathVariable("author") String author){
		return service.getBooksByAuthor(author);
	}
	
	@GetMapping("/api/books/price/between/{min}/and/{max}")
	public List<Book> getBooksByPrice(@PathVariable("min") int min, @PathVariable("max") int max){
		return service.getBooksInPriceRange(min, max);
	}
	
	@PostMapping(value="/api/books", consumes = "application/json")
	public Book addBook(@RequestBody Book book) {
		
		service.addBook(book);		
		return book;
	}
	
	

}
