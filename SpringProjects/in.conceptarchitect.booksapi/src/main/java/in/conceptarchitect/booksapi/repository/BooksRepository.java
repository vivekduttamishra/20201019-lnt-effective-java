package in.conceptarchitect.booksapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.conceptarchitect.booksapi.booksmodel.Book;


@Repository
public interface BooksRepository extends JpaRepository<Book, String>{

	//Spring by looking at this name automatically create the implmentation
	//to find all books whos author name contains this String
	List<Book> findByAuthorContainingIgnoreCase(String authorNamePart);

	List<Book> findByPriceBetween(int min, int max);

	List<Book> findByRatingBetween(int min, int max);
	
	//will fail as there is no Age property
	//List<Book> findByAgeGreaterThan(int age);
	
	
	
	

}
