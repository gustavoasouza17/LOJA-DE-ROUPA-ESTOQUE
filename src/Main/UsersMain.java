package Main;

import Alter.AlterUsers;
import Consult.ConsultUsers;
import Delete.DeleteUsers;
import Insert.InsertUsers;

import java.sql.SQLException;
import java.util.Scanner;

public class UsersMain {
    Scanner sc = new Scanner(System.in);

    InsertUsers insertUsers = new InsertUsers();
    ConsultUsers consultUsers = new ConsultUsers();
    DeleteUsers deleteUsers = new DeleteUsers();
    AlterUsers alterUsers = new AlterUsers();

    public void usuario (){
        System.out.println("--------------------------------------");
        System.out.println("|             LOJA ROUPAS +           |");
        System.out.println("--------------------------------------");
        System.out.println("|1 - entrar com usuario administrador |");
        System.out.println("|2 -    entrar com usuario padrão     |");
        System.out.println("|3 -         fechar programa          |");
        System.out.println("--------------------------------------");
        System.out.print("\nDigite: ");
    }

    public void insertUsuario (){
        insertUsers.informarUsuario();
    }

    public void deleteUsuario () throws SQLException {
        deleteUsers.users();
    }

    public void consultUsuario () throws SQLException {
        consultUsers.users();
    }

    public void alterUsuario () throws SQLException {
        alterUsers.users();
    }
}
