package control.dao;
import control.connection.ConnectionFactory;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Documento;

public class DocumentoDAO {
    public DocumentoDAO() {
    }
    
    public void create(Documento documento) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            String sql = "INSERT INTO Documento("
                    + "Tamanho,"
                    + "Nome,"
                    + "Descricao,"
                    + "Data_Documento,"
                    + "ID_Numero,"
                    + "ID_Origem, "
                    + "Arquivo_Documento)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, documento.getTamanho());
            stmt.setString(2, documento.getNome());
            stmt.setString(3, documento.getDescricao());
            stmt.setString(4, documento.getDataDocumento());
            stmt.setInt(5, documento.getIdNumero());
            stmt.setInt(6, documento.getIdOrigem());
            stmt.setString(7, documento.getArquivoDocumento());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar o Documento: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    
    public ArrayList<Documento> readAll() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Documento> documentos = new ArrayList<>();

        try {
            String sql = "SELECT "
                    + "Tamanho,"
                    + "Nome,"
                    + "Data_Criacao, "
                    + "Descricao, "
                    + "Data_Documento, "
                    + "ID_Doc, "
                    + "ID_Numero, "
                    + "ID_Origem, "
                    + "Arquivo_Documento "
                    + "FROM Documento;";

            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDoc(rs.getLong("ID_Doc"));
                documento.setNome(rs.getString("Nome"));
                documento.setTamanho(rs.getString("Tamanho"));
                documento.setDataCriacao(rs.getString("Data_Criacao"));
                documento.setDescricao(rs.getString("Descricao"));
                documento.setDataDocumento(rs.getString("Data_Documento"));
                documento.setIdNumero(rs.getInt("ID_Numero"));
                documento.setIdOrigem(rs.getInt("ID_Origem"));
                documento.setArquivoDocumento(rs.getString("Arquivo_Documento"));
                documentos.add(documento);
            }
        } catch (SQLException ex) {
            System.err.println("Não foi possível consultar todos os documentos" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return documentos;
    }

    
    public Documento findByPrimaryKey(long idDoc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Documento documento = new Documento();

        try {
            String sql = "SELECT "
                    + "Tamanho,"
                    + "Nome,"
                    + "Data_Criacao, "
                    + "Descricao, "
                    + "Data_Documento, "
                    + "ID_Doc, "
                    + "ID_Numero, "
                    + "ID_Origem,"
                    + "Arquivo_Documento "
                    + "FROM Documento "
                    + "WHERE ID_Doc=?;";

            stmt = con.prepareStatement(sql);
            stmt.setLong(1, idDoc);
            rs = stmt.executeQuery();

            while (rs.next()) {
                documento.setIdDoc(rs.getLong("ID_Doc"));
                documento.setNome(rs.getString("Nome"));
                documento.setTamanho(rs.getString("Tamanho"));
                documento.setDataCriacao(rs.getString("Data_Criacao"));
                documento.setDescricao(rs.getString("Descricao"));
                documento.setDataDocumento(rs.getString("Data_Documento"));
                documento.setIdNumero(rs.getInt("ID_Numero"));
                documento.setIdOrigem(rs.getInt("ID_Origem"));
                documento.setArquivoDocumento(rs.getString("Arquivo_Documento"));
            }
        } catch (SQLException ex) {
            System.err.println("Não foi possível consultar o documento " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return documento;
    }

    
    public void update(Documento documento) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE Documento SET "
                    + "Tamanho=?, "
                    + "Nome=?, "
                    + "Descricao=?, "
                    + "Data_Documento=?, "
                    + "ID_Numero=?, "
                    + "ID_Origem=?, "
                    + "Arquivo_Documento"
                    + "WHERE ID_Doc=?;";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, documento.getTamanho());
            stmt.setString(2, documento.getNome());
            stmt.setString(3, documento.getDescricao());
            stmt.setString(4, documento.getDataDocumento());
            stmt.setInt(5, documento.getIdNumero());
            stmt.setInt(6, documento.getIdOrigem());
            stmt.setLong(7, documento.getIdDoc());
            stmt.setString(8, documento.getArquivoDocumento());
        } catch (SQLException ex) {
            System.err.println("Não foi possivel atualizar " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    
    public void delete(Documento documento) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        try {
            documento = (Documento) findByPrimaryKey(documento.getIdDoc());
            stmt = con.prepareStatement("DELETE FROM Documento WHERE ID_Doc = ?");
            stmt.setLong(1, documento.getIdDoc());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O Documento foi excluido com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o Documento" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

    public ArrayList<Documento> findByDate(String date) {
        //Busca por Data do Documento
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList documentos = new ArrayList<>();
        try {
            String sql = "SELECT "
                    + "Tamanho,"
                    + "Nome,"
                    + "Data_Criacao, "
                    + "Descricao, "
                    + "Data_Documento, "
                    + "ID_Doc, "
                    + "ID_Numero, "
                    + "ID_Origem,"
                    + "Arquivo_Documento "
                    + "FROM Documento"
                    + "WHERE Data_Documento=?;";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, date);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDoc(rs.getLong("ID_Doc"));
                documento.setTamanho(rs.getString("Tamanho"));
                documento.setDataCriacao(rs.getString("Data_Criacao"));
                documento.setDescricao(rs.getString("Descricao"));
                documento.setDataDocumento(rs.getString("Descricao"));
                documento.setIdNumero(rs.getInt("ID_Numero"));
                documento.setIdOrigem(rs.getInt("ID_Origem"));
                documento.setArquivoDocumento(rs.getString("Arquivo_Documento"));
                documentos.add(documento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível consultar o documento " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return documentos;
    }

    public ArrayList findByNomeDocumento(String name) {
        name = name.toUpperCase();
        //Busca pelo Nome do documento
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList documentos = new ArrayList<>();
        try {
            String sql = "SELECT "
                    + "Tamanho,"
                    + "Nome,"
                    + "Data_Criacao, "
                    + "Descricao, "
                    + "Data_Documento, "
                    + "ID_Doc, "
                    + "ID_Numero, "
                    + "ID_Origem, "
                    + "Arquivo_Documento "
                    + "FROM Documento"
                    + "WHERE Nome LIKE ?;";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDoc(rs.getLong("ID_Doc"));
                documento.setTamanho(rs.getString("Tamanho"));
                documento.setDataCriacao(rs.getString("Data_Criacao"));
                documento.setDescricao(rs.getString("Descricao"));
                documento.setDataDocumento(rs.getString("Descricao"));
                documento.setIdNumero(rs.getInt("ID_Numero"));
                documento.setIdOrigem(rs.getInt("ID_Origem"));
                documento.setArquivoDocumento(rs.getString("Arquivo_Documento"));
                documentos.add(documento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível consultar o documento " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return documentos;
    }

    public ArrayList findByNomeServidor(String name) {
        //Busca pelo nome do Servidor
        name = name.toUpperCase();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList documentos = new ArrayList<>();
        try {
            String sql = "SELECT ID_Doc, Nome, Tamanho, Data_Criacao, Descricao, Data_Documento, Arquivo_Documento, ID_Numero, ID_Origem, Arquivo_Documento"
                    + "FROM Documento "
                    + "WHERE ID_Doc IN "
                    + "(SELECT b.ID_Doc FROM Servidor as a "
                    + "JOIN Servidor_Funcao_Documento as b ON a.CPF_Servidor=b.CPF_Servidor\n"
                    + "	WHERE a.Nome LIKE ?);";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDoc(rs.getLong("ID_Doc"));
                documento.setTamanho(rs.getString("Tamanho"));
                documento.setDataCriacao(rs.getString("Data_Criacao"));
                documento.setDescricao(rs.getString("Descricao"));
                documento.setDataDocumento(rs.getString("Descricao"));
                documento.setIdNumero(rs.getInt("ID_Numero"));
                documento.setIdOrigem(rs.getInt("ID_Origem"));
                documento.setArquivoDocumento(rs.getString("Arquivo_Documento"));
                documentos.add(documento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível consultar o documento " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return documentos;
    }

    public ArrayList findByTipoOrigem(String tipo) {
        //Busca pelo tipo de Origem do Documento
        tipo = tipo.toUpperCase();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList documentos = new ArrayList<>();
        try {
            String sql = "SELECT a.Tamanho, a.Nome, a.Data_Criacao, a.Descricao, "
                    + "a.Data_Documento, a.Arquivo_Documento,a.ID_Doc, a.ID_Numero, "
                    + "a.ID_Origem , a.Arquivo_Documento "
                    + "FROM Documento a "
                    + "JOIN Local_Origem b ON a.ID_Origem = b.ID_OrigemAND b.Tipo LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Documento documento = new Documento();
                documento.setIdDoc(rs.getLong("ID_Doc"));
                documento.setTamanho(rs.getString("Tamanho"));
                documento.setDataCriacao(rs.getString("Data_Criacao"));
                documento.setDescricao(rs.getString("Descricao"));
                documento.setDataDocumento(rs.getString("Data_Documento"));
                documento.setIdNumero(rs.getInt("ID_Numero"));
                documento.setIdOrigem(rs.getInt("ID_Origem"));
                documento.setArquivoDocumento(rs.getString("Arquivo_Documento"));
                documentos.add(documento);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possível consultar o documento " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return documentos;

    }
}
