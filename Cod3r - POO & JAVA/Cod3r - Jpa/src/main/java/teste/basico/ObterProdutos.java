package teste.basico;

import java.util.List;

import modelo.basico.Produto;
import modelo.basico.ProdutoDAO;

public class ObterProdutos {
	public static void main(String[] args) {
		ProdutoDAO produtoDao = new ProdutoDAO();
		List<Produto> produtos = produtoDao.obterTodos(10, 0);
		
		for (Produto produto : produtos) {
			System.out.println("ID: " + produto.getId() + "\nNome: " + produto.getNome() + "\nPreco: " + produto.getPreco());
		}
		
		double precoTotal = produtos.
				stream().
				map(p -> p.getPreco()).
				reduce(0.0, (t,p) -> t+p).
				doubleValue();
		System.out.println("O valor total é:" + String.valueOf(precoTotal));
	}
}
