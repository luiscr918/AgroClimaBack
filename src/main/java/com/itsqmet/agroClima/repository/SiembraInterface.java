package com.itsqmet.agroClima.repository;


import com.itsqmet.agroClima.entity.Siembra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiembraInterface extends JpaRepository<Siembra,Long> {
    List<Siembra> findByCultivo_Id(Long cultivoId);
}
