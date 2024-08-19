package br.com.sopftplan.hexagonal.application.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sopftplan.hexagonal.domain.Sonda;
import jakarta.validation.constraints.NotNull;

public class MoverSondaReponse {

	@NotNull
	private Sonda sonda;

	@JsonCreator
	public MoverSondaReponse(@JsonProperty("sonda") @NotNull final Sonda sonda) {
		this.sonda = sonda;
	}

	public Sonda getSonda() {
		return this.sonda;
	}

}
