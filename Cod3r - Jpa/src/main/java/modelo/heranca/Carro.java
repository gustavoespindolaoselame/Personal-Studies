package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class Carro extends Item{
	
	private String modelo;

	public String getmodelo() {
		return modelo;
	}

	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}

	public Carro(String modelo, String nome) {
		super(nome);
		this.modelo = modelo;
	}

	public Carro() {
		super();
	}
	
}
