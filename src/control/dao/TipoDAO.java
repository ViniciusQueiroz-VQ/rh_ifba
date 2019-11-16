package control.dao;

import control.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import model.Tipo;

public class TipoDAO {

    public TipoDAO() {
    }

    
    public void create(Tipo tipo) {
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

    
    public ArrayList<Tipo> readAll() {
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
    
    public ArrayList<Tipo> readAllName() {
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

    
    public Tipo findByPrimaryKey(int idNumero) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tipo tipo = new Tipo();
        try {
            String sql = "SELECT "
                    + "ID_Numero, "
                    + "Nome "
                    + "FROM Tipo "
                    + "WHERE ID_Numero=?;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idNumero);
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

    public ArrayList<Tipo> findByName(String name) {
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Tipo> tipos = new ArrayList<>();
        try {
            String sql = "SELECT "
                    + "ID_Numero, "
                    + "Nome "
                    + "FROM Tipo "
                    + "WHERE Nome LIKE '%"+name+"%'";
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            
            Tipo tipo;
            while (rs.next()) {
                tipo = new Tipo(rs.getInt("ID_Numero"),rs.getString("Nome"));
                tipos.add(tipo);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao pesquisar" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return tipos;
    }

    
    public void update(Tipo tipo) {
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

    
    public void delete(Tipo tipo) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            tipo = (Tipo) findByPrimaryKey(tipo.getIdNumero());
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
