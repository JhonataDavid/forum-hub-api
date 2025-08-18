package com.jhonata.forumhub.dto.topico;

import com.jhonata.forumhub.domain.enums.StatusTopico;
import com.jhonata.forumhub.dto.curso.CursoResponseDTO;

import java.time.LocalDateTime;

public record TopicoResponseDTO(Long id,
                                String titulo,
                                String mensagem,
                                LocalDateTime dataDeCriacao,
                                StatusTopico status,
                                //String autor,
                                CursoResponseDTO curso) {
}
