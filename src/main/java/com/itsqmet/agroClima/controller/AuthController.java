package com.itsqmet.agroClima.controller;

import com.itsqmet.agroClima.dto.AuthRequest;
import com.itsqmet.agroClima.dto.AuthResponse;
import com.itsqmet.agroClima.dto.RegistroRequest;
import com.itsqmet.agroClima.entity.Usuario;
import com.itsqmet.agroClima.enums.Rol;
import com.itsqmet.agroClima.repository.UsuarioInterface;
import com.itsqmet.agroClima.security.JwtUtil;
import com.itsqmet.agroClima.service.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UsuarioInterface usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        Optional<Usuario> opt = usuarioRepo.findByEmail(req.getEmail());
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Usuario no existe"));
        }
        Usuario usuario = opt.get();
        if (!passwordEncoder.matches(req.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Contraseña incorrecta"));
        }
        UserDetails uds = userDetailsService.loadUserByUsername(usuario.getEmail());
        String token = jwtUtil.generateToken(uds);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    // REGISTRO
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegistroRequest dto) {
        if (usuarioRepo.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email ya existe"));
        }
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setEmail(dto.getEmail());
        u.setTelefono(dto.getTelefono());
        u.setRol(dto.getRol() != null ? dto.getRol() : Rol.AGRICULTOR); // ejemplo
        // ENCRIPTAR contraseña antes de guardar
        u.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuarioRepo.save(u);
        return ResponseEntity.ok(Map.of("message", "Registrado"));
    }
}
