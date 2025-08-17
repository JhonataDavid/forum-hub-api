package com.jhonata.forumhub.mapper;

import com.jhonata.forumhub.dto.curso.CursoResponseDTO;
import com.jhonata.forumhub.dto.topico.TopicoRequestDTO;
import com.jhonata.forumhub.domain.entity.Curso;
import com.jhonata.forumhub.domain.entity.Topico;
import com.jhonata.forumhub.domain.enums.StatusTopico;
import com.jhonata.forumhub.dto.topico.TopicoResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TopicoMapper {

    public Topico dtoToEntity(TopicoRequestDTO topicoDTO, Curso curso) {
        Topico novoTopico = new Topico();
        novoTopico.setTitulo(topicoDTO.titulo());
        novoTopico.setMensagem(topicoDTO.mensagem());
        novoTopico.setDataCriacao(LocalDateTime.now());
        novoTopico.setStatusTopico(StatusTopico.ABERTO);
        novoTopico.setCurso(curso);
        return novoTopico;
    }

    public TopicoResponseDTO entityToDto(Topico entity){

        CursoResponseDTO cursoResponseDTO = new CursoResponseDTO(
                entity.getCurso().getNome(),
                entity.getCurso().getCategoria());

        return new TopicoResponseDTO(
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getDataCriacao(),
                entity.getStatusTopico(),
                entity.getAutor().getNome(),
                cursoResponseDTO);
    }
}
