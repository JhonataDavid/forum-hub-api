CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status_topico VARCHAR(255) NOT NULL,
    usuario_id INT NOT NULL,
    curso_id INT,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
