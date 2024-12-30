package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoAtorFilme {
	public static void main(String[] args) {
		Filme filmeA = new Filme("Star Wars Ep 2", 8.7);
		Filme filmeB = new Filme("O fugitivo", 8.9);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atorB = new Ator("Carrie Fisher");
		
		filmeA.addAtor(atorA);
		filmeA.addAtor(atorB);
		
		filmeB.addAtor(atorA);
		
		DAO<Filme> dao = new DAO<Filme>(Filme.class);
		dao.incluirAtomico(filmeA);
		dao.fechar();
	}
}
