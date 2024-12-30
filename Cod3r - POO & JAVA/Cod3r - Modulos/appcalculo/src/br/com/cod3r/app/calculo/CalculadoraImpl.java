package br.com.cod3r.app.calculo;

import br.com.cod3r.app.Calculadora;
import br.com.cod3r.app.calculo.interno.OperacoesAritmeticas;
import br.com.cod3r.app.loggging.Logger;

public class CalculadoraImpl implements Calculadora{
	
	private String id = "abc";
	
	private OperacoesAritmeticas operacoesAritmeticas = new OperacoesAritmeticas();
	public double soma(double... nums) {
		Logger.info("Somando...");
		return operacoesAritmeticas.soma(nums);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
}
