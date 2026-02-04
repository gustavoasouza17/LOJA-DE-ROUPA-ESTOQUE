package Consult;

import CreatingConnection.CreateConnection;
import Entity.Camiseta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultCamisetas {

    Consult consult = new Consult();

    public void camisa () throws SQLException {
        Connection conexao = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        String consulta = consult.consultar();
        String sql;
        PreparedStatement stmt;
        ResultSet resultado;

        if (consulta.equalsIgnoreCase("MARCA")){
            System.out.print("Digite a marca da camiseta: ");
            String marca = sc.nextLine();

            sql = "SELECT * FROM camisetas WHERE MARCA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("TAMANHO")){
            System.out.print("Digite o tamanho da camiseta: ");
            String tamanho = sc.nextLine();

            sql = "SELECT * FROM camisetas WHERE TAMANHO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tamanho);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("COR")){
            System.out.print("Digite a cor da camiseta: ");
            String cor = sc.nextLine();

            sql = "SELECT * FROM camisetas WHERE COR = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cor);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("MODELO")){
            System.out.print("Digite o modelo da camiseta: ");
            String modelo = sc.nextLine();

            sql = "SELECT * FROM camisetas WHERE MODELO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, modelo);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("QUANTIDADE")){
            System.out.print("Digite a quantidade da camiseta: ");
            int quantidade = sc.nextInt();

            sql = "SELECT * FROM camisetas WHERE QUANTIDADE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            resultado = stmt.executeQuery();
        } else {
            sql = "SELECT * FROM camisetas";
            stmt = conexao.prepareStatement(sql);
            resultado = stmt.executeQuery();
        }


        List<Camiseta> camisetas = new ArrayList<>();

        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String marca = resultado.getString("MARCA");
            String modelo = resultado.getString("MODELO");
            int quantidade = resultado.getInt("QUANTIDADE");
            camisetas.add(new Camiseta(codigo, marca, modelo, quantidade));
        }

        if (camisetas.isEmpty()){
            System.out.println("A lista está vazia");
        }

        for (Camiseta c : camisetas) {
            System.out.println(c.getCodigo() + " ==> " + c.getMarca() + " | " + c.getModelo() + " | " + c.getQuantidade());
        }

        System.out.println();
        conexao.close();
    }
}
