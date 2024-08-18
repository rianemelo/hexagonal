package br.com.sopftplan.hexagonal.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Planeta {

	private Long id;
	private String nome;
	private List<Sonda> sondas;

	public Planeta(final Long id, String nome) {
		this.id = id;
		this.nome = nome;
		this.sondas = new ArrayList<>();
	}

	public void aterrissarSonda(final Sonda sonda) {
		validarPosicao(sonda);
		sondas.add(sonda);
	}

	public void explodirSonda(final Long id) {
		final Sonda sonda = getSonda(id).get();
		sondas.remove(sonda);
	}

	public void moverSonda(final Long id, String comandos) {
		Sonda sonda = getSonda(id).get();
		
		String[] lista = comandos.toUpperCase().split("");

		for (int i = 0; i < lista.length; i++) {
			sonda.moverComando(lista[i]);
		}
		
		validarPosicao(sonda);
	}
	
	public void validarPosicao(Sonda sonda) {
		Optional<Sonda> sondaEncontrada = sondas
				.stream()
				.filter(item -> item.getPosicaoX().equals(sonda.getPosicaoX())
						&& item.getPosicaoY().equals(sonda.getPosicaoY()))
				.findFirst();
		
		if (!sondaEncontrada.equals(null)) {
			throw new DomainException("Posicao ocupada!");
		}
	}
	
	private Optional<Sonda> getSonda(final Long id) {
		return sondas.stream().filter(sonda -> sonda.getId().equals(id)).findFirst();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Sonda> getSondas() {
		return Collections.unmodifiableList(sondas);
	}

}
