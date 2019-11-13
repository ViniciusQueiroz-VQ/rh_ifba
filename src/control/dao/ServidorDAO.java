package control.dao;

import control.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Servidor;

public class ServidorDAO implements CRUD {

    public ServidorDAO() {
    }

    @Override
    public Object findByPrimaryKey(Object o) {
        Servidor servidor = (Servidor) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if (!servidor.getCpfServidor().isEmpty()) {
            try {
                String sql = "SELECT "
                        + "CPF_Servidor,"
                        + "Nome,"
                        + "Login_Servidor,"
                        + "Email,"
                        + "Status,"
                        + "Cargo,"
                        + "Senha_Servidor,"
                        + "Arquivo_CPF,"
                        + "Arquivo_RG,"
                        + "Descricao_Cargo,"
                        + "Ultimo_Acesso"
                        + "WHERE CPF_Servidor=?;";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, servidor.getCpfServidor());
                rs = stmt.executeQuery();

                while (rs.next()) {
                    servidor.setCpfServidor(rs.getString("CPF_Servidor"));
                    servidor.setNome(rs.getString("Nome"));
                    servidor.setLoginServidor(rs.getString("Login_Servidor"));
                    servidor.setEmail(rs.getString("Email"));
                    servidor.setStatus(rs.getString("Status"));
                    servidor.setCargo(rs.getString("Cargo"));
                    servidor.setSenhaServidor(rs.getString("Senha_Servidor"));
                    servidor.setArquivoCPF(rs.getString("Arquivo_CPF"));
                    servidor.setArquivoRG(rs.getString("Arquivo_RG"));
                    servidor.setDescricaoCargo(rs.getString("Descricao_Cargo"));
                    servidor.setUltimoAcesso(rs.getString("Ultimo_Acesso"));

                }

            } catch (SQLException ex) {
                System.err.println("Erro ao pesquisar o servidor" + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return servidor;
    }

    @Override
    public void create(Object o) {
        Servidor servidor = (Servidor) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        if (!servidor.getCpfServidor().isEmpty()) {
            try {
                String sql = "INSERT INTO Servidor("
                        + "CPF_Servidor,"
                        + "Nome,"
                        + "Login_Servidor,"
                        + "Email,"
                        + "Status,"
                        + "Cargo,"
                        + "Senha_Servidor,"
                        + "Arquivo_CPF,"
                        + "Arquivo_RG,"
                        + "Descricao_Cargo,"
                        + "Ultimo_Acesso)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, servidor.getCpfServidor());
                stmt.setString(2, servidor.getNome());
                stmt.setString(3, servidor.getEmail());
                stmt.setString(4, servidor.getStatus());
                stmt.setString(5, servidor.getCargo());
                stmt.setString(6, servidor.getSenhaServidor());
                stmt.setString(7, servidor.getArquivoCPF());
                stmt.setString(8, servidor.getArquivoRG());
                stmt.setString(9, servidor.getDescricaoCargo());
                stmt.setString(10, servidor.getUltimoAcesso());
                stmt.execute();

                JOptionPane.showMessageDialog(null, "O Servidor foi cadastrado com sucesso");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Servidor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Servidor invalido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Servidor> servidores = new ArrayList<>();
        try {
            String sql = "SELECT "
                    + "CPF_Servidor,"
                    + "Nome,"
                    + "Login_Servidor,"
                    + "Email,"
                    + "Status,"
                    + "Cargo,"
                    + "Senha_Servidor,"
                    + "Arquivo_CPF,"
                    + "Arquivo_RG,"
                    + "Descricao_Cargo,"
                    + "Ultimo_Acesso"
                    + "WHERE CPF_Servidor=?;";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Servidor servidor = new Servidor();
                servidor.setCpfServidor(rs.getString("CPF_Servidor"));
                servidor.setNome(rs.getString("Nome"));
                servidor.setLoginServidor(rs.getString("Login_Servidor"));
                servidor.setEmail(rs.getString("Email"));
                servidor.setStatus(rs.getString("Status"));
                servidor.setCargo(rs.getString("Cargo"));
                servidor.setSenhaServidor(rs.getString("Senha_Servidor"));
                servidor.setArquivoCPF(rs.getString("Arquivo_CPF"));
                servidor.setArquivoRG(rs.getString("Arquivo_RG"));
                servidor.setDescricaoCargo(rs.getString("Descricao_Cargo"));
                servidor.setUltimoAcesso(rs.getString("Ultimo_Acesso"));
                servidores.add(servidor);
            }
            System.out.println("Consulta Finalizada com sucesso. \nNumero de Registros:" + servidores.size());

        } catch (SQLException ex) {
            System.err.println("Erro ao Consultar todos os Servidores:\n" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return servidores;
    }

    @Override
    public void update(Object o) {
        Servidor servidor = (Servidor) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        if (!servidor.getCpfServidor().isEmpty()) {
            try {
                String sql = "UPDATE Servidor SET "
                        + "Nome,"
                        + "Login_Servidor,"
                        + "Email,"
                        + "Status,"
                        + "Cargo,"
                        + "Senha_Servidor,"
                        + "Arquivo_CPF,"
                        + "Arquivo_RG,"
                        + "Descricao_Cargo,"
                        + "Ultimo_Acesso"
                        + "WHERE CPF_Servidor=?;";
                stmt = con.prepareStatement(sql);

                stmt.setString(1, servidor.getNome());
                stmt.setString(2, servidor.getLoginServidor());
                stmt.setString(3, servidor.getEmail());
                stmt.setString(4, servidor.getStatus());
                stmt.setString(5, servidor.getCargo());
                stmt.setString(6, servidor.getSenhaServidor());
                stmt.setString(7, servidor.getArquivoCPF());
                stmt.setString(8, servidor.getArquivoRG());
                stmt.setString(9, servidor.getDescricaoCargo());
                stmt.setString(10, servidor.getUltimoAcesso());
                stmt.setString(11, servidor.getCpfServidor());

                stmt.executeUpdate();

                System.out.println("Servidor atualizado com sucesso");
            } catch (SQLException ex) {

                System.err.println("Erro ao atualizar o Servidor" + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Servidor não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void delete(Object o) {
        Servidor servidor = (Servidor) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        if (!servidor.getCpfServidor().isEmpty()) {
            try {
                servidor = (Servidor) findByPrimaryKey(servidor.getCpfServidor());
                stmt = con.prepareStatement("DELETE FROM Servidor WHERE CPF_Servidor = ?");
                stmt.setString(1, servidor.getCpfServidor());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deletado com sucesso", "Erro", JOptionPane.ERROR_MESSAGE);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar o Servidor" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                ConnectionFactory.closeConnection(con);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Servidor Invalido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
