package control.dao;

import control.connection.ConnectionFactory;
import java.util.ArrayList;
import model.ServidorFuncaoDocumento;
import java.sql.*;
import javax.swing.JOptionPane;

public class ServidorFuncaoDocumentoDAO {

    public ServidorFuncaoDocumentoDAO() {
    }

    
    public void create(ServidorFuncaoDocumento sfd) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            String sql = "INSERT INTO Servidor_Funcao_Documento ("
                    + "CPF_Servidor,"
                    + "ID_Funcao,"
                    + " ID_Doc) "
                    + "VALUES(?, ?, ?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sfd.getCpfServidor());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar os dados. \n" + ex.getLocalizedMessage());

        }
    }

    
    public ArrayList<ServidorFuncaoDocumento> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ServidorFuncaoDocumento> listaSerFunDoc = new ArrayList<>();
        try {
            String sql = "SELECT ID_Tipo,"
                    + "Nome,"
                    + "FROM Tipo";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ServidorFuncaoDocumento serFunDoc = new ServidorFuncaoDocumento();
                serFunDoc.setCpfServidor(rs.getString("CPF_Servidor"));
                serFunDoc.setIdDoc(rs.getInt("ID_Doc"));
                serFunDoc.setIdFuncao(rs.getInt("ID_Funcao"));
                listaSerFunDoc.add(serFunDoc);
            }
            JOptionPane.showMessageDialog(null, "Consulta Finalizada com sucesso. \nNumero de "
                    + "Registros:" + listaSerFunDoc.size());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar todos os Registros:\n"
                    + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaSerFunDoc;
    }

    
    public ServidorFuncaoDocumento findByPrimaryKey(ServidorFuncaoDocumento sfd ) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT "
                    + "ID_Doc, "
                    + "ID_Funcao, "
                    + "CPF_Servidor "
                    + "FROM Servidor_Funcao_Documento "
                    + "WHERE ID_Doc=? AND CPF_Servidor=?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sfd.getIdDoc());
            stmt.setString(2, sfd.getCpfServidor());
            rs = stmt.executeQuery();

            while (rs.next()) {
                sfd.setIdDoc(rs.getInt("ID_Doc"));
                sfd.setIdFuncao(rs.getInt("CPF_Servidor"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return sfd;
    }

    
    public void update(ServidorFuncaoDocumento sfd) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE ServidorFuncaoDocumento SET "
                    + "CPF_Servidor=?"
                    + "WHERE ID_Doc=? AND ID_Funcao=?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, sfd.getCpfServidor());
            stmt.setInt(2, sfd.getIdDoc());
            stmt.setInt(3, sfd.getIdFuncao());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo atualizado com sucesso");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar o tipo " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    
    public void delete(ServidorFuncaoDocumento sfd) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            sfd = findByPrimaryKey(sfd);
            String sql = "DELETE FROM Servidor_Funcao_Documento "
                    + "WHERE ID_Doc=? AND ID_Funcao=?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, sfd.getIdDoc());
            stmt.setInt(2, sfd.getIdFuncao());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Ocorreu um erro ao deletar o registro" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

}
