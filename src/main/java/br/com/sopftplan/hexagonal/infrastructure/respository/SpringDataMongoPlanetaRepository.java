package br.com.sopftplan.hexagonal.infrastructure.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sopftplan.hexagonal.domain.Planeta;

@Repository
public interface SpringDataMongoPlanetaRepository extends MongoRepository<Planeta, Long> {
}
