package view;

import entidade.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {

    private JTextField txtNome, txtCpf, txtEmail, txtTelefone;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Campos de texto e labels
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

        // Botões
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnCancelar);

        // Ações dos botões
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente(
                        txtNome.getText(),
                        txtCpf.getText(),
                        txtEmail.getText(),
                        txtTelefone.getText()
                );
                JOptionPane.showMessageDialog(null,
                         "Cliente salvo com sucesso!\n\n" +
                        "Nome: " + cliente.getNome() + "\n" +
                        "CPF: " + cliente.getCpf() + "\n" +
                        "E-mail: " + cliente.getEmail() + "\n" +
                        "Telefone: " + cliente.getTelefone());
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
                // ou use System.exit(0) se quiser encerrar tudo
            }
        });

        // Adiciona componentes à janela
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
}
