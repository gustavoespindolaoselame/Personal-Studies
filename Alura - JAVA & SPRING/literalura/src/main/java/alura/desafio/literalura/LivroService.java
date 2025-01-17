package alura.desafio.literalura;

import com.fasterxml.jackson.databind.ObjectMapper;

import alura.desafio.literalura.dto.ApiResponseDTO;
import alura.desafio.literalura.dto.LivroDTO;
import alura.desafio.literalura.po.Livro;
import alura.desafio.literalura.po.Mapper;
import alura.desafio.literalura.repositories.AutorRepository;
import alura.desafio.literalura.repositories.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	AutorRepository autorRepository;

    public void buscarLivroPeloTitulo(String procura) {
    	HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://gutendex.com/books/?search="+ procura.toLowerCase().replace(" ", "+"))).GET().build();
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            try {
                ApiResponseDTO apiResponse = objectMapper.readValue(response.body(), ApiResponseDTO.class);
                LivroDTO livroDTO = apiResponse.results().get(0);
                Livro livro = Mapper.LivroDTOtoLivro(livroDTO);
                
                //livro.getAuthors().forEach(a -> autorRepository.save(a));
                
                livroRepository.save(livro);
                System.out.println(livro);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listarLivrosRegistrados() {
    	System.out.println(
    			livroRepository.findAll()
    			);
    }
    
    public void listarAutoresRegistrados() {
    	System.out.println(
    			autorRepository.findAll()
    			);
    }
    
    public void listarAutoresVivosEmUmDeterminadoAno(int ano) {
        System.out.println(
            autorRepository.findAll().stream()
                .filter(autor -> autor.getAnoNasc() <= ano &&
                                 (autor.getAnoMort() == 0 || autor.getAnoMort() >= ano))
                .collect(Collectors.toList())
        );
    }
    
    public void listarLivrosEmUmDeterminadoIdioma(String idioma) {
    	 System.out.println(
    	            livroRepository.findAll().stream()
    	                .filter(livro -> livro.getLanguages().contains(idioma))
    	                .collect(Collectors.toList())
    	        );
    }
}
