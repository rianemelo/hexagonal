package br.com.sopftplan.hexagonal.domain;

public class Sonda {

	private Long id;
	private Integer posicaoX;
	private Integer posicaoY;
	private Integer angulo;

	public void moverComando(String z) {
		switch (z) {
		case "L":
			angulo += 90;
			break;
		case "R":
			angulo -= 90;
			break;
		case "M":
			transladar();
			break;
		default:
			throw new DomainException("Comando nao reconhecido!");
		}
	}

	public void transladar() {
		Integer omega = angulo / 90;

		posicaoX += (int) Math.cos(Math.PI * omega / 2);
		posicaoY += (int) Math.sin(Math.PI * omega / 2);
	}

	public Long getId() {
		return id;
	}

	public Integer getPosicaoX() {
		return posicaoX;
	}

	public Integer getPosicaoY() {
		return posicaoY;
	}

	public Integer getAngulo() {
		return angulo;
	}

}
