package jdbcdaocod3r;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
    private Connection conexao;

    public int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement stmt = getConexao().prepareStatement(
                    sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(stmt, atributos);

            if (stmt.executeUpdate() > 0) {
                ResultSet resultado = stmt.getGeneratedKeys();

                if (resultado.next()) {
                    return resultado.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) {
        for (Object atributo : atributos) {
            int indice = 1;
            if (atributo instanceof String) {
                try {
                    stmt.setString(indice, String.valueOf(atributo));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

            else if (atributo instanceof Integer) {
                try {
                    stmt.setInt(indice, (Integer) atributo);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }

            if (atributo instanceof String) {
                try {
                    stmt.setString(indice, String.valueOf(atributo));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            indice++;
        }
    }

    private Connection getConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return conexao;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        conexao = FabricaConexao.getConexao();
        return conexao;
    }
}
