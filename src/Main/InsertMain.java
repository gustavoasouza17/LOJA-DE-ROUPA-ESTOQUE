package Main;

import Insert.*;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {

    InsertCamisetas insertCamisetas = new InsertCamisetas();
    InsertShorts insertShorts = new InsertShorts();
    InsertCalcas insertCalcas = new InsertCalcas();
    InsertRoupasIntimas insertRoupasIntimas = new InsertRoupasIntimas();
    InsertCalcados insertCalcados = new InsertCalcados();

    int desejo;

    public void insercao () throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------");
        System.out.println("|O que deseja inserir?|");
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
            insertCamisetas.camisas();
        } else if (desejo == 2){
            insertShorts.shorts();
        } else if (desejo == 3){
            insertCalcas.calca();
        } else if (desejo == 4){
            insertRoupasIntimas.roupasIntimas();
        } else if (desejo == 5){
            insertCalcados.calcados();
        }
    }
}
