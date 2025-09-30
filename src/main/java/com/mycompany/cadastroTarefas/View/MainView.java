package com.mycompany.cadastroTarefas.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class MainView extends JFrame {

    private JTextField campoTitulo, campoDeadline;
    private JTextArea campoDescricao;
    private JComboBox<String> comboResponsavel, comboPrioridade;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    public MainView() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastrar Tarefa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Painel de cadastro
        JPanel painelCadastro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        campoTitulo = new JTextField(25);
        campoDescricao = new JTextArea(5, 25);
        campoDescricao.setLineWrap(true);
        campoDescricao.setWrapStyleWord(true);
        JScrollPane scrollDescricao = new JScrollPane(campoDescricao);

        comboResponsavel = new JComboBox<>(new String[]{"Selecione", "Maria", "João", "Ana"});
        comboPrioridade = new JComboBox<>(new String[]{"Selecione", "Baixa", "Média", "Alta"});

        campoDeadline = new JTextField(10);
        JButton btnSalvar = new JButton("Cadastrar");

        // Linha 1 - Título
        gbc.gridx = 0; gbc.gridy = 0;
        painelCadastro.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(campoTitulo, gbc);

        // Linha 2 - Descrição
        gbc.gridx = 0; gbc.gridy++;
        painelCadastro.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(scrollDescricao, gbc);

        // Linha 3 - Responsável e Prioridade
        gbc.gridx = 0; gbc.gridy++;
        painelCadastro.add(new JLabel("Responsável:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(comboResponsavel, gbc);

        gbc.gridx = 2;
        painelCadastro.add(new JLabel("Prioridade:"), gbc);
        gbc.gridx = 3;
        painelCadastro.add(comboPrioridade, gbc);

        // Linha 4 - Deadline
        gbc.gridx = 0; gbc.gridy++;
        painelCadastro.add(new JLabel("Deadline:"), gbc);
        gbc.gridx = 1;
        painelCadastro.add(campoDeadline, gbc);

        // Linha 5 - Botão centralizado
        gbc.gridx = 1; gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painelCadastro.add(btnSalvar, gbc);

        tabbedPane.addTab("Cadastro", painelCadastro);

        // Painel da tabela de tarefas
        JPanel painelItens = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(
                new String[]{"Título", "Descrição", "Responsável", "Prioridade", "Deadline"}, 0
        );
        tabela = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tabela);
        painelItens.add(scroll, BorderLayout.CENTER);

        // Botão excluir
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> excluirItem());
        painelItens.add(btnExcluir, BorderLayout.SOUTH);

        tabbedPane.addTab("Tarefas", painelItens);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        tabela.setRowSorter(sorter);

        // Ação do botão salvar
        btnSalvar.addActionListener(e -> {
            String titulo = campoTitulo.getText();
            String descricao = campoDescricao.getText();
            String responsavel = comboResponsavel.getSelectedItem().toString();
            String prioridade = comboPrioridade.getSelectedItem().toString();
            String deadline = campoDeadline.getText();

            if (!titulo.isEmpty() && !responsavel.equals("Selecione") && !prioridade.equals("Selecione")) {
                tableModel.addRow(new Object[]{titulo, descricao, responsavel, prioridade, deadline});
                JOptionPane.showMessageDialog(this,"Tarefa adicionada com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!");
            }
        });

        add(tabbedPane);
        setVisible(true);
    }

    private void limparCampos() {
        campoTitulo.setText("");
        campoDescricao.setText("");
        comboResponsavel.setSelectedIndex(0);
        comboPrioridade.setSelectedIndex(0);
        campoDeadline.setText("");
    }

    private void excluirItem() {
        int row = tabela.getSelectedRow();
        if (row != -1) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Deseja excluir este item?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                int modelRow = tabela.convertRowIndexToModel(row);
                tableModel.removeRow(modelRow);
                JOptionPane.showMessageDialog(this, "Item removido com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para excluir.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainView::new);
    }
}
