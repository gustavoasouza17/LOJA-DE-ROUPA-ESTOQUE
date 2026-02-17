package CreatingTables;

import CreatingConnection.CreateConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableUsers {
    public static void main(String[] args) throws SQLException {
        Connection conexao = CreateConnection.getConnection();

        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "codigo INT AUTO_INCREMENT PRIMARY KEY," +
                "NOME VARCHAR(80) NOT NULL, " +
                "SENHA VARCHAR (20) NOT NULL " +
                ")";

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela users criada com sucesso");
        conexao.close();
    }
}
