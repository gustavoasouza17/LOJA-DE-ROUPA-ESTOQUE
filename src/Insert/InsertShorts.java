package Insert;

import CreatingConnection.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertShorts {

    public void shorts () throws SQLException {
        Insert i = new Insert();

        i.confirmar();
        i.inserir("shorts", "Shorts");
    }
}
