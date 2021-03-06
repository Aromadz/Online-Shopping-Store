package cs544.project.onlineshoppingstore.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.service.BookService;
import cs544.project.onlineshoppingstore.utils.CheckInventory;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BookService bookService;
	@Autowired
	private CheckInventory checkInventory;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<Book> books = bookService.findFirst10ByOrderByPriceAsc();
		model.addAttribute("books", books);
		
		return "home";
	}
	
	@RequestMapping(value = "/home/search", method = RequestMethod.POST)
	public String search(String query, RedirectAttributes redirectAttrs){
	
		if( query == null || query.isEmpty())
			return "redirect:/home";
		
		return "redirect:/search?q=" + query;
	}
	
	
	
}
