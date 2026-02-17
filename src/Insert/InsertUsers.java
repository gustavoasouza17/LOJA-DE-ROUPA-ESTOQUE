package Insert;

import CreatingConnection.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsers {
    Scanner sc = new Scanner(System.in);

    public void informarUsuario (){
        Connection conexao = CreateConnection.getConnection();
        System.out.println("Crie um login e senha para os usuários do programa!");
        System.out.println("Qual será o nome do usuário: ");
        String nome = sc.next();
        System.out.println("Digite a senha de " + nome + ": ");
        String senha = sc.next();


        try {
            String sql = "INSERT INTO users (NOME, SENHA)" +
                    "VALUES (?, ?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.execute();

            System.out.printf("%s foi adicionado(a) como um usuário do estoque com sucesso!", nome);
            System.out.println();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}
