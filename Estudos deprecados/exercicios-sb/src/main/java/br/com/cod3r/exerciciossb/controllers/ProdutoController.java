package br.com.cod3r.exerciciossb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepository;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepositoryPaRS;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoRepositoryPaRS produtoRepositoryPaRS;
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoOuAtualizarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
    @GetMapping
    public Iterable<Produto> obterProdutos() {
    	return produtoRepository.findAll();
    }
	
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutoPorID(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	@GetMapping(path="/pagina/{numeroPagina}/{qtdePaginas}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePaginas){
		if(qtdePaginas>=5) qtdePaginas=5;
		Pageable page = PageRequest.of(numeroPagina, qtdePaginas);
		return produtoRepositoryPaRS.findAll(page);
	}
	
	@GetMapping(path="/nome/{parteNome}")
	public Iterable<Produto> obterProdutoPorNome(@PathVariable String parteNome) {
		return produtoRepository.searchByNameLike(parteNome);
	}
	
	@DeleteMapping(path="/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
}
