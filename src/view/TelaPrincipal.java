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
        JMenuItem itemCliente = new JMenuItem("Cadastro de Cliente");
        menuCadastro.add(itemCliente);

        JMenu menuListar = new JMenu("Listagens");
        JMenuItem itemListar = new JMenuItem("Listar Clientes");
        menuListar.add(itemListar);

        JMenu menuSair = new JMenu("Sair");
        JMenuItem itemSair = new JMenuItem("Sair");
        menuSair.add(itemSair);

        menuBar.add(menuCadastro);
        menuBar.add(menuListar);
        menuBar.add(menuSair);
        setJMenuBar(menuBar);

        itemCliente.addActionListener(e -> new TelaCadastroCliente().setVisible(true));
        itemListar.addActionListener(e -> new TelaListar().setVisible(true));
        itemSair.addActionListener(e -> System.exit(0));

        JLabel lbl = new JLabel("Bem-vindo ao Sistema de Cadastro de Clientes", SwingConstants.CENTER);
        add(lbl);
    }
}
