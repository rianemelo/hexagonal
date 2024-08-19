package br.com.sopftplan.hexagonal.application.request;

import jakarta.validation.constraints.NotNull;

public class CriarPlanetaRequest {

	@NotNull
	private Long id;

	@NotNull
	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
