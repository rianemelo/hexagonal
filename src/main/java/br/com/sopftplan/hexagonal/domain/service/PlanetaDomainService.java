package br.com.sopftplan.hexagonal.domain.service;

import java.util.List;

import br.com.sopftplan.hexagonal.domain.Planeta;
import br.com.sopftplan.hexagonal.domain.Sonda;
import br.com.sopftplan.hexagonal.domain.repository.PlanetaRepository;

public class PlanetaDomainService implements PlanetaService {

	private final PlanetaRepository planetaRepository;

	public PlanetaDomainService(final PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}

	@Override
	public void criarPlaneta(Long id, String nome) {
		Planeta planeta = new Planeta(id, nome);

		planetaRepository.save(planeta);
	}

	@Override
	public void aterrissarSonda(Long planetaId, Sonda sonda) {
		Planeta planeta = buscarPlaneta(planetaId);
		
		planeta.aterrissarSonda(sonda);
		planetaRepository.save(planeta);
	}

	@Override
	public void explodirSonda(Long planetaId, Long sondaId) {
		Planeta planeta = buscarPlaneta(planetaId);

		planeta.explodirSonda(sondaId);
		planetaRepository.save(planeta);
	}

	@Override
	public Sonda moverSonda(Long planetaId, Long sondaId, String comandos) {
		Planeta planeta = buscarPlaneta(planetaId);

		Sonda sonda = planeta.moverSonda(sondaId, comandos);
		planetaRepository.save(planeta);
		return sonda;
	}

	@Override
	public List<Planeta> listarPlanetas() {
		return planetaRepository.findAll();
	}

	private Planeta buscarPlaneta(Long id) {
		return planetaRepository.findById(id).orElseThrow(() -> new RuntimeException("Planeta nao encontrado!"));
	}

}
