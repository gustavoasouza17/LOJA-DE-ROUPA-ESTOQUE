package Main;

import Consult.*;

import java.sql.SQLException;
import java.util.Scanner;

public class ConsultMain {

    ConsultCamisetas consultCamisetas = new ConsultCamisetas();
    ConsultShorts consultShorts = new ConsultShorts();
    ConsultCalca consultCalca = new ConsultCalca();
    ConsultRoupaIntima consultRoupaIntima = new ConsultRoupaIntima();
    ConsultCalcado consultCalcado = new ConsultCalcado();

    int desejo;

    public void consultar () throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------");
        System.out.println("|O que deseja consultar?|");
        System.out.println("|1 -    Camiseta        |");
        System.out.println("|2 -     Shorts         |");
        System.out.println("|3 -      Calça         |");
        System.out.println("|4 -   Peça Intima      |");
        System.out.println("|5 -     Calçado        |");
        System.out.println("-------------------------");
        System.out.println();
        System.out.print("Digite: ");
        desejo = sc.nextInt();

        if (desejo == 1){
            consultCamisetas.camisa();
        } else if (desejo == 2){
            consultShorts.shorts();
        } else if (desejo == 3){
            consultCalca.calca();
        } else if (desejo == 4){
            consultRoupaIntima.roupasIntimas();
        } else if (desejo == 5){
            consultCalcado.calcados();
        }
    }
}
