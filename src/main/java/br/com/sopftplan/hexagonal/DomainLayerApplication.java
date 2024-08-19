package br.com.sopftplan.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:ddd-layers.properties" })
public class DomainLayerApplication {

	public static void main(final String[] args) {
		SpringApplication application = new SpringApplication(DomainLayerApplication.class);
		application.run(args);
	}
	
}