package Alter;

import CreatingConnection.CreateConnection;
import Entity.Shorts;
import Entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterUsers {

    public void users () throws SQLException {
        Connection connection = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("|  O que deseja alterar?  |");
        System.out.println("---------------------------");
        System.out.println("|1 -    alterar nome      |");
        System.out.println("|2 -    alterar senha     |");
        System.out.println("|3 -  sair do programa    |");
        System.out.println("---------------------------");
        System.out.print("Digite: ");
        int desejo = sc.nextInt();
        int codigo;

        if (desejo == 1) {
            System.out.println("Gostaria de alterar o nome de usuário referente a qual código: ");
            codigo = sc.nextInt();

            String sql = "SELECT * FROM users WHERE codigo = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet resultSet = stmt.executeQuery();

            List<Users> users = new ArrayList<>();

            while (resultSet.next()) {
                codigo = resultSet.getInt("codigo");
                users.add(new Users(codigo));
            }

            if (users.isEmpty()) {
                System.out.println("\nNão possue esse item na tabela!");
                connection.close();
            } else {
                for (Users s : users) {
                    System.out.println("Gostaria de atualizar o registro do seguinte usuário" +
                            " ==> " + s.getCodigo() + ", " + s.getNome());
                }

                System.out.println();
                System.out.println("Digite 'S' pra sim, ou 'N' para não: ");
                String condition = sc.next();
                System.out.println();
                boolean continuar = true;

                while (continuar) {
                    if (condition.equalsIgnoreCase("S")) {
                        System.out.println();

                            System.out.print("Digite o nome atualizado: ");
                            String novoNome = sc.next();

                            System.out.println();
                            sql = "UPDATE users set NOME = ? WHERE codigo = ?";
                            stmt = connection.prepareStatement(sql);
                            stmt.setString(1, novoNome);
                            stmt.setInt(2, codigo);
                            stmt.execute();
                            System.out.println();

                            System.out.println("Registro atualizado com sucesso!");
                    }
                }
            }
        } else if (desejo == 2) {
            System.out.println("Gostaria de alterar a senha de usuário referente a qual código: ");
            codigo = sc.nextInt();

            String sql = "SELECT * FROM users WHERE codigo = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet resultSet = stmt.executeQuery();

            List<Users> users = new ArrayList<>();

            while (resultSet.next()) {
                codigo = resultSet.getInt("codigo");
                users.add(new Users(codigo));
            }

            if (users.isEmpty()) {
                System.out.println("\nNão possue esse item na tabela!");
                connection.close();
            } else {
                for (Users s : users) {
                    System.out.println("Gostaria de atualizar o registro do seguinte usuário" +
                            " ==> " + s.getCodigo() + ", " + s.getNome());
                }

                System.out.println();
                System.out.println("Digite 'S' pra sim, ou 'N' para não: ");
                String condition = sc.next();
                System.out.println();
                boolean continuar = true;

                while (continuar) {
                    if (condition.equalsIgnoreCase("S")) {
                        System.out.println();

                        System.out.print("Digite a senha atualizado: ");
                        String novaSenha = sc.next();

                        System.out.println();
                        sql = "UPDATE users set SENHA = ? WHERE codigo = ?";
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, novaSenha);
                        stmt.setInt(2, codigo);
                        stmt.execute();
                        System.out.println();

                        System.out.println("Registro atualizado com sucesso!");
                    }
                }
            }
        }
    }
}
