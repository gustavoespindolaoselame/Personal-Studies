package alura.desafio.literalura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alura.desafio.literalura.po.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
