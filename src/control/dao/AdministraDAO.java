package control.dao;

import control.connection.ConnectionFactory;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Administra;
import model.Documento;
import model.FuncionarioDIREH;

public class AdministraDAO {

    public AdministraDAO() {
    }

    public Object findByPrimaryKey(Administra administra) {
        FuncionarioDIREHDAO dao = new FuncionarioDIREHDAO();
        DocumentoDAO documentoDAO = new DocumentoDAO();
        /*Consultado a existencia do funcionario e do documento
         *Assim a consulta só é executada se ambos registros estão nas tabelas
         *Em questão
         */
        FuncionarioDIREH f = dao.findByPrimaryKey(administra.getCpfFuncionario());
        Documento documento = documentoDAO.findByPrimaryKey(administra.getIdDocumento());

        String cpf = f.getCpf();
        long idDocumento = documento.getIdDoc();

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT "
                    + "CPF_Funcionario,"
                    + "ID_Doc,"
                    + "data_atualizacao"
                    + "FROM Administra"
                    + "WHERE CPF_Funcionario=? AND ID_Doc=?;";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setLong(1, idDocumento);
            rs = stmt.executeQuery();

            while (rs.next()) {
                administra.setCpfFuncionario(rs.getString("CPF_Funcionario"));
                administra.setIdDocumento(rs.getInt("ID_Doc"));
                administra.setDataAtualizacao(rs.getString("data_atualizacao"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao localizar funcioario" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return administra;
    }

    public void create(Administra administra) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            if (!administra.getCpfFuncionario().equals("")
                    && administra.getIdDocumento() != 0) {
                String sql = "INSERT INTO Administra("
                        + "CPF_Funcionario,"
                        + "ID_Doc,"
                        + "data_atualizacao,"
                        + "VALUES (?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, administra.getCpfFuncionario());
                stmt.setInt(2, administra.getIdDocumento());
                stmt.setString(3, administra.getDataAtualizacao());
                stmt.execute();

            }
            System.out.println("Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o documento ou funcionario: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Administra> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Administra> administrados = new ArrayList<>();
        try {
            String sql = "SELECT CPF_Funcionario,"
                    + "ID_Doc,"
                    + "data_atualizacao, "
                    + "Senha,"
                    + "Email,"
                    + "Telefone_Fixo,"
                    + "Telefone_Movel,"
                    + "Cargo,"
                    + "Horario_Entrada,"
                    + "Horario_Saida"
                    + "FROM Administra";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Administra administra = new Administra();
                administra.setCpfFuncionario(rs.getString("CPF_Funcionario"));
                administra.setIdDocumento(rs.getInt("ID_Doc"));
                administra.setDataAtualizacao(rs.getString("data_atualizacao"));
                administrados.add(administra);
            }
            System.out.println("Consulta Finalizada com sucesso. \nNumero de Registros:" + administrados.size());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar todos os Funcionarios:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return administrados;
    }

    public void update(Administra administra) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE Administra SET "
                    + "data_atualizacao=?"
                    + "WHERE CPF_Funcionario=? AND ID_Doc=?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, administra.getDataAtualizacao());
            stmt.setString(2, administra.getCpfFuncionario());
            stmt.setInt(3, administra.getIdDocumento());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Administra administra) {
        String cpf = administra.getCpfFuncionario();
        long idDocumento = administra.getIdDocumento();

        FuncionarioDIREHDAO funcionarioDIREHDAO = new FuncionarioDIREHDAO();
        DocumentoDAO documentoDAO = new DocumentoDAO();
        /*Consultado a existencia do funcionario e do documento
         *Assim a consulta só é executada se ambos registros estão nas tabelas
         *Em questão
         */
        FuncionarioDIREH f = (FuncionarioDIREH) funcionarioDIREHDAO.findByPrimaryKey(cpf);
        Documento d = (Documento) documentoDAO.findByPrimaryKey(idDocumento);

        cpf = f.getCpf();
        idDocumento = d.getIdDoc();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {

            stmt = con.prepareStatement("DELETE FROM Administra WHERE CPF_Funcionario = ? AND ID_Doc=?");
            stmt.setString(1, cpf);
            stmt.setLong(1, idDocumento);
            stmt.executeUpdate();
            System.out.println("Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

}
