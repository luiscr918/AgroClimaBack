package com.itsqmet.agroClima.service;

import com.itsqmet.agroClima.entity.Terreno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itsqmet.agroClima.repository.TerrenoInterface;

import java.util.List;
import java.util.Optional;

@Service
public class TerrenoService {
    @Autowired
    private TerrenoInterface terrenoInterface;
    //Lista de terreno
    public List<Terreno> allTerrenos(){
        return terrenoInterface.findAll();
    }
    //buscar por id(para actualizar y eliminar)
    public Optional<Terreno> buscarTerrenoId(Long id){
        return terrenoInterface.findById(id);
    }
    //guardar terreno
    public Terreno guardarTerreno(Terreno terreno){
        return terrenoInterface.save(terreno);
    }
    //eliminar terreno
    public void eliminarTerreno(Long id){
        terrenoInterface.deleteById(id);
    }
}
