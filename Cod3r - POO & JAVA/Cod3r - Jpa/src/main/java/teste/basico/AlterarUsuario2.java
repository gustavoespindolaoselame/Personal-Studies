package teste.basico;
import modelo.basico.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Cod3r - JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		// Objeto gerenciado
		Usuario usuario = entityManager.find(Usuario.class, 3L);
		usuario.setNome("Eduardo");
		usuario.setEmail("eduardo@lanche.com.br");
		// entityManager.merge(usuario);
		System.out.println(usuario.getEmail());
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
