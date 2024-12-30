package teste.basico;
import modelo.basico.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuário {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Cod3r - JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Usuario usuario = entityManager.find(Usuario.class, 2L);
		System.out.println(usuario.getNome());
		
		System.out.println("O Id gerado foi: " + usuario.getId());
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
