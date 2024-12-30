package modelo.umpramuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.basico.Produto;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Produto produto;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false, name = "preco")
	private Double precoTotal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ItemPedido() {
		super();
	}
	
	
	
	public ItemPedido(Integer quantidade, Pedido pedido, Produto produto) {
		super();
		this.setQuantidade(quantidade);
		this.setPedido(pedido);
		this.setProduto(produto);
		this.setPrecoTotal(produto.getPreco() * quantidade);
	}
}
