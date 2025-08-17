package com.jhonata.forumhub.mapper;

import com.jhonata.forumhub.dto.curso.CursoRequestDTO;
import com.jhonata.forumhub.domain.entity.Curso;
import com.jhonata.forumhub.domain.enums.Categoria;
import com.jhonata.forumhub.dto.curso.CursoResponseDTO;
import com.jhonata.forumhub.repository.CursoRepository;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    private final CursoRepository cursoRepository;

    public CursoMapper(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso dtoToEntity(CursoRequestDTO dto) {
        Curso novoCurso = new Curso();
        novoCurso.setNome(dto.nome());
        novoCurso.setCategoria(Categoria.valueOf(dto.categoria()));
        return novoCurso;
    }

    public CursoResponseDTO entityToDto(Curso entity) {
        return new CursoResponseDTO(entity.getNome(), entity.getCategoria());
    }
}
