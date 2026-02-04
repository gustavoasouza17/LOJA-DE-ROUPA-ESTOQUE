package Insert;

import CreatingConnection.CreateConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

    String marca;
    String tamanho;
    String cor;
    String modelo;
    int quantidade;

    public void confirmar () {
        Scanner sc = new Scanner(System.in);

            System.out.println("Informe a marca: ");
            marca = sc.nextLine();

            System.out.println("Informe o tamanho: ");
            tamanho = sc.nextLine();

            System.out.println("Informe a cor: ");
            cor = sc.nextLine();

            System.out.println("Informe o modelo (M / F): ");
            modelo = sc.nextLine();

            System.out.println("Informe quantos serão adicionados ao estoque: ");
            quantidade = sc.nextInt();
    }

    public void inserir (String table, String produto){
        Connection conexao = CreateConnection.getConnection();

        try {
            String sql = "INSERT INTO " + table + " (MARCA, TAMANHO, COR, MODELO, QUANTIDADE)" +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, tamanho);
            stmt.setString(3, cor);
            stmt.setString(4, modelo);
            stmt.setInt(5, quantidade);
            stmt.execute();

            System.out.printf("%s %s adicionada ao estoque com sucesso!", produto, marca);
            System.out.println();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}

