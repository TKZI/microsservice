package br.com.tkzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TkziConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkziConfigServerApplication.class, args);
	}

}
