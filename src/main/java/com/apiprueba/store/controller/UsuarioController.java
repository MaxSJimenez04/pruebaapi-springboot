package com.apiprueba.store.controller;

import com.apiprueba.store.dto.UsuarioDTO;
import com.apiprueba.store.model.Usuario;
import com.apiprueba.store.repository.UsuarioRepository;
import com.apiprueba.store.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService servicio;

    @PostMapping(path = "/registro")
    public @ResponseBody UsuarioDTO RegistrarUsuario(@RequestParam UsuarioDTO usuarioDTO) {
        return servicio.RegistrarUsuario(usuarioDTO);
    }

    @GetMapping(path = "/usuarios")
    public @ResponseBody List<UsuarioDTO> ConsultarUsuarios(){
        return servicio.ConsultarUsuarios();
    }
}
