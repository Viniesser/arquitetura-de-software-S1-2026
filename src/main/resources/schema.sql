CREATE TABLE produtos (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          preco DOUBLE NOT NULL,
                          estoque INT NOT NULL
);

CREATE TABLE pedidos (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         usuario_id INT NOT NULL,
                         restaurante_id INT NOT NULL,
                         valor_total DOUBLE NOT NULL,
                         status VARCHAR(50) NOT NULL
);