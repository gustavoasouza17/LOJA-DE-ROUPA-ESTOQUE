package CreatingConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

    public static Connection getConnection () {
        try {
            final String url = "jdbc:mysql://localhost/ESTOQUE_LOJA_ROUPAS";
            final String user = "root";
            final String password = "Gustavo17102005_";

            return DriverManager
                    .getConnection(url, user, password);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
