package com.itsqmet.agroClima.service;

import com.itsqmet.agroClima.entity.Usuario;
import com.itsqmet.agroClima.repository.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioInterface usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        // Construir UserDetails; usa rol si lo tienes null-check
        String role = usuario.getRol() != null ? usuario.getRol().name() : "AGRICULTOR";
        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(role.replace("ROLE_", "")) // si tu enum ya tiene ROLE_
                .build();
    }
}
