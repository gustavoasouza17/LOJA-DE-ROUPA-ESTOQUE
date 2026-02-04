package Main;

import Delete.*;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {

    DeleteCamisetas deleteCamisetas = new DeleteCamisetas();
    DeleteShorts deleteShorts = new DeleteShorts();
    DeleteCalcas deleteCalcas = new DeleteCalcas();
    DeleteRoupasIntimas deleteRoupasIntimas = new DeleteRoupasIntimas();
    DeleteCalcados deleteCalcados = new DeleteCalcados();

    int desejo;

    public void deletar () throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------");
        System.out.println("|O que deseja deletar?|");
        System.out.println("|1 -   Camiseta       |");
        System.out.println("|2 -    Shorts        |");
        System.out.println("|3 -    Calça         |");
        System.out.println("|4 -  Peça Intima     |");
        System.out.println("|5 -    Calçado       |");
        System.out.println("-----------------------");
        System.out.println();
        System.out.print("Digite: ");
        desejo = sc.nextInt();

        if (desejo == 1){
            deleteCamisetas.camisas();
        } else if (desejo == 2){
            deleteShorts.shorts();
        } else if (desejo == 3){
            deleteCalcas.calca();
        } else if (desejo == 4){
            deleteRoupasIntimas.roupasIntimas();
        } else if (desejo == 5){
            deleteCalcados.calcado();
        }
    }
}
