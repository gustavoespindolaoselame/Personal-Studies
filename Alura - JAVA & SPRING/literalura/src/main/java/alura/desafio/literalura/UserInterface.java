package alura.desafio.literalura;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInterface {
	
	@Autowired
	LivroService livroService;
	
	private Scanner scanner = new Scanner(System.in);
	private String mainPage = """
			------------------
			Escolha o número de sua opção:
			1- Buscar livro pelo título
			2- listar livros registrados
			3- listar autores registrados
			4- listar autores vivos em um determinado ano
			5- listar livros em um determinado idioma
			0- sair
			""";
	
	public void run() {
		System.out.println(mainPage);
		int option = scanner.nextInt();
		while(option!=0) {
			while(option>5||option<0)  {
				option = scanner.nextInt();
			};
			switch (option) {
			case 1: {
				System.out.println("Insira o nome do livro que você deseja procurar");
				scanner.nextLine();
				String procura = scanner.nextLine();
				livroService.buscarLivroPeloTitulo(procura);
				break;
			}
			case 2: {
				livroService.listarLivrosRegistrados();
				break;
			}
			case 3: {
				livroService.listarAutoresRegistrados();
				break;
			}
			case 4: {
				System.out.println("Insira o determinado ano");
				scanner.nextLine();
				int procura = scanner.nextInt();
				livroService.listarAutoresVivosEmUmDeterminadoAno(procura);
				break;
			}
			case 5: {
				System.out.println("Insira a sigla da língua");
				scanner.nextLine();
				String procura = scanner.nextLine();
				livroService.listarLivrosEmUmDeterminadoIdioma(procura);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
			System.out.println(mainPage);
			option = scanner.nextInt();
		}
	}
	
	
	public Scanner getScanner() {
		return scanner;
	}


	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}


	public String getMainPage() {
		return mainPage;
	}


	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}


	public UserInterface(Scanner scanner, String mainPage) {
		super();
		this.scanner = scanner;
		this.mainPage = mainPage;
	}

	public UserInterface() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
