package com.itsqmet.agroClima.repository;

import com.itsqmet.agroClima.entity.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CultivoInterface extends JpaRepository<Cultivo,Long> {
    List<Cultivo> findByTerreno_Id(Long terrenoId);
}
