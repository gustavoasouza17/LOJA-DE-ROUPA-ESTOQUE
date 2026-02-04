package Consult;

import CreatingConnection.CreateConnection;
import Entity.Calca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultCalca {

    Consult consult = new Consult();

    public void calca () throws SQLException {
        Connection conexao = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        String consulta = consult.consultar();
        String sql;
        PreparedStatement stmt;
        ResultSet resultado;

        if (consulta.equalsIgnoreCase("MARCA")){
            System.out.print("Digite a marca da calça: ");
            String marca = sc.nextLine();

            sql = "SELECT * FROM calcas WHERE MARCA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("TAMANHO")){
            System.out.print("Digite o tamanho da calça: ");
            String tamanho = sc.nextLine();

            sql = "SELECT * FROM calcas WHERE TAMANHO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tamanho);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("COR")){
            System.out.print("Digite a cor da calça: ");
            String cor = sc.nextLine();

            sql = "SELECT * FROM calcas WHERE COR = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cor);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("MODELO")){
            System.out.print("Digite o modelo da calça: ");
            String modelo = sc.nextLine();

            sql = "SELECT * FROM calcas WHERE MODELO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, modelo);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("QUANTIDADE")){
            System.out.print("Digite a quantidade de calça: ");
            int quantidade = sc.nextInt();

            sql = "SELECT * FROM calcas WHERE QUANTIDADE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            resultado = stmt.executeQuery();
        } else {
            sql = "SELECT * FROM calcas";
            stmt = conexao.prepareStatement(sql);
            resultado = stmt.executeQuery();
        }


        List<Calca> calcas = new ArrayList<>();

        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String marca = resultado.getString("MARCA");
            String modelo = resultado.getString("MODELO");
            int quantidade = resultado.getInt("QUANTIDADE");
            calcas.add(new Calca(codigo, marca, modelo, quantidade));
        }

        if (calcas.isEmpty()){
            System.out.println("A lista está vazia");
        }

        for (Calca c : calcas) {
            System.out.println(c.getCodigo() + " ==> " + c.getMarca() + " | " + c.getModelo() + " | " + c.getQuantidade());
        }

        System.out.println();
        conexao.close();
    }
}
