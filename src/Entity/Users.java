package Entity;

public class Users {

    private int codigo;
    private String nome;

    public Users(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public Users(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
