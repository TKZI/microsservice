package br.com.tkzi.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.configuration.GreetingConfiguration;
import br.com.tkzi.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private static final String template = "%s, %s";
	private AtomicLong count = new AtomicLong();
	
	@Autowired
	private GreetingConfiguration configuration;
	
	@GetMapping
	public Greeting greeting(@RequestParam(value = "nome",defaultValue = "") String nome) {
		
		if(nome.isEmpty()) {
			nome = configuration.getDefaultValue();
		}
		
		return new Greeting(count.incrementAndGet(), String.format(template,configuration.getGreeting(), nome));
		
	}

}
