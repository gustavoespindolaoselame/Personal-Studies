// package jdbccod3r;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.util.Scanner;

// public class NovaPessoa {
//     public static void main(String[] args) throws SQLException{
//         Scanner scanner = new Scanner(System.in);
        
//         Connection conexao = FabricaConexao.getConexao();
//         System.out.println("Qual o nome?");
//         String nome = scanner.nextLine();
//         String sql = "INSERT INTO pessoas (nome) VALUES (?);";

//         PreparedStatement stmt = conexao.prepareStatement(sql);
//         stmt.setString(1, nome);
//         stmt.execute();

//         System.out.println(stmt);
//         System.out.println("Pessoa Incluida com sucesso");

//         scanner.close();
//     }
// }
