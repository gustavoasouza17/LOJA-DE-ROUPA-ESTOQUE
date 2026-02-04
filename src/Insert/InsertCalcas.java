package Insert;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertCalcas {

    public void calca () throws SQLException {
        Insert i = new Insert();

        i.confirmar();
        i.inserir("calcas", "Calça");
    }
}
