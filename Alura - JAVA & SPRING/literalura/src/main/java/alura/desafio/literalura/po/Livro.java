package alura.desafio.literalura.po;

import java.util.ArrayList;
import java.util.List;

import alura.desafio.literalura.dto.AutorDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title; 
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
		    name = "autor_livro",
		    joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
		    inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id")
		)
	private List<Autor> autores = new ArrayList<>();
	private List<String> languages; 
	private double download_count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Autor> getAuthors() {
		return autores;
	}
	public void setAuthors(List<Autor> authors) {
		this.autores = authors;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public double getDownload_count() {
		return download_count;
	}
	public void setDownload_count(double download_count) {
		this.download_count = download_count;
	}
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livro(String title, List<Autor> authors, List<String> languages, int download_count) {
		super();
		this.title = title;
		this.autores = authors;
		this.languages = languages;
		this.download_count = download_count;
	}
	@Override
	public String toString() {
		StringBuilder authorString = new StringBuilder();
		this.autores.forEach(a -> authorString.append(a.getNome()));
		StringBuilder languageString = new StringBuilder();
		this.languages.forEach(l -> languageString.append(l));
		return ("\n ----- LIVRO -----\nTítulo: " + this.title + "\nAutor: " + authorString.toString() + "\nIdioma: " + languageString.toString() + "\nNúmero de downloads: " + this.download_count + "\n--------------------");
	}
	
}
