package com.apiprueba.store.servicios;

import com.apiprueba.store.dto.UsuarioDTO;
import com.apiprueba.store.model.Usuario;
import com.apiprueba.store.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO RegistrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioRegistro = new Usuario();
        usuarioRegistro.setUsuario(usuarioDTO.getUsuario());
        usuarioRegistro.setContrasena(usuarioDTO.getContrasena());

        Usuario registro =usuarioRepository.save(usuarioRegistro);


        return new UsuarioDTO(registro.getId(),registro.getUsuario(),registro.getContrasena());
    }

    public List<UsuarioDTO> ConsultarUsuarios() {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(new UsuarioDTO(usuario.getId(),usuario.getUsuario(),usuario.getContrasena()));
        }
        return usuarioDTOs;
    }
}
