// package jdbccod3r;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class ConsultarPessoas2 {
//     public static void main(String[] args) throws SQLException {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Qual a sessão de nome?");
//         String nome = scanner.next();

//         Connection conexao = FabricaConexao.getConexao();
//         String sql = "SELECT * FROM pessoas WHERE NOME LIKE ?";
//         PreparedStatement stmt = conexao.prepareStatement(sql);
//         stmt.setString(1, "%" + nome + "%");
//         ResultSet resultado = stmt.executeQuery();
//         List<Pessoa> pessoas = new ArrayList<>();
                
                
//         while(resultado.next()){
//             int codigoResultado = resultado.getInt("codigo");
//             String nomeResultado = resultado.getString("nome");
//             pessoas.add(new Pessoa(codigoResultado,nomeResultado));
//         }

//         for(Pessoa p: pessoas){
//             System.out.println(p.getCodigo() + "==>" + p.getNome());
//         }

//         System.out.println(resultado);
//         scanner.close();
//     }
// }
