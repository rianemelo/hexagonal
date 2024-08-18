package br.com.sopftplan.hexagonal.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.sopftplan.hexagonal.domain.Planeta;

public interface PlanetaRepository {

	Optional<Planeta> findById(UUID id);

	List<Planeta> findAll();

	void save(Planeta planeta);

}
