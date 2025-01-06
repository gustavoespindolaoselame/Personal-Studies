package modelo.basico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Cod3r - JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Dudu", "dudu@lanche.com.br");
		
		entityManager.getTransaction().begin();
		entityManager.persist(novoUsuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Completed painlessly");
	}
}
