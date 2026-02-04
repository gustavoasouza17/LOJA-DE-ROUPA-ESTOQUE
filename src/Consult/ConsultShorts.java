package Consult;

import CreatingConnection.CreateConnection;
import Entity.Camiseta;
import Entity.Shorts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultShorts {

    Consult consult = new Consult();

    public void shorts () throws SQLException {
        Connection conexao = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        String consulta = consult.consultar();
        String sql;
        PreparedStatement stmt;
        ResultSet resultado;

        if (consulta.equalsIgnoreCase("MARCA")){
            System.out.print("Digite a marca do shorts: ");
            String marca = sc.nextLine();

            sql = "SELECT * FROM shorts WHERE MARCA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("TAMANHO")){
            System.out.print("Digite o tamanho do shorts: ");
            String tamanho = sc.nextLine();

            sql = "SELECT * FROM shorts WHERE TAMANHO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tamanho);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("COR")){
            System.out.print("Digite a cor do shorts: ");
            String cor = sc.nextLine();

            sql = "SELECT * FROM shorts WHERE COR = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cor);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("MODELO")){
            System.out.print("Digite o modelo do shorts: ");
            String modelo = sc.nextLine();

            sql = "SELECT * FROM shorts WHERE MODELO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, modelo);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("QUANTIDADE")){
            System.out.print("Digite a quantidade do shorts: ");
            int quantidade = sc.nextInt();

            sql = "SELECT * FROM shorts WHERE QUANTIDADE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            resultado = stmt.executeQuery();
        } else {
            sql = "SELECT * FROM roupas_intimas";
            stmt = conexao.prepareStatement(sql);
            resultado = stmt.executeQuery();
        }

        List<Shorts> shorts = new ArrayList<>();

        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String marca = resultado.getString("MARCA");
            String modelo = resultado.getString("MODELO");
            int quantidade = resultado.getInt("QUANTIDADE");
            shorts.add(new Shorts(codigo, marca, modelo, quantidade));
        }

        if (shorts.isEmpty()){
            System.out.println("A lista está vazia");
        }

        for (Shorts s : shorts) {
            System.out.println(s.getCodigo() + " ==> " + s.getMarca() + " | " + s.getModelo() + " | " + s.getQuantidade());
        }

        System.out.println();
        conexao.close();
    }
}
