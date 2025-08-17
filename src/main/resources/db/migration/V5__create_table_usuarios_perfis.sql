CREATE TABLE usuarios_perfis (
    usuario_id INT NOT NULL,
    perfil_id INT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    CONSTRAINT fk_up_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_up_perfil FOREIGN KEY (perfil_id) REFERENCES perfis(id)
);
