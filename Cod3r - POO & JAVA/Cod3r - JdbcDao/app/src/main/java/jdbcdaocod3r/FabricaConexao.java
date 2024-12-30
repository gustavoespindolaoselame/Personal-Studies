package jdbcdaocod3r;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
    public static Connection getConexao() {
        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("banco.url");
            final String usuario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Error In connection");
        }
    }
    private static Properties getProperties(){
        try {
            Properties prop = new Properties();
            String caminho = "/home/gustavo/Documents/GitHub/Personal-Studies/jdbcDaoCod3r/conexao.properties";
            prop.load(new FileInputStream(caminho));
            return prop; 
        } catch (IOException e) {
            throw new RuntimeException("Error in loading properties");
        }
    }
}
