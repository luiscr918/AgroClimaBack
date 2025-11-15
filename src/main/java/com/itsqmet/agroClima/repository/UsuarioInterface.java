package com.itsqmet.agroClima.repository;

import com.itsqmet.agroClima.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioInterface extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
}
