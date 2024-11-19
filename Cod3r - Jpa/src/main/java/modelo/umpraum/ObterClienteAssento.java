package modelo.umpraum;

import infra.DAO;

public class ObterClienteAssento {
	public static void main(String[] args) {
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		
		Cliente cliente = dao.obterPorID(1L);
		System.out.println("assento: " + cliente.getAssento().getId() + " - " + cliente.getAssento().getNome() + 
				"\ncliente: " + cliente.getAssento().getCliente().getId() + " - " + cliente.getAssento().getCliente().getAssento().getCliente().getNome());
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		Assento assento = daoAssento.obterPorID(4L);
		System.out.println("Cliente: " + assento.getCliente().getNome());
		dao.fechar();
	}
}
