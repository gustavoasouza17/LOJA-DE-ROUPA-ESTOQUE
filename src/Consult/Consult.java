package Consult;

import java.util.Scanner;

public class Consult {

    public String consultar (){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nDeseja consultar algo em específico? " +
                "Digite 'S' para Sim ou 'N' para Não: ");

        String consulta = sc.nextLine();

        if (consulta.equalsIgnoreCase("S")){
            System.out.println("\n-------------------------------");
            System.out.println("|1 -         marca(s)         |");
            System.out.println("|2 -        tamanho(s)        |");
            System.out.println("|3 -           cor            |");
            System.out.println("|4 -         modelo(s)        |");
            System.out.println("|5 -       quantidade(s)      |");
            System.out.println("-------------------------------");
            System.out.print("Digite: ");
            int desejo = sc.nextInt();
            sc.nextLine();

            if (desejo == 1){
                return "MARCA";
            } else if (desejo == 2){
                return "TAMANHO";
            } else if (desejo == 3){
                return "COR";
            } else if (desejo == 4){
                return "MODELO";
            } else if (desejo == 5){
                return "QUANTIDADE";
            }
        }

        return "";
    }
}
