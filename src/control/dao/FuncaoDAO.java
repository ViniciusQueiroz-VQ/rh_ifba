package control.dao;

import control.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcao;

public class FuncaoDAO {

    public FuncaoDAO() {
    }

    public void create(Funcao funcao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        if (funcao.getIdFuncao() != 0) {
            try {
                String sql = "INSERT INTO Funcao (Nome) VALUES(?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, funcao.getNome());
                stmt.execute();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a Função "
                        + ex.getMessage());
            }
        }
    }

    
    public ArrayList<Funcao> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Funcao> funcoes = new ArrayList<>();
        try {
            String sql = "SELECT ID_Funcao,"
                    + "Nome "
                    + "FROM Funcao";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Funcao funcao = new Funcao();

                funcao.setIdFuncao(rs.getInt("ID_Funcao"));
                funcao.setNome(rs.getString("Nome"));
                funcoes.add(funcao);
            }
            System.out.println("Consulta Finalizada com sucesso. \nNumero de "
                    + "Registros:" + funcoes.size());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar todos as Funções:\n"
                    + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcoes;
    }

    
    public Funcao findByPrimaryKey(int idFuncao) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcao funcao = new Funcao();
        try {
            String sql = "SELECT "
                    + "ID_Funcao,"
                    + "Nome  "
                    + "FROM Funcao "
                    + "WHERE ID_Funcao=?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idFuncao);
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcao.setIdFuncao(rs.getInt("ID_Funcao"));
                funcao.setNome(rs.getString("Nome"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return funcao;
    }

    
    public void update(Funcao funcao) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE Funcao SET "
                    + "Nome=? "
                    + "WHERE ID_Funcao=?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, funcao.getNome());
            stmt.setInt(2, funcao.getIdFuncao());
            stmt.executeUpdate();

            System.out.println("Funcao atualizada com sucesso");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar a Funcao" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    
    public void delete(Funcao funcao) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            funcao = findByPrimaryKey(funcao.getIdFuncao());
            String sql = "DELETE FROM Funcao WHERE ID_Funcao=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcao.getIdFuncao());
            stmt.executeUpdate();
            System.out.println("Deletado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar a funcao" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

}
