package Main;

import CreatingConnection.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Layout {

    InsertMain insertMain = new InsertMain();
    AlterMain alterMain = new AlterMain();
    ConsultMain consultMain = new ConsultMain();
    DeleteMain deleteMain = new DeleteMain();
    UsersMain usersMain = new UsersMain();

    boolean continuar = true;

    public void layoutMain () throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conexao = CreateConnection.getConnection();

        usersMain.usuario();
        int desejo = sc.nextInt();

        if (desejo == 1){
            while (continuar == true){
                System.out.println("Digite o nome do usuário: ");
                String nome = sc.next();
                System.out.println("Digite a senha do usuário: ");
                String senha = sc.next();

                String sql = "SELECT * FROM users WHERE NOME = ? AND SENHA = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, senha);
                ResultSet result = stmt.executeQuery();

                if (result.next()){
                    System.out.println("Login Realizado com sucesso! \n");
                    while (continuar == true){
                        System.out.println("-------------------------------------");
                        System.out.println("|            LOJA ROUPAS +          |");
                        System.out.println("-------------------------------------");
                        System.out.println("|       O que deseja realizar?      |");
                        System.out.println("| 1 - inserir usuários do estoque   |");
                        System.out.println("| 2 - alterar usuários do estoque   |");
                        System.out.println("| 3 - consultar usuários do estoque |");
                        System.out.println("| 4 - remover usuários do estoque   |");
                        System.out.println("| 5 -     sair do modo admin        |");
                        System.out.println("-------------------------------------");
                        System.out.print("Digite: ");
                        desejo = sc.nextInt();
                        if (desejo == 1){
                            usersMain.insertUsuario();
                        } else if (desejo == 2){
                            usersMain.alterUsuario();
                        } else if (desejo == 3){
                            usersMain.consultUsuario();
                        } else if (desejo == 4){
                            usersMain.deleteUsuario();
                        } else if (desejo == 5){
                            System.out.println("saindo!");
                            continuar = false;
                        }
                    }
                } else {
                    System.out.println("Usuário ou senha incorreta! \n");
                }
            }
        } else if (desejo == 2) {
            while (continuar == true){

                System.out.println("Digite o nome do usuário: ");
                String nome = sc.next();
                System.out.println("Digite a senha do usuário: ");
                String senha = sc.next();

                String sql = "SELECT * FROM users WHERE NOME = ? AND SENHA = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, senha);
                ResultSet result = stmt.executeQuery();
                if (result.next()){
                    System.out.println("-------------------------------------");
                    System.out.println("|            LOJA ROUPAS +          |");
                    System.out.println("-------------------------------------");
                    System.out.println("|       O que deseja realizar?      |");
                    System.out.println("| 1 - inserir produtos no estoque   |");
                    System.out.println("| 2 - alterar produtos no estoque   |");
                    System.out.println("| 3 - consultar produtos no estoque |");
                    System.out.println("| 4 -  remover produtos no estoque  |");
                    System.out.println("| 5 -       sair do estoque         |");
                    System.out.println("-------------------------------------");
                    System.out.print("\nDigite: ");
                    desejo = sc.nextInt();

                    if (desejo == 1){
                        insertMain.insercao();
                    } else if (desejo == 2){
                        alterMain.alteracao();
                    } else if (desejo == 3){
                        consultMain.consultar();
                    } else if (desejo == 4){
                        deleteMain.deletar();
                    }  else {
                        System.out.println("Programa finalizado!");
                        continuar = false;
                    }
                } else {
                    System.out.println("Usuário ou senha incorreta! \n");
                }
            }

        } else if (desejo == 3){
            sc.close();
        }
    }
}
