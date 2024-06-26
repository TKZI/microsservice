package br.com.tkzi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.model.Book;
import br.com.tkzi.proxy.CambioProxy;
import br.com.tkzi.repository.BookRepository;

@RestController
@RequestMapping("/book-service")
public class BookController {

	@Autowired
	private Environment environment;

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CambioProxy cambioProxy;

	@GetMapping("/{bookId}/{currency}")
	public Book findBook(@PathVariable Long bookId, @PathVariable String currency) {
		Book book = bookRepository.findById(bookId).get();

		if (book == null) {
			throw new RuntimeException("Book not found");
		}
		
		var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = environment.getProperty("local.server.port");

		book.setEnvironment(port);
		book.setPrice(cambio.getConvertedValue());
		return book;

	}
	
	
	
	
	
	
	
/*
 * @GetMapping("/{bookId}/{currency}") public Book findBook(@PathVariable Long
 * bookId, @PathVariable String currency) { Book book =
 * bookRepository.findById(bookId).get();
 * 
 * if (book == null) { throw new RuntimeException("Book not found"); }
 * 
 * HashMap<String, String> params = new HashMap<>(); params.put("amount",
 * book.getPrice().toString()); params.put("from", "USD"); params.put("to",
 * currency);
 * 
 * var response = new RestTemplate().getForEntity(
 * "http://localhost:8000/cambio-service/{amount}/{from}/{to}", Cambio.class,
 * params );
 * 
 * var cambio = response.getBody();
 * 
 * var port = environment.getProperty("local.server.port");
 * 
 * book.setEnvironment(port); book.setPrice(cambio.getConvertedValue()); return
 * book;
 * 
 * }
 */
}
