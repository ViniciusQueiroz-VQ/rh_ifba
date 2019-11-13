package control.dao;

import control.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcao;

public class FuncaoDAO implements CRUD {

    public FuncaoDAO() {
    }

    @Override
    public void create(Object o) {
        Funcao f = (Funcao) o;
        String nome = f.getNome();
        Funcao funcao = new Funcao(nome);
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        if (f.getIdFuncao() != 0) {
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

    @Override
    public ArrayList readAll() {
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

    @Override
    public Object findByPrimaryKey(Object pk) {
        Funcao f = (Funcao) pk;
        int idFuncao = f.getIdFuncao();
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

    @Override
    public void update(Object o) {
        Funcao funcao = (Funcao) o;
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

    @Override
    public void delete(Object o) {
        Funcao funcao = (Funcao) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            funcao = (Funcao) findByPrimaryKey(funcao.getIdFuncao());
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
