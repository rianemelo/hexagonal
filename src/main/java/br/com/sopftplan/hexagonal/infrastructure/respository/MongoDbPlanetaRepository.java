package br.com.sopftplan.hexagonal.infrastructure.respository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.sopftplan.hexagonal.domain.Planeta;
import br.com.sopftplan.hexagonal.domain.repository.PlanetaRepository;

@Component
@Primary
public class MongoDbPlanetaRepository implements PlanetaRepository {

	private final SpringDataMongoPlanetaRepository planetaRepository;

	@Autowired
	public MongoDbPlanetaRepository(final SpringDataMongoPlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}

	@Override
	public Optional<Planeta> findById(UUID id) {
		return planetaRepository.findById(id);
	}

	@Override
	public List<Planeta> findAll() {
		return planetaRepository.findAll();
	}

	@Override
	public void save(Planeta planeta) {
		planetaRepository.save(planeta);
	}

}
