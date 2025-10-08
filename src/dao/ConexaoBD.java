package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_clientes";
    private static final String USER = "root"; // altere conforme seu MySQL
    private static final String PASSWORD = ""; // altere conforme sua senha

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }
}
