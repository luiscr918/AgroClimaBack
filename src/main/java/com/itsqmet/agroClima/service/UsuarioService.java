package com.itsqmet.agroClima.service;

import com.itsqmet.agroClima.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itsqmet.agroClima.repository.UsuarioInterface;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioInterface usuarioInterface;
    //Lista de usuario
    public List<Usuario> allUsuarios(){
        return usuarioInterface.findAll();
    }
    //buscar por id(para actualizar y eliminar)
    public Optional<Usuario> buscarUsuarioId(Long id){
        return usuarioInterface.findById(id);
    }
    //guardar usuario
    public Usuario guardarUsuario(Usuario usuario){
        return usuarioInterface.save(usuario);
    }
    //eliminar usuario
    public void eliminarUsuario(Long id){
        usuarioInterface.deleteById(id);
    }
    //buscar por email
    public Usuario buscarPorEmail(String email){
        return usuarioInterface.findByEmail(email).orElse(null);
    }
}
