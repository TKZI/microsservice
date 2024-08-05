package br.com.tkzi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Book Service Api", version = "v1", description = "Documentation of Cambio Service Api"))
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI customApi() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
						.title("Cambio Service API")
						.version("v1")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")));
	}

}
