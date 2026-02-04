package Consult;

import CreatingConnection.CreateConnection;
import Entity.Calca;
import Entity.RoupasIntimas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultRoupaIntima {

    Consult consult = new Consult();

    public void roupasIntimas () throws SQLException {
        Connection conexao = CreateConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        String consulta = consult.consultar();
        String sql;
        PreparedStatement stmt;
        ResultSet resultado;

        if (consulta.equalsIgnoreCase("MARCA")){
            System.out.print("Digite a marca da peça intima: ");
            String marca = sc.nextLine();

            sql = "SELECT * FROM roupas_intimas WHERE MARCA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("TAMANHO")){
            System.out.print("Digite o tamanho da peça intima: ");
            String tamanho = sc.nextLine();

            sql = "SELECT * FROM roupas_intimas WHERE TAMANHO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tamanho);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("COR")){
            System.out.print("Digite a cor da peça intima: ");
            String cor = sc.nextLine();

            sql = "SELECT * FROM roupas_intimas WHERE COR = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cor);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("MODELO")){
            System.out.print("Digite o modelo da peça intima: ");
            String modelo = sc.nextLine();

            sql = "SELECT * FROM roupas_intimas WHERE MODELO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, modelo);
            resultado = stmt.executeQuery();
        } else if (consulta.equalsIgnoreCase("QUANTIDADE")){
            System.out.print("Digite a quantidade da peça intima: ");
            int quantidade = sc.nextInt();

            sql = "SELECT * FROM roupas_intimas WHERE QUANTIDADE = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            resultado = stmt.executeQuery();
        } else {
            sql = "SELECT * FROM roupas_intimas";
            stmt = conexao.prepareStatement(sql);
            resultado = stmt.executeQuery();
        }

        List<RoupasIntimas> roupasIntimas = new ArrayList<>();

        while (resultado.next()){
            int codigo = resultado.getInt("codigo");
            String marca = resultado.getString("MARCA");
            String modelo = resultado.getString("MODELO");
            int quantidade = resultado.getInt("QUANTIDADE");
            roupasIntimas.add(new RoupasIntimas(codigo, marca, modelo, quantidade));
        }

        if (roupasIntimas.isEmpty()){
            System.out.println("A lista está vazia");
        }

        for (RoupasIntimas c : roupasIntimas) {
            System.out.println(c.getCodigo() + " ==> " + c.getMarca() + " | " + c.getModelo() + " | " + c.getQuantidade());
        }

        System.out.println();
        conexao.close();
    }
}
