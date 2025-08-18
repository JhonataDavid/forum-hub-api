package com.jhonata.forumhub.domain.service;

import com.jhonata.forumhub.domain.entity.Curso;
import com.jhonata.forumhub.domain.entity.Topico;
import com.jhonata.forumhub.domain.enums.Categoria;
import com.jhonata.forumhub.dto.topico.TopicoRequestDTO;
import com.jhonata.forumhub.dto.topico.TopicoResponseDTO;
import com.jhonata.forumhub.mapper.CursoMapper;
import com.jhonata.forumhub.mapper.TopicoMapper;
import com.jhonata.forumhub.repository.CursoRepository;
import com.jhonata.forumhub.repository.TopicoRepository;
import com.jhonata.forumhub.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository repository;
    private final CursoRepository cursoRepository;
    private final TopicoMapper mapper;

    public TopicoService(TopicoRepository repository, UsuarioRepository usuarioRepository, TopicoMapper mapper, CursoMapper cursoMapper, CursoRepository cursoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public void salvarTopico(TopicoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.nomeCurso());
        curso.setCategoria(Categoria.valueOf(dto.categoria()));
        curso = cursoRepository.save(curso);

        Topico novaEntity = mapper.dtoToEntity(dto, curso);
        this.repository.save(novaEntity);
    }

    @Transactional(readOnly = true)
    public Page<TopicoResponseDTO> listarTopicos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::entityToDto);
    }

    public Optional<TopicoResponseDTO> buscarTopicoPorid(Long id){
        return repository.findById(id).map(mapper::entityToDto);
    }

    @Transactional
    public void atualizarTopico(TopicoRequestDTO topicoRequestDTO) {

    }
}