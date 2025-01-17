package alura.desafio.literalura.po;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import alura.desafio.literalura.dto.AutorDTO;
import alura.desafio.literalura.dto.LivroDTO;

@Service
public class Mapper {
	public static Autor AutorDTOtoAutor(AutorDTO autorDto) {
		return new Autor(autorDto.nome(),autorDto.anoNasc(),autorDto.anoMort());
	}
	
	public static Livro LivroDTOtoLivro(LivroDTO livroDto) {
		List<Autor> returnList = new ArrayList<Autor>();
		livroDto.authors().forEach(a -> returnList.add(AutorDTOtoAutor(a)));
		return new Livro(
				livroDto.title(), 
				returnList, 
				livroDto.languages(), 
				livroDto.download_count()
				);
	}
}
