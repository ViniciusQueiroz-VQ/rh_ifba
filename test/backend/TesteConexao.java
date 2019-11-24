package backend;

import control.connection.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class TesteConexao {

    public static void main(String[] args) {
        Connection conexao;
        try {
            conexao = ConnectionFactory.getConnection();
            JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso.\nPropriedades do objeto na memoria\n" + conexao.toString(),"Funcionou! P-A-R-A-B-E-N-S!",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar estabelecer conexão com o banco.\n"+ e.getMessage(),"Não consegue né moises ?", JOptionPane.ERROR_MESSAGE);
        }
    }
}
