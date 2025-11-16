package com.itsqmet.agroClima.service;

import com.itsqmet.agroClima.entity.Cultivo;
import com.itsqmet.agroClima.entity.Terreno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itsqmet.agroClima.repository.CultivoInterface;

import java.util.List;
import java.util.Optional;

@Service
public class CultivoService {
    @Autowired
    private CultivoInterface cultivoInterface;
    //Lista de cultivo
    public List<Cultivo> allCultivos(){
        return cultivoInterface.findAll();
    }
    //buscar por id(para actualizar y eliminar)
    public Optional<Cultivo> buscarCultivoId(Long id){
        return cultivoInterface.findById(id);
    }
    //guardar cultivo
    public Cultivo guardarCultivo(Cultivo cultivo){
        return cultivoInterface.save(cultivo);
    }
    //eliminar cultivo
    public void eliminarCultivo(Long id){
        cultivoInterface.deleteById(id);
    }
    //obtener los cultivos por terreno
    public List<Cultivo> obtenerCultivosPorTerreno(Long terrenoId) {
        return cultivoInterface.findByTerreno_Id(terrenoId);
    }
}
