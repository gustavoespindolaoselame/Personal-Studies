package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class ObterFilmes {
	public static void main(String[] args) {
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar("filmesNotaMaiorQue", "nota", 8.5);
		System.out.println(filmes.size());
		for (Filme filme : filmes) {
			System.out.println(filme.getNome());
			for(Ator ator: filme.getAtores()) {
				System.out.println(ator.getName());
			}
		}
	}
}
