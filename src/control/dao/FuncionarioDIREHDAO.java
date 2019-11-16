package control.dao;

import control.connection.*;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import model.FuncionarioDIREH;

public class FuncionarioDIREHDAO {
    
    Connection con;
    
    public FuncionarioDIREH findByPrimaryKey(String cpf) {
        FuncionarioDIREH funcionario = new FuncionarioDIREH();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (!cpf.isEmpty()) {

            try {
                String sql = "SELECT "
                        + "CPF_Funcionario,"
                        + "Nome,"
                        + "Login, "
                        + "Senha,"
                        + "Email,"
                        + "Telefone_Fixo,"
                        + "Telefone_Movel,"
                        + "Cargo, "
                        + "Horario_Entrada,"
                        + "Horario_Saida "
                        + "FROM Funcionario_DIREH "
                        + "WHERE CPF_Funcionario=?;";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, cpf);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    funcionario.setCpf(rs.getString("CPF_Funcionario"));
                    funcionario.setNome(rs.getString("Nome"));
                    funcionario.setLogin(rs.getString("Login"));
                    funcionario.setEmail(rs.getString("Email"));
                    funcionario.setSenha(rs.getString("Senha"));
                    funcionario.setTelefoneFixo(rs.getLong("Telefone_Fixo"));
                    funcionario.setTelefoneMovel(rs.getLong("Telefone_Movel"));
                    funcionario.setCargo(rs.getString("Cargo"));
                    funcionario.setHorarioEntrada(rs.getString("Horario_Entrada"));
                    funcionario.setHorarioSaida(rs.getString("Horario_Saida"));

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar" + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }
        return funcionario;
    }

    
    public void create(FuncionarioDIREH funcionario) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            if (!funcionario.getCpf().equals("")) {
                String sql = "INSERT INTO Funcionario_DIREH("
                        + "CPF_Funcionario,"
                        + "Nome,"
                        + "Login,"
                        + "Senha,"
                        + "Email,"
                        + "Telefone_Fixo,"
                        + "Telefone_Movel,"
                        + "Cargo,"
                        + "Horario_Entrada,"
                        + "Horario_Saida) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, funcionario.getCpf());
                stmt.setString(2, funcionario.getNome());
                stmt.setString(3, funcionario.getLogin());
                stmt.setString(4, funcionario.getSenha());
                stmt.setString(5, funcionario.getEmail());
                stmt.setLong(6, funcionario.getTelefoneFixo());
                stmt.setLong(7, funcionario.getTelefoneMovel());
                stmt.setString(8, funcionario.getCargo());
                stmt.setString(9, funcionario.getHorarioEntrada());
                stmt.setString(10, funcionario.getHorarioSaida());
                stmt.execute();

            }
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o funcionario: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    
    public ArrayList<FuncionarioDIREH> readAll() {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<FuncionarioDIREH> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT CPF_Funcionario,"
                    + "Nome,"
                    + "Login, "
                    + "Senha,"
                    + "Email,"
                    + "Telefone_Fixo,"
                    + "Telefone_Movel,"
                    + "Cargo,"
                    + "Horario_Entrada,"
                    + "Horario_Saida "
                    + "FROM Funcionario_DIREH";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                FuncionarioDIREH funcionario = new FuncionarioDIREH();
                funcionario.setCpf(rs.getString("CPF_Funcionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setLogin(rs.getString("Login"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setSenha(rs.getString("Senha"));
                funcionario.setTelefoneFixo(rs.getLong("Telefone_Fixo"));
                funcionario.setTelefoneMovel(rs.getLong("Telefone_Movel"));
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setHorarioEntrada(rs.getString("Horario_Entrada"));
                funcionario.setHorarioSaida(rs.getString("Horario_Saida"));
                funcionarios.add(funcionario);
            }

            System.out.println("Consulta Finalizada com sucesso! \nNumero de Registros:" + funcionarios.size());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar todos os Funcionarios:\n" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }

    
    public void update(FuncionarioDIREH funcionario) {
        
        con = ConnectionFactory.getConnection();// Obtendo conexão com o banco de dados
        PreparedStatement stmt = null;//Objeto que prepara a consulta SQL

        try {
            String sql = "UPDATE Funcionario_DIREH SET "
                    + "Nome=? ,"
                    + "Login=? ,"
                    + "Senha=? ,"
                    + "Email=? ,"
                    + "Telefone_Fixo=? ,"
                    + "Telefone_Movel=? ,"
                    + "Cargo=? ,"
                    + "Horario_Entrada=? ,"
                    + "Horario_Saida=? "
                    + "WHERE CPF_Funcionario=?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getLogin());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getEmail());
            stmt.setLong(5, funcionario.getTelefoneFixo());
            stmt.setLong(6, funcionario.getTelefoneMovel());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getHorarioEntrada());
            stmt.setString(9, funcionario.getHorarioSaida());
            stmt.setString(10, funcionario.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o funcionário " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);//Fecha a conexão com o banco
        }
    }

    
    public void delete(FuncionarioDIREH funcionario) {
        
        con = ConnectionFactory.getConnection(); // Abre a conexão com o banco
        PreparedStatement stmt;//Objeto que prepara a consulta SQL

        try {
            funcionario = findByPrimaryKey(funcionario.getCpf());
            //Verificar se o Funcionario Existe
            if (!funcionario.getCpf().isEmpty()) {
                stmt = con.prepareStatement("DELETE FROM Funcionario_DIREH WHERE CPF_Funcionario = ?");
                stmt.setString(1, funcionario.getCpf());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");

            } else {
                JOptionPane.showMessageDialog(null, "O funcionario não existe", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o Funcionario" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con);//Fecha a conexão com o banco de dados
        }
    }

    public ArrayList<FuncionarioDIREH> findByName(String name) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<FuncionarioDIREH> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT CPF_Funcionario,"
                    + "Nome,"
                    + "Login, "
                    + "Senha,"
                    + "Email,"
                    + "Telefone_Fixo,"
                    + "Telefone_Movel,"
                    + "Cargo,"
                    + "Horario_Entrada,"
                    + "Horario_Saida "
                    + "FROM Funcionario_DIREH "
                    + "WHERE Nome LIKE '%"+name+"%'";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                FuncionarioDIREH funcionario = new FuncionarioDIREH();
                funcionario.setCpf(rs.getString("CPF_Funcionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setLogin(rs.getString("Login"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setSenha(rs.getString("Senha"));
                funcionario.setTelefoneFixo(rs.getLong("Telefone_Fixo"));
                funcionario.setTelefoneMovel(rs.getLong("Telefone_Movel"));
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setHorarioEntrada(rs.getString("Horario_Entrada"));
                funcionario.setHorarioSaida(rs.getString("Horario_Saida"));
                funcionarios.add(funcionario);
            }

            System.out.println("Consulta Finalizada com sucesso! \nNumero de Registros:" + funcionarios.size());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar todos os Funcionarios:\n" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }
}
