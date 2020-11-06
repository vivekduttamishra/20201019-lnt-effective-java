package in.conceptarchitect.booksapi.booksmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //this object should be saved in a database
@Table(name="books")
public class Book {

	@Id //primary key
	String isbn;
	String title;
	String author;
	String description;
	String tags;
	int price;
	String cover;
	double rating;
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Book(String isbn, String title, String author, String description, String tags, int price, String cover,
			double rating) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.tags = tags;
		this.price = price;
		this.cover = cover;
		this.rating = rating;
	}
	public Book() {
		super();
	}
	
	
	

}
