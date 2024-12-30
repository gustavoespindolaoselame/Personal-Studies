package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class novoPedido {
	public static void main(String[] args) {
		DAO<Object> dao = new DAO<>();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Geladeira", 2789.99);
		ItemPedido itensPedidos = new ItemPedido(10, pedido, produto);
		
		dao.
		abrirTransacao().
		incluir(produto).
		incluir(pedido).
		incluir(itensPedidos).
		fecharTransacao().
		fechar();
		
	}
}
