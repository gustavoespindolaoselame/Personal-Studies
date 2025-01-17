package alura.desafio.literalura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alura.desafio.literalura.po.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}