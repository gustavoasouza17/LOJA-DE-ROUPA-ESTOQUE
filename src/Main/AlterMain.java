package Main;

import Alter.*;
import Entity.Calcado;

import java.sql.SQLException;
import java.util.Scanner;

public class AlterMain {

    AlterCamisetas alterCamisetas = new AlterCamisetas();
    AlterShorts alterShorts = new AlterShorts();
    AlterCalca alterCalca = new AlterCalca();
    AlterRoupaIntima alterRoupaIntima = new AlterRoupaIntima();
    AlterCalcado alterCalcado = new AlterCalcado();

    int desejo;

    public void alteracao () throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------");
        System.out.println("|O que deseja alterar?|");
        System.out.println("|1 -   Camiseta       |");
        System.out.println("|2 -    Shorts        |");
        System.out.println("|3 -    Calça         |");
        System.out.println("|4 -  Peça Intima     |");
        System.out.println("|5 -    Calçado       |");
        System.out.println("-----------------------");;
        System.out.print("Digite: ");
        desejo = sc.nextInt();

        if (desejo == 1){
            alterCamisetas.camisas();
        } else if (desejo == 2){
            alterShorts.shorts();
        } else if (desejo == 3){
            alterCalca.calca();
        } else if (desejo == 4){
            alterRoupaIntima.roupasIntimas();
        } else if (desejo == 5){
            alterCalcado.calcados();
        }
    }
}
