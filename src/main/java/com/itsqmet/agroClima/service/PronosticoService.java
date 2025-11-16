package com.itsqmet.agroClima.service;

import com.itsqmet.agroClima.entity.Pronostico;
import com.itsqmet.agroClima.entity.Terreno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itsqmet.agroClima.repository.PronosticoInterface;

import java.util.List;
import java.util.Optional;

@Service
public class PronosticoService {
    @Autowired
    private PronosticoInterface pronosticoInterface;
    //Lista de pronostico
    public List<Pronostico> allPronosticos(){
        return pronosticoInterface.findAll();
    }
    //buscar por id(para actualizar y eliminar)
    public Optional<Pronostico> buscarPronosticoId(Long id){
        return pronosticoInterface.findById(id);
    }
    //guardar pronostico
    public Pronostico guardarPronostico(Pronostico pronostico){
        return pronosticoInterface.save(pronostico);
    }
    //eliminar pronostico
    public void eliminarPronostico(Long id){
        pronosticoInterface.deleteById(id);
    }
    //obtener los pronostico por terreno
    public List<Pronostico> obtenerPronosticosPorTerreno(Long terrenoId) {
        return pronosticoInterface.findByTerrenoId(terrenoId);
    }
}
