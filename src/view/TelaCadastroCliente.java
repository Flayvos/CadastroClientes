package view;

import entidade.Cliente;
import dao.ConexaoBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelaCadastroCliente extends JFrame {

    private JTextField txtNome, txtCpf, txtEmail, txtTelefone;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só essa tela
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        panel.add(txtCpf);

        panel.add(new JLabel("E-mail:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        panel.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        panel.add(txtTelefone);

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnCancelar);

        // Botão Salvar → Grava no banco
        btnSalvar.addActionListener(this::salvarCliente);

        // Botão Cancelar → Fecha a tela e volta à principal
        btnCancelar.addActionListener(e -> dispose());

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void salvarCliente(ActionEvent e) {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String telefone = txtTelefone.getText();

        Cliente cliente = new Cliente(nome, cpf, email, telefone);

        try (Connection conn = ConexaoBD.conectar()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Erro de conexão com o banco!");
                return;
            }

            String sql = "INSERT INTO cliente (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
            dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar cliente: " + ex.getMessage());
        }
    }
}
a