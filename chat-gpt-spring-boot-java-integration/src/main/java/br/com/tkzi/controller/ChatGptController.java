package br.com.tkzi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.service.ChatGptService;

@RestController
@RequestMapping("/bot")
public class ChatGptController {
	
	@Autowired
	private ChatGptService service;
	
	@GetMapping("/chat")
	public Object chat(@RequestParam ("prompt") String prompt) throws Exception {
		
		return service.chat(prompt);
	}

}
