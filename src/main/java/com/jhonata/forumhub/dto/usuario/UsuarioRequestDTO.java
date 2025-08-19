package com.jhonata.forumhub.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank String login,
        @NotBlank String senha
) {}
