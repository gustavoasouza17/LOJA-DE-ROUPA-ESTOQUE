package Main;

import java.sql.SQLException;
import java.util.Scanner;

public class Layout {

    InsertMain insertMain = new InsertMain();
    AlterMain alterMain = new AlterMain();
    ConsultMain consultMain = new ConsultMain();
    DeleteMain deleteMain = new DeleteMain();

    boolean continuar = true;

    public void layoutMain () throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (continuar == true){
            System.out.println("-------------------------------------");
            System.out.println("|            LOJA ROUPAS +          |");
            System.out.println("-------------------------------------");
            System.out.println("|       O que deseja realizar?      |");
            System.out.println("| 1 - inserir produtos no estoque   |");
            System.out.println("| 2 - alterar produtos no estoque   |");
            System.out.println("| 3 - consultar produtos no estoque |");
            System.out.println("| 4 -  remover produtos no estoque  |");
            System.out.println("| 5 -       sair do estoque         |");
            System.out.println("-------------------------------------");
            System.out.print("\nDigite: ");
            int desejo = sc.nextInt();

            if (desejo == 1){
                insertMain.insercao();
            } else if (desejo == 2){
                alterMain.alteracao();
            } else if (desejo == 3){
                consultMain.consultar();
            } else if (desejo == 4){
                deleteMain.deletar();
            }  else {
                System.out.println("Programa finalizado!");
                continuar = false;
            }
        }
    }
}
