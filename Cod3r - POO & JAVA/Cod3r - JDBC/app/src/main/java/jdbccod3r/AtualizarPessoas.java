// package jdbccod3r;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.util.Scanner;

// public class AtualizarPessoas {
//     public static void main(String[] args) throws SQLException {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Qual a o nome?");
//         String nome = scanner.next();
//         System.out.println("Qual a o id?");
//         int id = scanner.nextInt();

//         Connection conexao = FabricaConexao.getConexao();
//         String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
//         PreparedStatement stmt = conexao.prepareStatement(sql);
//         stmt.setString(1, nome);
//         stmt.setInt(2, id);
//         stmt.execute();

//         scanner.close();
//     }
// }
