package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema de Cadastro de Clientes");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastros");
        JMenu menuSair = new JMenu("Sair");

        JMenuItem itemCliente = new JMenuItem("Cadastro de Cliente");
        JMenuItem itemSair = new JMenuItem("Sair");

        // Adiciona itens
        menuCadastro.add(itemCliente);
        menuSair.add(itemSair);

        // Adiciona menus à barra
        menuBar.add(menuCadastro);
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        // Ações do menu
        itemCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroCliente().setVisible(true);
            }
        });

        itemSair.addActionListener(e -> System.exit(0));

        JLabel lbl = new JLabel("Bem-vindo ao Sistema de Cadastro de Clientes", SwingConstants.CENTER);
        add(lbl);
    }
}
