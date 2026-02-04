package CreatingTables;

import CreatingConnection.CreateConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCalcados {
    public static void main(String[] args) throws SQLException {

        Connection conexao = CreateConnection.getConnection();

        String sql = "CREATE TABLE IF NOT EXISTS calcados (" +
                "codigo INT AUTO_INCREMENT PRIMARY KEY," +
                "MARCA VARCHAR(80) NOT NULL, " +
                "TAMANHO INT NOT NULL, " +
                "COR VARCHAR (20) NOT NULL, " +
                "MODELO CHAR (1) NOT NULL, " +
                "QUANTIDADE INT NOT NULL" +
                ")";

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela calçados criada com sucesso");
        conexao.close();

    }
}
