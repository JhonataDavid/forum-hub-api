package com.jhonata.forumhub.controller;

import com.jhonata.forumhub.domain.service.TopicoService;
import com.jhonata.forumhub.dto.topico.TopicoRequestDTO;
import com.jhonata.forumhub.dto.topico.TopicoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @GetMapping()
    public Page<TopicoResponseDTO> listarTopicos(Pageable pageable){
        return service.listarTopicos(pageable);
    }

    @GetMapping("/topicos/{id}")
    public ResponseEntity<TopicoResponseDTO> listarTopico(@PathVariable() Long id){
        return service.buscarTopicoPorid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Void> registrarTopico(@RequestBody @Valid TopicoRequestDTO topico){
        service.salvarTopico(topico);
        return ResponseEntity.ok().build();
    }



}
