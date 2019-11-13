package model;

public class Funcao {

    int idFuncao;
    String nome;

    public Funcao() {
    }

    public Funcao(int idFuncao, String nome) {
        this.idFuncao = idFuncao;
        this.nome = nome;
    }

    public Funcao(String nome) {
        this.nome = nome;
    }

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
