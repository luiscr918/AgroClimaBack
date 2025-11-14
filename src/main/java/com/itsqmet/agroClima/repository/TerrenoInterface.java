package com.itsqmet.agroClima.repository;

import com.itsqmet.agroClima.entity.Terreno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrenoInterface extends JpaRepository<Terreno,Long> {
}
