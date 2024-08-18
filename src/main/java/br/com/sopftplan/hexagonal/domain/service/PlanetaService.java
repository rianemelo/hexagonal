package br.com.sopftplan.hexagonal.domain.service;

import br.com.sopftplan.hexagonal.domain.Sonda;

public interface PlanetaService {

	void criarPlaneta(Long id, String nome);

	void aterrissarSonda(Long planetaId, Sonda sonda);

	void explodirSonda(Long planetaId, Long sondaId);

	void moverSonda(Long planetaId, Long sondaId, String comandos);

}
