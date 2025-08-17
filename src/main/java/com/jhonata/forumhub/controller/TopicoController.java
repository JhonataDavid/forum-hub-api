package com.jhonata.forumhub.controller;

import com.jhonata.forumhub.domain.service.TopicoService;
import com.jhonata.forumhub.dto.topico.TopicoResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @GetMapping()
    public List<TopicoResponseDTO> getTopicos(){
        return service.listarTopicos();
    }
}
