package Consult;

import CreatingConnection.CreateConnection;
import Entity.Calcado;
import Entity.RoupasIntimas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultCalcado {

    Consult consult = new Consult();

    public void calcados () throws SQLException {
        Connection conexao = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        String consulta = consult.consultar();
        String sql;
        PreparedStatement stmt;
        ResultSet resultado;

        if (consulta.equalsIgnoreCase("MARCA")){
            System.out.print("Digite a marca do calçado: ");
            String marca = sc.nextLine();

            sql = "SELECT * FROM calcados WHERE MARCA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("TAMANHO")){
            System.out.print("Digite o tamanho do calçado: ");
            String tamanho = sc.nextLine();

            sql = "SELECT * FROM calcados WHERE TAMANHO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tamanho);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("COR")){
            System.out.print("Digite a cor do calçado: ");
            String cor = sc.nextLine();

            sql = "SELECT * FROM calcados WHERE COR = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cor);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("MODELO")){
            System.out.print("Digite o modelo do calçado: ");
            String modelo = sc.nextLine();

            sql = "SELECT * FROM calcados WHERE MODELO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, modelo);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("QUANTIDADE")){
            System.out.print("Digite a quantidade do calçado: ");
            int quantidade = sc.nextInt();

            sql = "SELECT * FROM calcados WHERE QUANTIDADE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            resultado = stmt.executeQuery();
        } else {
            sql = "SELECT * FROM calcados";
            stmt = conexao.prepareStatement(sql);
            resultado = stmt.executeQuery();
        }

        List<Calcado> calcados = new ArrayList<>();

        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String marca = resultado.getString("MARCA");
            String modelo = resultado.getString("MODELO");
            int quantidade = resultado.getInt("QUANTIDADE");
            calcados.add(new Calcado(codigo, marca, modelo, quantidade));
        }

        if (calcados.isEmpty()){
            System.out.println("A lista está vazia");
        }

        for (Calcado c : calcados) {
            System.out.println(c.getCodigo() + " ==> " + c.getMarca() + " | " + c.getModelo() + " | " + c.getQuantidade());
        }

        System.out.println();
        conexao.close();
    }
}
