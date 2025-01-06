package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
public class Banana extends Item{

	private String especie;

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Banana(String especie, String nome) {
		super(nome);
		this.especie = especie;
	}

	public Banana() {
		super();
		// TODO Auto-generated constructor stub
	}
}
