CREATE DATABASE cadastro_clientes;
USE cadastro_clientes;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(20),
    email VARCHAR(100),
    telefone VARCHAR(20)
);
a