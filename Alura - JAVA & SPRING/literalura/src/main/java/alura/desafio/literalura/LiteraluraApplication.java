package alura.desafio.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "alura.desafio.literalura")
public class LiteraluraApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);
		UserInterface userInterface = context.getBean(UserInterface.class);
		userInterface.run();
	}

}
