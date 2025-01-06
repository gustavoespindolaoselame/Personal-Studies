package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
//	findByNomeContaining
//	findByNomeIsContaining
//	findByNomeContains
//	
//	findBynomeStartsWith
//	findByNomeEndsWith
//	
//	findByNomeNotContaing
//	
//	findByNomeContainingIgnoreCase
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
}
