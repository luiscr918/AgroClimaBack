package com.itsqmet.agroClima.service;

import com.itsqmet.agroClima.entity.Recomendacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itsqmet.agroClima.repository.RecomendacionInterface;

import java.util.List;
import java.util.Optional;

@Service
public class RecomendacionService {
    @Autowired
    private RecomendacionInterface recomendacionInterface;
    //Lista de recomendaciones
    public List<Recomendacion> allRecomendaciones(){
        return recomendacionInterface.findAll();
    }
    //buscar por id(para actualizar y eliminar)
    public Optional<Recomendacion> buscarRecomendacionId(Long id){
        return recomendacionInterface.findById(id);
    }
    //guardar recomendacion
    public Recomendacion guardarRecomendacion(Recomendacion recomendacion){
        return recomendacionInterface.save(recomendacion);
    }
    //eliminar recomendacion
    public void eliminarRecomendacion(Long id){
        recomendacionInterface.deleteById(id);
    }
}
