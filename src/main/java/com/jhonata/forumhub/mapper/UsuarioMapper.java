package com.jhonata.forumhub.mapper;

import com.jhonata.forumhub.domain.entity.Usuario;
import com.jhonata.forumhub.dto.usuario.UsuarioRequestDTO;
import com.jhonata.forumhub.dto.usuario.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario dtoToEntity(UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());
        return usuario;
    }

    public UsuarioResponseDTO entityToDto(Usuario usuario){
        return new UsuarioResponseDTO(usuario.getId(), usuario.getLogin(), usuario.getNome());
    }
}
