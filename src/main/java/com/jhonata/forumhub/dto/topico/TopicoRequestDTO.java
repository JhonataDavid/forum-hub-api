package com.jhonata.forumhub.dto.topico;

import jakarta.validation.constraints.NotBlank;

public record TopicoRequestDTO(
    @NotBlank
    String titulo,
    @NotBlank
    String mensagem,
    @NotBlank
    String nomeCurso,
    @NotBlank
    String categoria
) {
}
