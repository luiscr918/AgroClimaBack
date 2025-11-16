package com.itsqmet.agroClima.repository;

import com.itsqmet.agroClima.entity.Pronostico;
import com.itsqmet.agroClima.entity.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecomendacionInterface extends JpaRepository<Recomendacion,Long> {
    List<Recomendacion> findByUsuarioId(Long usuarioId);
}
