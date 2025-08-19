package com.jhonata.forumhub.domain.enums;

import lombok.Getter;

@Getter
public enum StatusTopico {
    ABERTO("Tópico aberto"),
    RESPONDIDO("Tópico respondido"),
    FECHADO("Tópico fechado");

    private final String topicos;

    StatusTopico(String topicos) {
        this.topicos = topicos;
    }
}
