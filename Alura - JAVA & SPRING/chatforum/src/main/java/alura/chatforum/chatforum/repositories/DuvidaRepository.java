package alura.chatforum.chatforum.repositories;

import alura.chatforum.chatforum.model.Duvida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuvidaRepository extends CrudRepository<Duvida, Long> {
}
