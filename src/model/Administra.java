package model;

public class Administra {

    private String cpfFuncionario, dataAtualizacao;
    private int idDocumento;

    public Administra() {
    }

    public Administra(String cpfFuncionario, int idDocumento, String dataAtualizacao) {
        this.cpfFuncionario = cpfFuncionario;
        this.idDocumento = idDocumento;
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

}
