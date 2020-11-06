package in.conceptarchitect.helloweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.helloweb.bookmanagement.Book;

import in.conceptarchitect.helloweb.bookmanagement.BookManager;

public class BookListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Collection<Book> books=BookManager.getAll();
		
		//let jsp build the output
		//step 1: add books to our req
		req.setAttribute("books", books);
		

		//step 2:forward current request to jsp page
		req
			.getRequestDispatcher("/WEB-INF/views/booklist.jsp")
			.forward(req, resp);
		

		
		
		
	}
	

}
