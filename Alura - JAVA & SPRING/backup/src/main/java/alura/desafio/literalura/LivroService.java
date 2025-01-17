package alura.desafio.literalura;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void carregarDados() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://gutendex.com/books/?search=dom+casmurro")).GET().build();
        //SpringApplication.run(LiteraluraApplication.class, args);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the status code and response body
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

            try {
                ApiResponse apiResponse = objectMapper.readValue(response.body(), ApiResponse.class);
                Livro livro = apiResponse.getResults().get(0);
                System.out.println(livro);

                livroRepository.save(livro);

//				EntityManagerFactory emf = Persistence.createEntityManagerFactory("${spring.jpa.persistence-unit-name}");
//				EntityManager em = emf.createEntityManager();
//
//				// Persist the entity
//				em.getTransaction().begin();
//				em.persist(livro);
//				em.getTransaction().commit();
//
//				// Close resources
//				em.close();
//				emf.close();

                System.out.println("Entity persisted successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
