package Alter;

import CreatingConnection.CreateConnection;
import Entity.Calca;
import Entity.Calcado;
import Entity.RoupasIntimas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterCalcado {

    Alter alter = new Alter();

    public void calcados () throws SQLException {
        Connection connection = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        String marca;
        String modelo;
        int quantidade;

        System.out.print("Informe o código do calçado no qual gostaria de atualizar: ");
        int oldCod = sc.nextInt();

        String sql = "SELECT * FROM calcados WHERE codigo = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, oldCod);
        ResultSet resultSet = stmt.executeQuery();

        List<Calcado> calcados = new ArrayList<>();

        while (resultSet.next()){
            int codigo = resultSet.getInt("codigo");
            marca = resultSet.getString("MARCA");
            modelo = resultSet.getString("MODELO");
            quantidade = resultSet.getInt("QUANTIDADE");
            calcados.add(new Calcado(codigo, marca, modelo, quantidade));
        }

        if (calcados.isEmpty()){
            System.out.println("\nNão possue esse item na tabela!");
            connection.close();
        } else {
            for (Calcado c : calcados) {
                System.out.println("Gostaria de atualizar o registro do seguinte calçado" +
                        " ==> " + c.getCodigo() + ", " + c.getMarca() + ", " + c.getModelo() + ", "
                        + c.getQuantidade());
            }

            System.out.println();
            System.out.println("Digite 'S' pra sim, ou 'N' para não: ");
            String condition = sc.next();
            System.out.println();

            boolean continuar = true;

            while (continuar){

                if (condition.equalsIgnoreCase("S")) {
                    alter.alterar();

                    System.out.print("Digite: ");
                    int desejo = sc.nextInt();
                    System.out.println();

                    if (desejo == 1) {
                        System.out.print("Digite a marca atualizada: ");
                        String novaMarca = sc.next();

                        System.out.println();
                        sql = "UPDATE calcados set MARCA = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, novaMarca);
                        stmt.setInt(2, oldCod);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    } else if (desejo == 2) {
                        System.out.print("Digite o tamanho atualizado: ");
                        int novoTamanho = sc.nextInt();

                        System.out.println();
                        sql = "UPDATE calcados set TAMANHO = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setInt(1, novoTamanho);
                        stmt.setInt(2, oldCod);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    } else if (desejo == 3) {
                        System.out.print("Digite a cor atualizada: ");
                        String novaCor = sc.next();

                        System.out.println();
                        sql = "UPDATE calcados set COR = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, novaCor);
                        stmt.setInt(2, oldCod);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    } else if (desejo == 4) {
                        System.out.print("Digite o modelo atualizado: ");
                        String novoModelo = sc.next();

                        System.out.println();
                        sql = "UPDATE calcados set MODELO = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, novoModelo);
                        stmt.setInt(2, oldCod);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    } else if (desejo == 5) {
                        System.out.print("Digite a quantidade atualizada: ");
                        int novaQuantidade = sc.nextInt();

                        System.out.println();
                        sql = "UPDATE calcados set QUANTIDADE = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setInt(1, novaQuantidade);
                        stmt.setInt(2, oldCod);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    } else if (desejo == 6) {
                        System.out.println("Saindo do programa de alteração.");
                        continuar = false;
                    }
                }  else {
                    System.out.println("Saindo do programa de alteração.");
                    continuar = false;
                }
            }
        }
    }
}
