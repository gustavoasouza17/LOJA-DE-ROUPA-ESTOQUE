package Alter;

import CreatingConnection.CreateConnection;
import Entity.Camiseta;
import Entity.Shorts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterShorts {
    Alter alter = new Alter();

    public void shorts () throws SQLException {
        Connection connection = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        String marca;
        String modelo;
        int quantidade;

        System.out.print("Informe o código do shorts no qual gostaria de atualizar: ");
        int oldCod = sc.nextInt();

        String sql = "SELECT * FROM shorts WHERE codigo = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, oldCod);
        ResultSet resultSet = stmt.executeQuery();

        List<Shorts> shorts = new ArrayList<>();

        while (resultSet.next()){
            int codigo = resultSet.getInt("codigo");
            marca = resultSet.getString("MARCA");
            modelo = resultSet.getString("MODELO");
            quantidade = resultSet.getInt("QUANTIDADE");
            shorts.add(new Shorts(codigo, marca, modelo, quantidade));
        }

        if (shorts.isEmpty()){
            System.out.println("\nNão possue esse item na tabela!");
            connection.close();
        } else {
            for (Shorts s : shorts) {
                System.out.println("Gostaria de atualizar o registro do seguinte shorts" +
                        " ==> " + s.getCodigo() + ", " + s.getMarca() + ", " + s.getModelo() + ", "
                        + s.getQuantidade());
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
                        sql = "UPDATE shorts set MARCA = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, novaMarca);
                        stmt.setInt(2, oldCod);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    } else if (desejo == 2) {
                        System.out.print("Digite o tamanho atualizado: ");
                        String novoTamanho = sc.next();

                        System.out.println();
                        sql = "UPDATE shorts set TAMANHO = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, novoTamanho);
                        stmt.setInt(2, oldCod);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    } else if (desejo == 3) {
                        System.out.print("Digite a cor atualizada: ");
                        String novaCor = sc.next();

                        System.out.println();
                        sql = "UPDATE shorts set COR = ? WHERE codigo = ?";
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
                        sql = "UPDATE shorts set MODELO = ? WHERE codigo = ?";
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
                        sql = "UPDATE shorts set QUANTIDADE = ? WHERE codigo = ?";
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
