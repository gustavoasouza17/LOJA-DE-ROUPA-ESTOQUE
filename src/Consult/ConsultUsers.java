package Consult;

import CreatingConnection.CreateConnection;
import Entity.Calca;
import Entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultUsers {

    public void users () throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conexao = CreateConnection.getConnection();

        String sql;
        PreparedStatement stmt;
        ResultSet resultado;

        System.out.println("\nDeseja consultar algo em específico? " +
                "Digite 'S' para Sim ou 'N' para Não: ");

        String consulta = sc.nextLine();

        if (!consulta.equalsIgnoreCase("S")){
            sql = "SELECT * FROM users";
            stmt = conexao.prepareStatement(sql);
            resultado = stmt.executeQuery();
        } else {
            System.out.print("Digite o código do usuário que gostaria de consultar: ");
            int codigo = sc.nextInt();

            sql = "SELECT * FROM users WHERE codigo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            resultado = stmt.executeQuery();
        }

        List<Users> users = new ArrayList<>();

        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("NOME");
            users.add(new Users(codigo, nome));
        }

        if (users.isEmpty()){
            System.out.println("A lista está vazia");
        }

        for (Users s : users) {
            System.out.println(s.getCodigo() + " ==> " + s.getNome());
        }

        System.out.println();
        conexao.close();
    }
}
