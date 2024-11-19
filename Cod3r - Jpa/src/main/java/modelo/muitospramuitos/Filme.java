package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Double nota;
	
	private String nome;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "atores_filmes",
			joinColumns = @JoinColumn(name="filme_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="ator_id", referencedColumnName = "id")
			)
	private List<Ator> atores = new ArrayList<>();
	
	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}
	
	public void addAtor(Ator ator){
		if(ator == null) {
			throw new RuntimeException("ator não definido em método");
		}
		if(getAtores().contains(ator)) {
			throw new RuntimeException("este filme já contém este ator");
		}
		if(ator.getFilmes().contains(this)) {
			throw new RuntimeException("ator já faz parte deste filme");
		}
		getAtores().add(ator);
		ator.getFilmes().add(this);
	}
	
	public void removerAtor(Ator ator){
		if(ator == null) {
			throw new RuntimeException("ator não definido em método");
		}
		if(!getAtores().contains(ator)) {
			throw new RuntimeException("este filme não contém este ator");
		}
		if(!ator.getFilmes().contains(this)) {
			throw new RuntimeException("ator já não faz parte deste filme");
		}
		getAtores().remove(ator);
		ator.getFilmes().remove(this);
	}

	public Filme(String nome, Double nota) {
		super();
		this.nota = nota;
		this.nome = nome;
	}

	public Filme() {
		super();
	}
}
