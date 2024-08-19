package br.com.sopftplan.hexagonal.application.request;

import jakarta.validation.constraints.NotNull;

public class MoverSondaRequest {

	@NotNull
	private Long sondaId;

	@NotNull
	private String comandos;

	public Long getSondaId() {
		return sondaId;
	}

	public String getComandos() {
		return comandos;
	}

}
