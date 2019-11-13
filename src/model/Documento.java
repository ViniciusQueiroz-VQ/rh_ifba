package model;

public class Documento {

    private String tamanho, nome, descricao, dataCriacao, dataDocumento, arquivoDocumento;
    private long IdDoc;

    private int IdNumero, IdOrigem;

    public Documento() {
    }

    public Documento(String tamanho, String nome, String descricao, String dataCriacao, String dataDocumento, long IdDoc, String arquivoDocumento, int IdNumero, int IdOrigem) {
        this.tamanho = tamanho;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataDocumento = dataDocumento;
        this.IdDoc = IdDoc;
        this.arquivoDocumento = arquivoDocumento;
        this.IdNumero = IdNumero;
        this.IdOrigem = IdOrigem;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public long getIdDoc() {
        return IdDoc;
    }

    public void setIdDoc(long IdDoc) {
        this.IdDoc = IdDoc;
    }

    public int getIdNumero() {
        return IdNumero;
    }

    public void setIdNumero(int IdNumero) {
        this.IdNumero = IdNumero;
    }

    public int getIdOrigem() {
        return IdOrigem;
    }

    public void setIdOrigem(int IdOrigem) {
        this.IdOrigem = IdOrigem;
    }

    public String getArquivoDocumento() {
        return arquivoDocumento;
    }

    public void setArquivoDocumento(String arquivoDocumento) {
        this.arquivoDocumento = arquivoDocumento;
    }

    @Override
    public String toString() {
        return "tamanho:"+tamanho+" - nome:"+nome+" - descricao:"+descricao+" - dataCriacao:"+dataCriacao+" - DataDocumento:"+dataDocumento+" - Arquivo"+arquivoDocumento+" ";
    }
    
}
