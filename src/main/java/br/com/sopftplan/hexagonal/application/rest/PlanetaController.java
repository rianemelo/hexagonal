package br.com.sopftplan.hexagonal.application.rest;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.sopftplan.hexagonal.application.request.AterrissarSondaRequest;
import br.com.sopftplan.hexagonal.application.request.CriarPlanetaRequest;
import br.com.sopftplan.hexagonal.application.request.MoverSondaRequest;
import br.com.sopftplan.hexagonal.application.response.ListarPlanetasResponse;
import br.com.sopftplan.hexagonal.application.response.MoverSondaReponse;
import br.com.sopftplan.hexagonal.domain.service.PlanetaService;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

	private final PlanetaService planetaService;

	@Autowired
	public PlanetaController(PlanetaService planetaService) {
		this.planetaService = planetaService;
	}

	@PostMapping
	ResponseEntity<?> criarPlaneta(@RequestBody final CriarPlanetaRequest request) {
		try {
			planetaService.criarPlaneta(request.getPlaneta().getId(), request.getPlaneta().getNome());
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/{planetaId}/sondas")
	ResponseEntity<?> aterrissarSonda(@PathVariable Long planetaId, @RequestBody final AterrissarSondaRequest request) {
		try {
			planetaService.aterrissarSonda(planetaId, request.getSonda());
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{planetaId}/sondas/{sondaId}")
	ResponseEntity<?> explodirSonda(@PathVariable Long planetaId, @PathVariable Long sondaId) {
		try {
			planetaService.explodirSonda(planetaId, sondaId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{planetaId}/sondas")
	ResponseEntity<?> moverSonda(@PathVariable Long planetaId, @RequestBody final MoverSondaRequest request) {
		try {
			MoverSondaReponse response = new MoverSondaReponse(
					planetaService.moverSonda(planetaId, request.getSondaId(), request.getComandos()));
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	ListarPlanetasResponse listarPlanetas() {
		ListarPlanetasResponse response = new ListarPlanetasResponse(planetaService.listarPlanetas());
		return response;
	}

}
