package br.com.sopftplan.hexagonal.domain.service;

import java.util.List;
import java.util.UUID;

import br.com.sopftplan.hexagonal.domain.Planeta;
import br.com.sopftplan.hexagonal.domain.Sonda;

public interface PlanetaService {

	void criarPlaneta(String nome);

	void aterrissarSonda(UUID planetaId, Sonda sonda);

	void explodirSonda(UUID planetaId, UUID sondaId);

	Sonda moverSonda(UUID planetaId, UUID sondaId, String comandos);

	List<Planeta> listarPlanetas();
}
