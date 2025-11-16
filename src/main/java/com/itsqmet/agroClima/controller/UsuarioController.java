package com.itsqmet.agroClima.controller;

import com.itsqmet.agroClima.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itsqmet.agroClima.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //leer todos los usuarios
    @GetMapping
    public List<Usuario> mostrarUsuarios() {
        return usuarioService.allUsuarios();
    }

    //buscar usuario por id
    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuarioId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioId(id);
    }

    //actualizar usuario
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarUsuarioId(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setPassword(usuario.getPassword());
            usuarioExistente.setTelefono(usuario.getTelefono());
            usuarioExistente.setRol(usuario.getRol());
            return usuarioService.guardarUsuario(usuarioExistente);
        }
        return null;
    }

    //eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

}
