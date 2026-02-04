package Insert;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertCamisetas {

    public void camisas () throws SQLException {
        Insert i = new Insert();

        i.confirmar();
        i.inserir("camisetas", "Camiseta");
    }
}
