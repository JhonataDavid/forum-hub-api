package com.jhonata.forumhub.domain.entity;

import com.jhonata.forumhub.domain.enums.StatusTopico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String mensagem;
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_topico")
    private StatusTopico statusTopico;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}


