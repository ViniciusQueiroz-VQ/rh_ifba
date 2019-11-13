package view;

import control.dao.DocumentoDAO;
import control.dao.LocalOrigemDAO;
import control.dao.TipoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Documento;
import model.Tipo;
import model.LocalOrigem;

public class DocumentoView extends javax.swing.JFrame {

    private static ArrayList<Documento> documentos = null;

    private static ArrayList<Tipo> tipos = new ArrayList<>();

    private static ArrayList<LocalOrigem> locais = new ArrayList<>();

    SeletorArquivoView seletorArquivo = new SeletorArquivoView(this, true);

    public DocumentoView() {
        initComponents();
        setLocationRelativeTo(null);
        loadTable(documentos);
        habilitarFormulario(false);

    }

    public void habilitarFormulario(boolean habilitado) {
        campoDataDocumento.setEnabled(habilitado);
        campoDescricaoDocumento.setEnabled(habilitado);
        campoNomeDocumento.setEnabled(habilitado);
        botaoArquivo.setEnabled(habilitado);
        comboBoxLocalOrigem.setEnabled(habilitado);
        comboBoxPesquisaDocumento.setEnabled(!habilitado);//Inverso
        comboBoxTipo.setEnabled(habilitado);
        comboBoxTipoOrigem.setEnabled(habilitado);
        botaoSalvar.setEnabled(habilitado);
        botaoCancelar.setEnabled(habilitado);
    }

    public void limparCampos() {
        campoNomeDocumento.setText("");
        campoDescricaoDocumento.setText("");
        campoDataDocumento.setText("");
        comboBoxLocalOrigem.setSelectedIndex(0);
        comboBoxTipo.setSelectedIndex(0);
        comboBoxTipoOrigem.setSelectedIndex(0);
        labelIdDocumento.setText("");
    }

    public void loadTable(ArrayList lista) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaDocumentos.getModel();
        modelo.setNumRows(0);//remove as linhas existentes para evitar duplicatas
        DocumentoDAO dao = new DocumentoDAO();// Acesso ao Banco
        //Guardar os dados dos funcionarios em um vetor
        if (lista == null) {
            documentos = (ArrayList<Documento>) dao.readAll();
        }

        // pesquisando os funcionarios e adcionandos na tabela
        // for funcional... pode ser substituido pelo convencional
        documentos.forEach((documento) -> {
            modelo.addRow(new Object[]{
                documento.getIdDoc(),
                documento.getNome(),
                documento.getDescricao(),
                documento.getTamanho(),
                documento.getDataCriacao(),
                documento.getDataDocumento(),
                documento.getArquivoDocumento(), //documento.getIdNumero(),
            //documento.getIdOrigem()
            });
        });
        //tentativa de inserir uma rolagem lateral devido ao numero alto de atributos
        tabelaDocumentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        LocalOrigemDAO localDAO = new LocalOrigemDAO();
        TipoDAO tipoDAO = new TipoDAO();

        locais = (ArrayList<LocalOrigem>) localDAO.readAllName();

        comboBoxLocalOrigem.removeAllItems();
        comboBoxLocalOrigem.addItem("Selecione um local");
        for (LocalOrigem local : locais) {
            comboBoxLocalOrigem.addItem(local.getNome());
        }

        tipos = (ArrayList<Tipo>) tipoDAO.readAllName();
        comboBoxTipo.removeAllItems();
        comboBoxTipo.addItem("Selecione um tipo");
        for (Tipo tipo : tipos) {
            comboBoxTipo.addItem(tipo.getNome());
        }

    }

    public void loadTable() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaDocumentos.getModel();
        modelo.setNumRows(0);//remove as linhas existentes para evitar duplicatas
        DocumentoDAO dao = new DocumentoDAO();// Acesso ao Banco
        //Guardar os dados dos funcionarios em um vetor

        documentos = (ArrayList<Documento>) dao.readAll();

        // pesquisando os funcionarios e adcionandos na tabela
        // for funcional... pode ser substituido pelo convencional
        documentos.forEach((documento) -> {
            modelo.addRow(new Object[]{
                documento.getIdDoc(),
                documento.getNome(),
                documento.getDescricao(),
                documento.getTamanho(),
                documento.getDataCriacao(),
                documento.getDataDocumento(),
                documento.getArquivoDocumento(), //documento.getIdNumero(),
            //documento.getIdOrigem()
            });
        });
        //tentativa de inserir uma rolagem lateral devido ao numero alto de atributos
        tabelaDocumentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        LocalOrigemDAO localDAO = new LocalOrigemDAO();
        TipoDAO tipoDAO = new TipoDAO();

        locais = (ArrayList<LocalOrigem>) localDAO.readAllName();

        comboBoxLocalOrigem.removeAllItems();
        comboBoxLocalOrigem.addItem("Selecione um local");
        for (LocalOrigem local : locais) {
            comboBoxLocalOrigem.addItem(local.getNome());
        }

        tipos = (ArrayList<Tipo>) tipoDAO.readAllName();
        comboBoxTipo.removeAllItems();
        comboBoxTipo.addItem("Selecione um tipo");
        for (Tipo tipo : tipos) {
            comboBoxTipo.addItem(tipo.getNome());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDocumentoFuncoes = new javax.swing.JPanel();
        botaoTelaCadastrar = new javax.swing.JButton();
        botaoTelaPesquisar = new javax.swing.JButton();
        botaoTelaAtualizar = new javax.swing.JButton();
        campoPesquisaDocumento = new javax.swing.JTextField();
        botaoTelaExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDocumentos = new javax.swing.JTable();
        comboBoxPesquisaDocumento = new javax.swing.JComboBox<>();
        painelDocumentoFormulario = new javax.swing.JPanel();
        campoNomeDocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        campoDescricaoDocumento = new javax.swing.JTextArea();
        comboBoxTipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboBoxLocalOrigem = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        campoDataDocumento = new javax.swing.JTextField();
        botaoArquivo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        comboBoxTipoOrigem = new javax.swing.JComboBox<>();
        labelIdDocumento = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(940, 515));
        setSize(new java.awt.Dimension(940, 515));

        painelDocumentoFuncoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelDocumentoFuncoes.setPreferredSize(new java.awt.Dimension(720, 503));
        painelDocumentoFuncoes.setRequestFocusEnabled(false);

        botaoTelaCadastrar.setText("Cadastrar");
        botaoTelaCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTelaCadastrarActionPerformed(evt);
            }
        });

        botaoTelaPesquisar.setText("Pesquisar");
        botaoTelaPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTelaPesquisarActionPerformed(evt);
            }
        });

        botaoTelaAtualizar.setText("Atualizar");
        botaoTelaAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTelaAtualizarActionPerformed(evt);
            }
        });

        botaoTelaExcluir.setText("Excluir");
        botaoTelaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTelaExcluirActionPerformed(evt);
            }
        });

        tabelaDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descricao", "Tamanho", "Data Criacao", "Data Documento", "Arquivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDocumentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaDocumentos);

        comboBoxPesquisaDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opcao", "Nome do Documento", "Nome do Servidor", "Data do Documento", "Tipo de Origem" }));

        javax.swing.GroupLayout painelDocumentoFuncoesLayout = new javax.swing.GroupLayout(painelDocumentoFuncoes);
        painelDocumentoFuncoes.setLayout(painelDocumentoFuncoesLayout);
        painelDocumentoFuncoesLayout.setHorizontalGroup(
            painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDocumentoFuncoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDocumentoFuncoesLayout.createSequentialGroup()
                        .addGroup(painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxPesquisaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoTelaCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPesquisaDocumento)
                            .addComponent(botaoTelaAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoTelaPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(botaoTelaExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(212, 212, 212))
        );
        painelDocumentoFuncoesLayout.setVerticalGroup(
            painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDocumentoFuncoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPesquisaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPesquisaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoTelaPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDocumentoFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoTelaCadastrar)
                    .addComponent(botaoTelaAtualizar)
                    .addComponent(botaoTelaExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        painelDocumentoFormulario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome");

        jLabel5.setText("Tipo");

        jLabel8.setText("Descrição");

        campoDescricaoDocumento.setColumns(20);
        campoDescricaoDocumento.setRows(5);
        jScrollPane3.setViewportView(campoDescricaoDocumento);

        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo", "Portaria", "Teste", "Resolucao", "Item 4" }));

        jLabel9.setText("Local de Origem");

        comboBoxLocalOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um local", "IFBA", "Echos" }));
        comboBoxLocalOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxLocalOrigemActionPerformed(evt);
            }
        });

        jLabel10.setText("Data Documento");

        campoDataDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        botaoArquivo.setText("Arquivo");
        botaoArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo de Origem");

        comboBoxTipoOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um tipo de origem", "Externo", "Interno" }));

        jLabel3.setText("ID do Documento");

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDocumentoFormularioLayout = new javax.swing.GroupLayout(painelDocumentoFormulario);
        painelDocumentoFormulario.setLayout(painelDocumentoFormularioLayout);
        painelDocumentoFormularioLayout.setHorizontalGroup(
            painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                        .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11))))
                            .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(24, 24, 24)
                        .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                                .addComponent(labelIdDocumento)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoNomeDocumento)
                            .addComponent(jScrollPane3)
                            .addComponent(comboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxLocalOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxTipoOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDocumentoFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataDocumento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        painelDocumentoFormularioLayout.setVerticalGroup(
            painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                        .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdDocumento)
                            .addComponent(jLabel3))
                        .addGap(4, 4, 4)
                        .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoNomeDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDocumentoFormularioLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxLocalOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboBoxTipoOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoArquivo)
                    .addComponent(jLabel10)
                    .addComponent(campoDataDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDocumentoFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        botaoVoltar1.setText("Voltar");
        botaoVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoVoltar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelDocumentoFuncoes, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelDocumentoFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelDocumentoFuncoes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(painelDocumentoFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoTelaAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTelaAtualizarActionPerformed

        if (tabelaDocumentos.getSelectedRow() != -1) {
            habilitarFormulario(true);
            Documento documento = new Documento();
            documento.setIdDoc((Long) tabelaDocumentos.getValueAt(tabelaDocumentos.getSelectedRow(), 0));
            DocumentoDAO dao = new DocumentoDAO();
            documento = (Documento) dao.findByPrimaryKey(documento);
            campoNomeDocumento.setText(documento.getNome());
            campoDataDocumento.setText(documento.getDataDocumento());
            campoDescricaoDocumento.setText(documento.getDescricao());

            TipoDAO tipoDao = new TipoDAO();
            Tipo tipo = new Tipo();
            tipo.setIdNumero(documento.getIdNumero());
            tipo = (Tipo) tipoDao.findByPrimaryKey(tipo);
            comboBoxTipo.setSelectedItem(tipo.getNome());

            LocalOrigemDAO origemDao = new LocalOrigemDAO();
            LocalOrigem local = new LocalOrigem();
            local.setIdOrigem(documento.getIdOrigem());
            local = (LocalOrigem) origemDao.findByPrimaryKey(local);
            comboBoxLocalOrigem.setSelectedItem(local.getNome());
            comboBoxTipoOrigem.setSelectedItem(local.getTipo());

            labelIdDocumento.setText(String.valueOf(documento.getIdDoc()));
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um documento na tabela");
            habilitarFormulario(false);
        }

    }//GEN-LAST:event_botaoTelaAtualizarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        boolean validado = true;
        Documento documento = new Documento();

        if (campoNomeDocumento.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(null, "O nome do documento está vazio");
        }

        if (campoDescricaoDocumento.getText().isEmpty()) {
            validado = false;
            JOptionPane.showMessageDialog(null, "A descricao do documento está vazia");
        }

        if (comboBoxTipo.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(null, "É necessário selecionar um Tipo de Documento");
        }

        if (comboBoxLocalOrigem.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(null, "É necessário selecionar um Local de Origem");
        }

        if (comboBoxTipoOrigem.getSelectedIndex() == 0) {
            validado = false;
            JOptionPane.showMessageDialog(null, "É necessário selecionar um Tipo de Origem");
        }
        try {
            if (SeletorArquivoView.arquivo == null || SeletorArquivoView.arquivo[0].isEmpty() || SeletorArquivoView.arquivo[1].isEmpty()) {
                validado = false;
                JOptionPane.showMessageDialog(null, "É necessário selecionar um Arquivo");
            }
        } catch (Exception e) {
            validado = false;
            JOptionPane.showMessageDialog(null, "É necessário selecionar um Arquivo");
        }

        if (validado) {
            documento.setNome(campoNomeDocumento.getText());
            documento.setDataDocumento(campoDataDocumento.getText());
            documento.setDescricao(campoDescricaoDocumento.getText());

            //Relacionamento Tipo
            TipoDAO daoTipo = new TipoDAO();
            String nomeTipo = (String) comboBoxTipo.getSelectedItem();
            Tipo tipo = (Tipo) daoTipo.findByName(nomeTipo);

            documento.setIdNumero(tipo.getIdNumero());

            //Relacionamento Local_Origem
            LocalOrigemDAO daoLocal = new LocalOrigemDAO();

            LocalOrigem local = new LocalOrigem();
            local.setNome((String) comboBoxLocalOrigem.getSelectedItem());
            local = (LocalOrigem) daoLocal.findByName(local);
            local.setTipo((String) comboBoxTipoOrigem.getSelectedItem());

            daoLocal.update(local); //Atualização

            documento.setIdOrigem(local.getIdOrigem());

            //Cadastramento do Documento
            documento.setArquivoDocumento(SeletorArquivoView.arquivo[0]);
            documento.setTamanho(SeletorArquivoView.arquivo[1]);

            DocumentoDAO daoDocumento = new DocumentoDAO();
            if (documento.getIdDoc() == 0) {
                daoDocumento.create(documento);
            } else {
                daoDocumento.update(documento);
            }

            loadTable(documentos);//Recarregar tabela
        } else {
            loadTable();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        seletorArquivo = new SeletorArquivoView(this, true);
        seletorArquivo.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        limparCampos();
        habilitarFormulario(false);
        botaoTelaCadastrar.setEnabled(true);
        botaoTelaAtualizar.setEnabled(true);
        botaoTelaExcluir.setEnabled(true);
        botaoTelaPesquisar.setEnabled(true);
        campoPesquisaDocumento.setEnabled(true);
        comboBoxPesquisaDocumento.setEnabled(true);
        labelIdDocumento.setText("");

    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltar1ActionPerformed

    private void botaoTelaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTelaExcluirActionPerformed
        if (tabelaDocumentos.getSelectedRow() != -1) {
            Documento documento = new Documento();
            documento.setIdDoc((Long) tabelaDocumentos.getValueAt(tabelaDocumentos.getSelectedRow(), 0));
            DocumentoDAO dao = new DocumentoDAO();
            documento = (Documento) dao.findByPrimaryKey(documento);
            dao.delete(documento);

        } else {
            JOptionPane.showMessageDialog(null, "É necessario selecionar um documento da tabela");
        }
        loadTable(null);
    }//GEN-LAST:event_botaoTelaExcluirActionPerformed

    private void botaoTelaCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTelaCadastrarActionPerformed
        habilitarFormulario(true);
        botaoTelaCadastrar.setEnabled(false);
        botaoTelaAtualizar.setEnabled(false);
        botaoTelaExcluir.setEnabled(false);
        botaoTelaPesquisar.setEnabled(false);
        campoPesquisaDocumento.setEnabled(false);
        comboBoxPesquisaDocumento.setEnabled(false);
    }//GEN-LAST:event_botaoTelaCadastrarActionPerformed

    private void botaoTelaPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTelaPesquisarActionPerformed
        String pesquisa = campoPesquisaDocumento.getText();
        String funcao = (String) comboBoxPesquisaDocumento.getSelectedItem();
        DocumentoDAO dao = new DocumentoDAO();

        switch (funcao) {
            case "Nome do documento":
                documentos = (ArrayList<Documento>) dao.findByNomeDocumento(pesquisa);

                break;
            case "Nome do Servidor":
                documentos = (ArrayList<Documento>) dao.findByNomeServidor(pesquisa);

                break;
            case "Data do Documento":
                documentos = (ArrayList<Documento>) dao.findByDate(pesquisa);
                break;
            case "Tipo de Origem":
                documentos = (ArrayList<Documento>) dao.findByTipoOrigem(pesquisa);
                break;
            case "Selecione uma opcao":
                documentos = (ArrayList<Documento>) dao.readAll();
            default:
                documentos = null;
        }
        DefaultTableModel modelo = (DefaultTableModel) tabelaDocumentos.getModel();
        modelo.setNumRows(0);
        loadTable(documentos);
    }//GEN-LAST:event_botaoTelaPesquisarActionPerformed

    private void comboBoxLocalOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLocalOrigemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxLocalOrigemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoArquivo;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoTelaAtualizar;
    private javax.swing.JButton botaoTelaCadastrar;
    private javax.swing.JButton botaoTelaExcluir;
    private javax.swing.JButton botaoTelaPesquisar;
    private javax.swing.JButton botaoVoltar1;
    private javax.swing.JTextField campoDataDocumento;
    private javax.swing.JTextArea campoDescricaoDocumento;
    private javax.swing.JTextField campoNomeDocumento;
    private javax.swing.JTextField campoPesquisaDocumento;
    private javax.swing.JComboBox<String> comboBoxLocalOrigem;
    private javax.swing.JComboBox<String> comboBoxPesquisaDocumento;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JComboBox<String> comboBoxTipoOrigem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelIdDocumento;
    private javax.swing.JPanel painelDocumentoFormulario;
    private javax.swing.JPanel painelDocumentoFuncoes;
    private javax.swing.JTable tabelaDocumentos;
    // End of variables declaration//GEN-END:variables

}
