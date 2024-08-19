package br.com.sopftplan.hexagonal.application.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sopftplan.hexagonal.domain.Planeta;
import jakarta.validation.constraints.NotNull;

public class ListarPlanetasResponse {

	@NotNull
	private List<Planeta> planetas;

	@JsonCreator
	public ListarPlanetasResponse(@JsonProperty("planetas") @NotNull final List<Planeta> planetas) {
		this.planetas = planetas;
	}

	public List<Planeta> getPlanetas() {
		return this.planetas;
	}

}
