package br.com.sopftplan.hexagonal.domain.service;

import java.util.UUID;

import br.com.sopftplan.hexagonal.domain.Planeta;
import br.com.sopftplan.hexagonal.domain.Sonda;
import br.com.sopftplan.hexagonal.domain.repository.PlanetaRepository;

public class PlanetaDomainService implements PlanetaService {

	private final PlanetaRepository planetaRepository;

	public PlanetaDomainService(final PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}

	@Override
	public void criarPlaneta(String nome) {
		Planeta planeta = new Planeta(UUID.randomUUID(), nome);

		planetaRepository.save(planeta);
	}

	@Override
	public void aterrissarSonda(UUID planetaId, Sonda sonda) {
		Planeta planeta = getPlaneta(planetaId);

		planeta.aterrissarSonda(sonda);
		planetaRepository.save(planeta);
	}

	@Override
	public void explodirSonda(UUID planetaId, UUID sondaId) {
		Planeta planeta = getPlaneta(planetaId);

		planeta.explodirSonda(sondaId);
		planetaRepository.save(planeta);
	}

	@Override
	public void moverSonda(UUID planetaId, UUID sondaId, String comandos) {
		Planeta planeta = getPlaneta(planetaId);

		planeta.moverSonda(sondaId, comandos);
		planetaRepository.save(planeta);
	}

	private Planeta getPlaneta(UUID id) {
		return planetaRepository.findById(id).orElseThrow(() -> new RuntimeException("Planeta nao encontrado!"));
	}

}
