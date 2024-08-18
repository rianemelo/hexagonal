package br.com.sopftplan.hexagonal.application.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sopftplan.hexagonal.application.request.MoverSondaRequest;
import br.com.sopftplan.hexagonal.domain.Planeta;
import br.com.sopftplan.hexagonal.domain.Sonda;
import br.com.sopftplan.hexagonal.domain.service.PlanetaService;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

	private final PlanetaService planetaService;

	@Autowired
	public PlanetaController(PlanetaService planetaService) {
		this.planetaService = planetaService;
	}

	@PostMapping()
	void criarPlaneta(@NotNull @RequestParam String nome) {
		planetaService.criarPlaneta(nome);
	}

	@PostMapping("/{planetaId}")
	void aterrissarSonda(@PathVariable UUID planetaId, @RequestBody final Sonda sonda) {
		planetaService.aterrissarSonda(planetaId, sonda);
	}

	@DeleteMapping("/{planetaId}/sondas/{sondaId}")
	void explodirSonda(@PathVariable UUID planetaId, @PathVariable UUID sondaId) {
		planetaService.explodirSonda(planetaId, sondaId);
	}

	@PutMapping()
	ResponseEntity<?> moverSonda(@RequestBody final MoverSondaRequest request) {
		try {
			Sonda sonda = planetaService.moverSonda(request.getPlanetaId(), request.getSondaId(),
					request.getComandos());
			return ResponseEntity.status(HttpStatus.OK).body(sonda);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping()
	List<Planeta> listarPlanetas(UUID id) {
		return planetaService.listarPlanetas();
	}

}
