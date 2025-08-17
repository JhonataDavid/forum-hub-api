package com.jhonata.forumhub.dto.curso;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDTO(@NotBlank String nome, @NotBlank String categoria) {
}
