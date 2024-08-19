package br.com.sopftplan.hexagonal.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sopftplan.hexagonal.domain.Planeta;
import jakarta.validation.constraints.NotNull;

public class CriarPlanetaRequest {

	@NotNull
	private Planeta planeta;

	@JsonCreator
	public CriarPlanetaRequest(@JsonProperty("planeta") @NotNull final Planeta planeta) {
		this.planeta = planeta;
	}

	public Planeta getPlaneta() {
		return this.planeta;
	}

}
