package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.cod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepositoryPaRS extends PagingAndSortingRepository<Produto, Integer>{

}
