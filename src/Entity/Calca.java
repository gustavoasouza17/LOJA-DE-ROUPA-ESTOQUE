package Entity;

public class Calca {

    private int codigo;
    private String marca;
    private String modelo;
    private int quantidade;

    public Calca(int codigo, String marca, String modelo, int quantidade){
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    public int getQuantidade() {
        return quantidade;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }
}
