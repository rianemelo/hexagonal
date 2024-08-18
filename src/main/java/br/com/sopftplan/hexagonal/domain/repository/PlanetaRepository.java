package br.com.sopftplan.hexagonal.domain.repository;

import java.util.Optional;
import java.util.UUID;

import br.com.sopftplan.hexagonal.domain.Planeta;

public interface PlanetaRepository {

	Optional<Planeta> findById(UUID id);

	void save(Planeta planeta);

}
