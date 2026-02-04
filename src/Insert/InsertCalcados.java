package Insert;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertCalcados {

    public void calcados () throws SQLException {
        Insert i = new Insert();

        i.confirmar();
        i.inserir("calcados", "Calçado");
    }
}
