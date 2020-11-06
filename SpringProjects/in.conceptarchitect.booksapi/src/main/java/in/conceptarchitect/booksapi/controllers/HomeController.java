package in.conceptarchitect.booksapi.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.conceptarchitect.booksapi.services.ServiceInfo;

@Controller
public class HomeController {

	@RequestMapping("/")	
	public String home(HashMap<String,Object> model) {
		
		List<ServiceInfo> services= Arrays.asList(
				new ServiceInfo("Book List", "GET /api/books"),
				new ServiceInfo("Book By Id", "GET /api/books/{id}"),
				new ServiceInfo("Books by Author", "/api/books/by/{authorName}")
				);
		
		model.put("services", services);
		//path of the jsp file
		return "/WEB-INF/views/home.jsp";
	}
	
	
	@RequestMapping("/welcome")
	@ResponseBody
	public String welcome() {
		
		return "Hello World, Welcome to Spring Boot";
	
	}
	
}
