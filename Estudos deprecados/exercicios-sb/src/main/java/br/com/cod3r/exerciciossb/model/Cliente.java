package br.com.cod3r.exerciciossb.model;

public class Cliente {
	private int id;
	private String nome;
	private String cpf;
	private Dinheiro dinheiro;
	
	public Cliente(int id, String nome, String cpf, Double reais, Double dolares, Double bitcoin) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dinheiro = new Dinheiro(reais,dolares,bitcoin);
	}
	
	public Cliente(int id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dinheiro = new Dinheiro(0.0, 0.0, 0.0);
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Dinheiro getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(Dinheiro dinheiro) {
		this.dinheiro = dinheiro;
	}
	
}
