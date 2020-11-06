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

public class HomePageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		PrintWriter writer=resp.getWriter();
		writer.println("Welcome to Books Web");
		writer.flush();
	}
	

}
