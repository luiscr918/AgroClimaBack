package com.itsqmet.agroClima.repository;

import com.itsqmet.agroClima.entity.Terreno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerrenoInterface extends JpaRepository<Terreno,Long> {
    List<Terreno> findByUsuarioId(Long usuarioId);
}
