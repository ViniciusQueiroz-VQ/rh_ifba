package control.dao;

import control.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import model.Tipo;

public class TipoDAO implements CRUD {

    public TipoDAO() {
    }

    @Override
    public void create(Object o) {
        Tipo tipo = (Tipo) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try {
            String sql = "INSERT INTO Tipo (Nome) VALUES(?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo.getNome());
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println("Não foi possível cadastrar a Tipo "
                    + ex.getMessage());
        }
    }

    @Override
    public ArrayList readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Tipo> tipos = new ArrayList<>();
        try {
            String sql = "SELECT ID_Numero, "
                    + "Nome "
                    + "FROM Tipo";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setIdNumero(rs.getInt("ID_Numero"));
                tipo.setNome(rs.getString("Nome"));
                tipos.add(tipo);
            }
            System.out.println("Consulta Finalizada com sucesso. \nNumero de "
                    + "Registros:" + tipos.size());

        } catch (SQLException ex) {
            System.err.println("Erro ao Consultar todos os Tipos:\n"
                    + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipos;
    }
    public ArrayList readAllName() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Tipo> tipos = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT Nome FROM Tipo";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setNome(rs.getString("Nome"));
                tipos.add(tipo);
            }
            System.out.println("Consulta Finalizada com sucesso. \nNumero de "
                    + "Registros:" + tipos.size());

        } catch (SQLException ex) {
            System.err.println("Erro ao Consultar todos os Tipos:\n"
                    + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipos;
    }

    @Override
    public Object findByPrimaryKey(Object o) {
        Tipo tipo = (Tipo) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT "
                    + "ID_Numero, "
                    + "Nome "
                    + "FROM Tipo "
                    + "WHERE ID_Numero=?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipo.getIdNumero());
            rs = stmt.executeQuery();

            while (rs.next()) {
                tipo.setIdNumero(rs.getInt("ID_Numero"));
                tipo.setNome(rs.getString("Nome"));
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao pesquisar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return tipo;
    }

    public Object findByName(Object k) {
        String nome = (String) k;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tipo tipo = null;
        try {
            String sql = "SELECT "
                    + "ID_Numero, "
                    + "Nome "
                    + "FROM Tipo "
                    + "WHERE Nome LIKE ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            tipo = new Tipo();
            
            while (rs.next()) {
                tipo.setIdNumero(rs.getInt("ID_Numero"));
                tipo.setNome(rs.getString("Nome"));
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao pesquisar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return tipo;
    }

    @Override
    public void update(Object o) {
        Tipo tipo = (Tipo) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE Tipo SET Nome=? "
                    + "WHERE ID_Numero=?";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, tipo.getNome());
            stmt.setInt(2, tipo.getIdNumero());
            stmt.executeUpdate();

            System.out.println("Tipo atualizado com sucesso");
        } catch (SQLException ex) {

            System.err.println("Erro ao atualizar o tipo" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void delete(Object o) {
        Tipo tipo = (Tipo) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            tipo = (Tipo) findByPrimaryKey(tipo);
            String sql = "DELETE FROM Tipo WHERE ID_Numero=?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipo.getIdNumero());
            stmt.executeUpdate();
            System.out.println("Deletado com sucesso");

        } catch (SQLException ex) {
            System.err.println("Erro ao deletar o tipo" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

}
