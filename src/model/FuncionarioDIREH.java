package model;

public class FuncionarioDIREH {

    private String cpf, nome, login, senha, email, cargo, horarioEntrada, horarioSaida;
    private long telefoneFixo, telefoneMovel;

    public FuncionarioDIREH() {
    }

    public FuncionarioDIREH(String cpf, String nome, String login, String senha, String email, String cargo, long telefoneFixo, long telefoneMovel, String horarioEntrada, String horarioSaida) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cargo = cargo;
        this.telefoneFixo = telefoneFixo;
        this.telefoneMovel = telefoneMovel;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(long telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public long getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(long telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

}
