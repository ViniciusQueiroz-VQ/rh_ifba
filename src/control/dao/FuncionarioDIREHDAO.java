package control.dao;

import control.connection.*;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import model.FuncionarioDIREH;

public class FuncionarioDIREHDAO implements CRUD {

    @Override
    public Object findByPrimaryKey(Object o) {
        FuncionarioDIREH funcionario = (FuncionarioDIREH) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        if (!funcionario.getCpf().isEmpty()) {

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
                stmt.setString(1, funcionario.getCpf());
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

    @Override
    public void create(Object o) {
        FuncionarioDIREH funcionarioDIREH = (FuncionarioDIREH) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            if (!funcionarioDIREH.getCpf().equals("")) {
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
                stmt.setString(1, funcionarioDIREH.getCpf());
                stmt.setString(2, funcionarioDIREH.getNome());
                stmt.setString(3, funcionarioDIREH.getLogin());
                stmt.setString(4, funcionarioDIREH.getSenha());
                stmt.setString(5, funcionarioDIREH.getEmail());
                stmt.setLong(6, funcionarioDIREH.getTelefoneFixo());
                stmt.setLong(7, funcionarioDIREH.getTelefoneMovel());
                stmt.setString(8, funcionarioDIREH.getCargo());
                stmt.setString(9, funcionarioDIREH.getHorarioEntrada());
                stmt.setString(10, funcionarioDIREH.getHorarioSaida());
                stmt.execute();

            }
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o funcionario: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public ArrayList readAll() {
        Connection con = ConnectionFactory.getConnection();
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

    @Override
    public void update(Object o) {
        FuncionarioDIREH funcionarioDIREH = (FuncionarioDIREH) o;//Convertendo o Objeto para um modelo
        Connection con = ConnectionFactory.getConnection();// Obtendo conexão com o banco de dados
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

            stmt.setString(1, funcionarioDIREH.getNome());
            stmt.setString(2, funcionarioDIREH.getLogin());
            stmt.setString(3, funcionarioDIREH.getSenha());
            stmt.setString(4, funcionarioDIREH.getEmail());
            stmt.setLong(5, funcionarioDIREH.getTelefoneFixo());
            stmt.setLong(6, funcionarioDIREH.getTelefoneMovel());
            stmt.setString(7, funcionarioDIREH.getCargo());
            stmt.setString(8, funcionarioDIREH.getHorarioEntrada());
            stmt.setString(9, funcionarioDIREH.getHorarioSaida());
            stmt.setString(10, funcionarioDIREH.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o funcionário " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);//Fecha a conexão com o banco
        }
    }

    @Override
    public void delete(Object o) {
        FuncionarioDIREH funcionario = (FuncionarioDIREH) o;//Converte o objeto para um Model
        Connection con = ConnectionFactory.getConnection(); // Abre a conexão com o banco
        PreparedStatement stmt;//Objeto que prepara a consulta SQL

        try {
            funcionario = (FuncionarioDIREH) findByPrimaryKey(funcionario);
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

    public ArrayList findByName(Object o) {
        ArrayList<FuncionarioDIREH> funcionarios = new ArrayList<>();
        
        return funcionarios;
    }

}
