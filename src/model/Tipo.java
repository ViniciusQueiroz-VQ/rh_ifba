package model;

public class Tipo {

    int idNumero;
    String nome;

    public Tipo() {
    }

    public Tipo(int idNumero, String nome) {
        this.idNumero = idNumero;
        this.nome = nome;
    }

    public Tipo(String nome) {
        this.nome = nome;
    }

    public int getIdNumero() {
        return idNumero;
    }

    public void setIdNumero(int idNumero) {
        this.idNumero = idNumero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
