package alura.desafio.literalura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
public class LiteraluraApplication {



	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);
//		LivroService livroService = context.getBean(LivroService.class);
//		livroService.carregarDados();

	}

}
