package br.com.sopftplan.hexagonal.application.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class MoverSondaRequest {

	@NotNull
	private UUID planetaId;
	
	@NotNull
	private UUID sondaId;
	
	@NotNull
	private String comandos;

	public UUID getPlanetaId() {
		return planetaId;
	}

	public UUID getSondaId() {
		return sondaId;
	}

	public String getComandos() {
		return comandos;
	}

}
