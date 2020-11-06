package in.conceptarchitect.booksapi.services;

import java.util.List;

import in.conceptarchitect.booksapi.booksmodel.Book;

public interface BookService {

	void addBook(Book book);

	List<Book> getAllBooks();

	Book getBookByIsbn(String isbn);

	void removeBook(String isbn);

	void updateBook(Book book);

	List<Book> getBooksByAuthor(String authorName);

	List<Book> getBooksInPriceRange(int min, int max);

	List<Book> getBooksInRatingRange(int min, int max);

}