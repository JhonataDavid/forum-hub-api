package com.jhonata.forumhub.entities;

import com.jhonata.forumhub.enums.EstadoTopico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;
    private Usuario autor; //Falta implementar o Autor corretamente (Class Autor).
    private Curso curso;
}


