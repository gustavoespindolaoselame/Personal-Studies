package teste.heranca;

import infra.DAO;
import modelo.heranca.Banana;
import modelo.heranca.Carro;
import modelo.heranca.Item;

public class ItemHeranca {
	public static void main(String[] args) {
		DAO<Item> itens = new DAO<>(Item.class);
		Item generico = new Item("Generico");
		Banana banana = new Banana("Caturra", "Banana");
		Carro carro = new Carro("Etios", "Carro");
		
		itens.abrirTransacao().incluir(generico).incluir(banana).incluir(carro).fecharTransacao().fechar();
	}
}
