package alura.desafio.literalura.po;

import java.util.ArrayList;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int anoNasc;
	private int anoMort;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "autores")
	private List<Livro> livros = new ArrayList<>();

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoNasc() {
		return anoNasc;
	}
	public void setAnoNasc(int anoNasc) {
		this.anoNasc = anoNasc;
	}
	public int getAnoMort() {
		return anoMort;
	}
	public void setAnoMort(int anoMort) {
		this.anoMort = anoMort;
	}
	
	public Autor(String nome, int anoNasc, int anoMort) {
		super();
		this.nome = nome;
		this.anoNasc = anoNasc;
		this.anoMort = anoMort;
	}
	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder livrosList = new StringBuilder();
		this.livros.forEach(l -> livrosList.append(l.getTitle()));
		return "\nAutor: " + this.nome + "\nAno de nascimento: " + this.anoNasc + "\nAno de falecimento: " + this.anoMort + "\nLivros: " + livrosList.toString();
	}
	
	
}
