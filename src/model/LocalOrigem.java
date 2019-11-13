package model;

public class LocalOrigem {

    private int idOrigem;
    private String nome, tipo, descricao;

    public LocalOrigem() {
    }

    public int getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(int idOrigem) {
        this.idOrigem = idOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalOrigem(int idOrigem, String nome, String tipo,
            String descricao) {
        this.idOrigem = idOrigem;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }
}
