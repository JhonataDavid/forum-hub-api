package com.jhonata.forumhub.domain.service;

import com.jhonata.forumhub.dto.curso.CursoRequestDTO;
import com.jhonata.forumhub.dto.topico.TopicoRequestDTO;
import com.jhonata.forumhub.dto.topico.TopicoResponseDTO;
import com.jhonata.forumhub.mapper.CursoMapper;
import com.jhonata.forumhub.mapper.TopicoMapper;
import com.jhonata.forumhub.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;
    private final TopicoMapper mapper;
    private final CursoMapper cursoMapper;

    public TopicoService(TopicoRepository repository, TopicoMapper mapper, CursoMapper cursoMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.cursoMapper = cursoMapper;
    }

    @Transactional
    public void salvarTopico(TopicoRequestDTO dto, CursoRequestDTO cursoRequestDTO) {
        var curso = cursoMapper.dtoToEntity(cursoRequestDTO);
        var novaEntity = mapper.dtoToEntity(dto, curso);
        this.repository.save(novaEntity);
    }

    public List<TopicoResponseDTO> listarTopicos(){
        return repository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }
}
