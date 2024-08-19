package br.com.sopftplan.hexagonal.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.sopftplan.hexagonal.domain.Planeta;

public interface PlanetaRepository {

	Optional<Planeta> findById(Long id);

	List<Planeta> findAll();

	void save(Planeta planeta);

}
