package Delete;

import CreatingConnection.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUsers {
    public void users () throws SQLException {
        Scanner sc = new Scanner(System.in);

        Connection connection = CreateConnection.getConnection();
        String select = "SELECT * FROM users WHERE codigo = ?";
        String delete = "DELETE FROM users WHERE codigo = ?";

        System.out.print("Informe o código do usuário no qual gostaria de excluir: ");
        int codigo = sc.nextInt();

        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setInt(1, codigo);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()){
            System.out.println("Deseja realmente excluir o seguinte usuário ==> " +
                    resultSet.getInt(1) + ", " + resultSet.getString(2)
                    + ", " + resultSet.getString(3));
        }

        if (codigo == 1){
            System.out.println("Exclusão negada. Não é permitido excluir usuário admin!");
            connection.close();
        } else {
            System.out.print("Digite 'S' para Sim ou 'N' para Não: ");
            String condition = sc.next();
            System.out.println();

            if (condition.equalsIgnoreCase("S")){
                stmt = connection.prepareStatement(delete);
                stmt.setInt(1, codigo);
                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0){
                    System.out.println("Exclusão feita com sucesso!");
                } else {
                    System.out.println("código de n° " + codigo + " não está presente na tabela");
                }
            } else {
                System.out.print("Exclusão negada.");
            }
            connection.close();
        }
    }
}
