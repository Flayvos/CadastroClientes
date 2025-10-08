package view;

import dao.ConexaoBD;
import entidade.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelaListar extends JFrame {

    private JTable tabelaClientes;
    private DefaultTableModel modelo;

    public TelaListar() {
        setTitle("Listagem de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Colunas da tabela
        String[] colunas = {"ID", "Nome", "CPF", "E-mail", "Telefone"};
        modelo = new DefaultTableModel(colunas, 0);
        tabelaClientes = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);

        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnFechar = new JButton("Fechar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnFechar);

        btnAtualizar.addActionListener(e -> carregarClientes());
        btnFechar.addActionListener(e -> dispose());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);

        carregarClientes();
    }

    private void carregarClientes() {
        modelo.setRowCount(0); // limpa tabela antes de recarregar
        List<Cliente> lista = buscarClientesNoBanco();

        for (Cliente c : lista) {
            modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getCpf(),
                    c.getEmail(),
                    c.getTelefone()
            });
        }
    }

    private List<Cliente> buscarClientesNoBanco() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                clientes.add(c);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar clientes: " + e.getMessage());
        }
        return clientes;
    }
}
