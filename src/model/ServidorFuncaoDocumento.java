package model;

public class ServidorFuncaoDocumento {

    private String cpfServidor;
    private int idDoc, idFuncao;

    public ServidorFuncaoDocumento() {
    }

    public ServidorFuncaoDocumento(String cpfServidor, int idFuncao, int idDoc) {
        this.cpfServidor = cpfServidor;
        this.idFuncao = idFuncao;
        this.idDoc = idDoc;
    }

    public String getCpfServidor() {
        return cpfServidor;
    }

    public void setCpfServidor(String cpfServidor) {
        this.cpfServidor = cpfServidor;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

}
