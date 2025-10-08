package main;

import view.TelaCadastroCliente;

public class Main {
    public static void main(String[] args) {
        // Inicia a interface gráfica na thread de evento
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }
}
