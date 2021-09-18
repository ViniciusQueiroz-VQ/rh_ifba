package control.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "teste1234";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "RH_IFBA";
    private static final String USE_TIMEZONE = "useTimezone=true";
    private static final String SERVER_TIMEZONE = "serverTimezone=UTC";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/"
            + DATABASE + "?" + USE_TIMEZONE + "&" + SERVER_TIMEZONE;

    private static final String ERRO_CLOSE_CONNECTION = "Erro ao encerrar a conexão com o banco de dados: ";
    private static final String GET_CONNECTION = "Erro ao estabelecer a conexão com o banco de dados: ";

    // DRIVER MYSQL (DRIVER - PORTA DE ENTRADA - USUARIO - SENHA)
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, GET_CONNECTION + ex.getErrorCode());
            return null;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, GET_CONNECTION + ex.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null)
                con.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ERRO_CLOSE_CONNECTION + ex.getErrorCode());
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null)
                stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ERRO_CLOSE_CONNECTION + ex.getErrorCode());
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) 
                rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ERRO_CLOSE_CONNECTION + ex.getErrorCode());
        }
    }

}
