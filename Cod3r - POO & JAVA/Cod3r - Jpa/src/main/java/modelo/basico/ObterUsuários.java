package modelo.basico;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuários {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Cod3r - JPA");
		
		List<Usuario> usuarios = entityManagerFactory.createEntityManager().
				createQuery("select u from Usuario u", Usuario.class).
				setMaxResults(5).
				getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println("ID: " + usuario.getId() + "\nE-Mail: " + usuario.getEmail() + "\nNome: " + usuario.getNome());
		}
		entityManagerFactory.close();
	}
}
