package control.dao;

import control.connection.ConnectionFactory;
import java.util.ArrayList;
import model.LocalOrigem;
import java.sql.*;

public class LocalOrigemDAO implements CRUD {

    public LocalOrigemDAO() {
    }

    @Override
    public void create(Object o) {
        LocalOrigem localOrigem = (LocalOrigem) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            String sql = "INSERT INTO LocalOrigem (Nome, Tipo, Descricao) VALUES(?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, localOrigem.getNome());
            stmt.setString(2, localOrigem.getTipo());
            stmt.setString(3, localOrigem.getDescricao());
            stmt.execute();
        } catch (SQLException ex) {
            System.err.println("Não foi possível cadastrar o Local Origem "
                    + ex.getMessage());
        }
    }

    @Override
    public ArrayList readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<LocalOrigem> locaisOrigem = new ArrayList<>();
        try {
            String sql = "SELECT ID_Origem, "
                    + "Nome, "
                    + "Tipo, "
                    + "Descricao "
                    + "FROM Local_Origem";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LocalOrigem localOrigem = new LocalOrigem();
                localOrigem.setIdOrigem(rs.getInt("ID_Origem"));
                localOrigem.setNome(rs.getString("Nome"));
                localOrigem.setTipo(rs.getString("Tipo"));
                localOrigem.setDescricao(rs.getString("Descricao"));
                locaisOrigem.add(localOrigem);
            }
            System.out.println("Consulta Finalizada com sucesso. \nNumero de "
                    + "Registros:" + locaisOrigem.size());

        } catch (SQLException ex) {
            System.err.println("Erro ao Consultar todos os Tipos:\n"
                    + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return locaisOrigem;
    }
    
     public ArrayList readAllName() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<LocalOrigem> locaisOrigem = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT Nome FROM Local_Origem";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LocalOrigem localOrigem = new LocalOrigem();
                localOrigem.setNome(rs.getString("Nome"));
                locaisOrigem.add(localOrigem);
            }
            System.out.println("Consulta Finalizada com sucesso. \nNumero de "
                    + "Registros:" + locaisOrigem.size());

        } catch (SQLException ex) {
            System.err.println("Erro ao Consultar todos os Tipos:\n"
                    + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return locaisOrigem;
    }

    @Override
    public Object findByPrimaryKey(Object pk) {
        LocalOrigem localOrigem = (LocalOrigem) pk;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT "
                    + "ID_Origem, "
                    + "Nome, "
                    + "Tipo, "
                    + "Descricao "
                    + "FROM Local_Origem "
                    + "WHERE ID_Origem LIKE ?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, localOrigem.getIdOrigem());
            rs = stmt.executeQuery();

            while (rs.next()) {
                localOrigem.setIdOrigem(rs.getInt("ID_Origem"));
                localOrigem.setNome(rs.getString("Nome"));
                localOrigem.setTipo(rs.getString("Tipo"));
                localOrigem.setDescricao(rs.getString("Descricao"));
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao pesquisar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return localOrigem;
    }

    public Object findByName(Object k) {
        LocalOrigem localOrigem = (LocalOrigem) k;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT ID_Origem, "
                    + "Nome, "
                    + "Tipo, "
                    + "Descricao "
                    + "FROM Local_Origem "
                    + "WHERE Nome LIKE ?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, localOrigem.getNome());
            rs = stmt.executeQuery();

            while (rs.next()) {
                localOrigem.setIdOrigem(rs.getInt("ID_Origem"));
                localOrigem.setNome(rs.getString("Nome"));
                localOrigem.setTipo(rs.getString("Tipo"));
                localOrigem.setDescricao(rs.getString("Descricao"));
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao pesquisar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return localOrigem;
    }

    @Override
    public void update(Object o) {
        LocalOrigem localOrigem = (LocalOrigem) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE Local_Origem SET "
                    + "Nome=?, "
                    + "Tipo=?, "
                    + "Descricao=? "
                    + "WHERE ID_Origem=? ";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, localOrigem.getNome());
            stmt.setString(2, localOrigem.getTipo());
            stmt.setString(3, localOrigem.getDescricao());
            stmt.setInt(4, localOrigem.getIdOrigem());
            stmt.executeUpdate();

            System.out.println("Tipo atualizado com sucesso");
        } catch (SQLException ex) {

            System.err.println("Erro ao atualizar o Local de Origem" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void delete(Object o) {
        LocalOrigem localOrigem = (LocalOrigem) o;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            localOrigem = (LocalOrigem) findByPrimaryKey(localOrigem);
            String sql = "DELETE FROM Local_Origem WHERE ID_Origem=?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, localOrigem.getIdOrigem());
            stmt.executeUpdate();

            System.out.println("Deletado com sucesso");

        } catch (SQLException ex) {
            System.err.println("Erro ao deletar o Local de Origem" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }
}
