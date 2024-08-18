package br.com.sopftplan.hexagonal.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.sopftplan.hexagonal.DomainLayerApplication;
import br.com.sopftplan.hexagonal.domain.repository.PlanetaRepository;
import br.com.sopftplan.hexagonal.domain.service.PlanetaDomainService;
import br.com.sopftplan.hexagonal.domain.service.PlanetaService;

@Configuration
@ComponentScan(basePackageClasses = DomainLayerApplication.class)
public class BeanConfiguration {

	@Bean
	PlanetaService planetaService(final PlanetaRepository planetaRepository) {
		return new PlanetaDomainService(planetaRepository);
	}

}
