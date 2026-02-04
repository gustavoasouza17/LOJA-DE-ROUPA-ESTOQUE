package Insert;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertRoupasIntimas {

    public void roupasIntimas () throws SQLException {
        Insert i = new Insert();

        i.confirmar();
        i.inserir("roupas_intimas", "Peça Intima");
    }
}
