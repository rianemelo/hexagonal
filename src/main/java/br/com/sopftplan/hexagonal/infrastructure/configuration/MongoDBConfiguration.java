package br.com.sopftplan.hexagonal.infrastructure.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.sopftplan.hexagonal.infrastructure.respository.SpringDataMongoPlanetaRepository;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoPlanetaRepository.class)
public class MongoDBConfiguration {
}
