package model;

public class Servidor {

    private String cpfServidor, nome, loginServidor, email, status,
            cargo, senhaServidor, arquivoCPF, arquivoRG, descricaoCargo, ultimoAcesso;

    public Servidor() {
    }

    public Servidor(String cpfServidor, String nome, String loginServidor, String email, String status, String cargo, String senhaServidor, String arquivoCPF, String arquivoRG, String descricaoCargo, String ultimoAcesso) {
        this.cpfServidor = cpfServidor;
        this.nome = nome;
        this.loginServidor = loginServidor;
        this.email = email;
        this.status = status;
        this.cargo = cargo;
        this.senhaServidor = senhaServidor;
        this.arquivoCPF = arquivoCPF;
        this.arquivoRG = arquivoRG;
        this.descricaoCargo = descricaoCargo;
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getCpfServidor() {
        return cpfServidor;
    }

    public void setCpfServidor(String cpfServidor) {
        this.cpfServidor = cpfServidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLoginServidor() {
        return loginServidor;
    }

    public void setLoginServidor(String loginServidor) {
        this.loginServidor = loginServidor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenhaServidor() {
        return senhaServidor;
    }

    public void setSenhaServidor(String senhaServidor) {
        this.senhaServidor = senhaServidor;
    }

    public String getArquivoCPF() {
        return arquivoCPF;
    }

    public void setArquivoCPF(String arquivoCPF) {
        this.arquivoCPF = arquivoCPF;
    }

    public String getArquivoRG() {
        return arquivoRG;
    }

    public void setArquivoRG(String arquivoRG) {
        this.arquivoRG = arquivoRG;
    }

    public String getDescricaoCargo() {
        return descricaoCargo;
    }

    public void setDescricaoCargo(String descricaoCargo) {
        this.descricaoCargo = descricaoCargo;
    }

    public String getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(String ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

}
