package view;

import control.dao.FuncionarioDIREHDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioDIREH;

public class FuncionarioView extends javax.swing.JFrame {

    private static ArrayList<FuncionarioDIREH> funcionarios = new ArrayList<>();

    public FuncionarioView() {
        initComponents();
        setLocationRelativeTo(null);//Centralizando Janela
        loadTable();
        comboboxPesquisa.setEnabled(false);
        campoPesquisa.setEnabled(comboboxPesquisa.isEnabled());
        botaoCancelar.setEnabled(comboboxPesquisa.isEnabled());
        botaoConfirmarPesquisa.setEnabled(comboboxPesquisa.isEnabled());
        
    }

    //carregar a tabela com dados do banco
    public void loadTable() {

        DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionarios.getModel();
        modelo.setNumRows(0);//remove as linhas existentes para evitar duplicatas
        FuncionarioDIREHDAO dao = new FuncionarioDIREHDAO();// Acesso ao Banco

        //Guardar os dados dos funcionarios em um vetor
        funcionarios = (ArrayList<FuncionarioDIREH>) dao.readAll();

        // pesquisando os funcionarios e adcionandos na tabela
        // for funcional... pode ser substituido pelo convencional
        funcionarios.forEach((funcionario) -> {
            modelo.addRow(new Object[]{
                funcionario.getCpf(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getCargo(),
                funcionario.getTelefoneFixo(),
                funcionario.getTelefoneMovel(),
                funcionario.getHorarioEntrada(),
                funcionario.getHorarioSaida(),
                funcionario.getLogin()
            });
        });
        //tentativa de inserir uma rolagem lateral devido ao numero alto de atributos
        tabelaFuncionarios.setAutoResizeMode(tabelaFuncionarios.AUTO_RESIZE_OFF);
    }

    //carregar a tabela com dados do banco
    public void loadTable(ArrayList<FuncionarioDIREH> funcionarios) {

        DefaultTableModel modelo = (DefaultTableModel) tabelaFuncionarios.getModel();
        modelo.setNumRows(0);//remove as linhas existentes para evitar duplicatas
        FuncionarioDIREHDAO dao = new FuncionarioDIREHDAO();// Acesso ao Banco

        //Guardar os dados dos funcionarios em um vetor
        // pesquisando os funcionarios e adcionandos na tabela
        // for funcional... pode ser substituido pelo convencional
        funcionarios.forEach((funcionario) -> {
            modelo.addRow(new Object[]{
                funcionario.getCpf(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getCargo(),
                funcionario.getTelefoneFixo(),
                funcionario.getTelefoneMovel(),
                funcionario.getHorarioEntrada(),
                funcionario.getHorarioSaida(),
                funcionario.getLogin()
            });
        });
        //tentativa de inserir uma rolagem lateral devido ao numero alto de atributos
        tabelaFuncionarios.setAutoResizeMode(tabelaFuncionarios.AUTO_RESIZE_OFF);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFuncionario = new javax.swing.JPanel();
        botaoCadastrar = new javax.swing.JButton();
        botaoPesquisar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        campoPesquisa = new javax.swing.JTextField();
        botaoExcluir = new javax.swing.JButton();
        labelTipoDePesquisa = new javax.swing.JLabel();
        scrollPaneTabela = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        botaoConfirmarPesquisa = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        comboboxPesquisa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(720, 480));

        painelFuncionario.setPreferredSize(new java.awt.Dimension(720, 503));
        painelFuncionario.setRequestFocusEnabled(false);

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        labelTipoDePesquisa.setText("Tipo de Pesquisa");

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Email", "Cargo", "Telefone Fixo", "Telefone Movel", "Horario de Entrada", "Horario de Saida", "Login"
            }
        ));
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        scrollPaneTabela.setViewportView(tabelaFuncionarios);

        botaoConfirmarPesquisa.setText("Pesquisar");
        botaoConfirmarPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarPesquisaActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        comboboxPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "CPF", "Nome" }));

        javax.swing.GroupLayout painelFuncionarioLayout = new javax.swing.GroupLayout(painelFuncionario);
        painelFuncionario.setLayout(painelFuncionarioLayout);
        painelFuncionarioLayout.setHorizontalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneTabela)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFuncionarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(botaoConfirmarPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFuncionarioLayout.createSequentialGroup()
                        .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(botaoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                                .addComponent(labelTipoDePesquisa)
                                .addGap(54, 54, 54)
                                .addComponent(comboboxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                                .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                                .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(257, 257, 257)))))
                .addContainerGap())
        );
        painelFuncionarioLayout.setVerticalGroup(
            painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoPesquisar)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoAtualizar)
                    .addComponent(botaoExcluir))
                .addGap(37, 37, 37)
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipoDePesquisa))
                .addGap(86, 86, 86)
                .addGroup(painelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmarPesquisa)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoVoltar))
                .addGap(0, 37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        //Criando e Visualizando janela sobreposta (POPUP)
        FuncionarioViewCadastro cadastro = new FuncionarioViewCadastro(this, true);
        cadastro.setVisible(true);
        loadTable();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        //Criando e Visualizando janela sobreposta (POPUP)
        if (tabelaFuncionarios.getSelectedRow() != -1) {
            FuncionarioDIREH funcionario = new FuncionarioDIREH();
            funcionario.setCpf((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 0));
            FuncionarioDIREHDAO fdao = new FuncionarioDIREHDAO();
            funcionario = fdao.findByPrimaryKey(funcionario.getCpf());

            FuncionarioViewAtualizar atualizar = new FuncionarioViewAtualizar(this, true);
            atualizar.enviarDados(funcionario);
            atualizar.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um funcionario antes");
        }
        loadTable();//recarregar a tabela
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        JOptionPane.showMessageDialog(null, "");
        if (tabelaFuncionarios.getSelectedRow() > -1) {
            FuncionarioDIREH funcionario = new FuncionarioDIREH();
            funcionario.setCpf((String) tabelaFuncionarios.getValueAt(tabelaFuncionarios.getSelectedRow(), 0));
            FuncionarioDIREHDAO fdao = new FuncionarioDIREHDAO();
            fdao.delete(funcionario);
            loadTable();//recarregar a tabela
        } else {
            System.out.println("Selecione um funcionario antes");
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoConfirmarPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarPesquisaActionPerformed

        FuncionarioDIREHDAO dao = new FuncionarioDIREHDAO();
        FuncionarioDIREH funcionario;
        String pesquisa = (String) comboboxPesquisa.getSelectedItem();
        funcionarios = new ArrayList<>();
        switch (pesquisa) {
            case "CPF":
                funcionario = dao.findByPrimaryKey(campoPesquisa.getText());
                funcionarios.add(funcionario);
                break;
            case "Nome":
                funcionarios = dao.findByName(campoPesquisa.getText());
                break;

            default:
                JOptionPane.showMessageDialog(null, "Selecione uma opção!");
        }
        if (funcionarios.isEmpty()) {
            loadTable();
        } else {
            loadTable(funcionarios);
        }
    }//GEN-LAST:event_botaoConfirmarPesquisaActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed

        botaoCancelar.setEnabled(true);
        botaoConfirmarPesquisa.setEnabled(botaoCancelar.isEnabled());
        botaoCadastrar.setEnabled(false);
        botaoAtualizar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        campoPesquisa.setEnabled(true);
        comboboxPesquisa.setEnabled(true);
        botaoPesquisar.setEnabled(false);

    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        botaoPesquisar.setEnabled(true);
        botaoCadastrar.setEnabled(true);
        botaoAtualizar.setEnabled(true);
        botaoExcluir.setEnabled(true);
        campoPesquisa.setEnabled(false);
        comboboxPesquisa.setEnabled(false);
        campoPesquisa.setText("");
        botaoCancelar.setEnabled(false);
        botaoConfirmarPesquisa.setEnabled(botaoCancelar.isEnabled());
        loadTable();

    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        botaoAtualizar.setEnabled(true);
        botaoExcluir.setEnabled(true);
    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    public static void main(String args[]) {
        //Aplicação de Tema GTK+
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Erro ao tentar usar o tema GTK+ " + ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmarPesquisa;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JComboBox<String> comboboxPesquisa;
    private javax.swing.JLabel labelTipoDePesquisa;
    private javax.swing.JPanel painelFuncionario;
    private javax.swing.JScrollPane scrollPaneTabela;
    private javax.swing.JTable tabelaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
