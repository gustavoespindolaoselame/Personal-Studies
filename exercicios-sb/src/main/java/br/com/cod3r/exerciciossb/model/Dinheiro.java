package br.com.cod3r.exerciciossb.model;

public class Dinheiro {
	private Double reais;
	private Double dolares;
	private Double bitcoin;
	
	public Dinheiro(Double reais, Double dolares, Double bitcoin) {
		super();
		this.reais = reais;
		this.dolares = dolares;
		this.bitcoin = bitcoin;
	}
	public Double getReais() {
		return reais;
	}
	public void setReais(Double reais) {
		this.reais = reais;
	}
	public Double getDolares() {
		return dolares;
	}
	public void setDolares(Double dolares) {
		this.dolares = dolares;
	}
	public Double getBitcoin() {
		return bitcoin;
	}
	public void setBitcoin(Double bitcoin) {
		this.bitcoin = bitcoin;
	}
	
	
}
