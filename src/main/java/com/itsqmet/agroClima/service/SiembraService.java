package com.itsqmet.agroClima.service;

import com.itsqmet.agroClima.entity.Siembra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itsqmet.agroClima.repository.SiembraInterface;

import java.util.List;
import java.util.Optional;

@Service
public class SiembraService {
    @Autowired
    private SiembraInterface siembraInterface;
    //Lista de siembra
    public List<Siembra> allSiembras(){
        return siembraInterface.findAll();
    }
    //buscar por id(para actualizar y eliminar)
    public Optional<Siembra> buscarSiembraId(Long id){
        return siembraInterface.findById(id);
    }
    //guardar siembra
    public Siembra guardarSiembra(Siembra siembra){
        return siembraInterface.save(siembra);
    }
    //eliminar siembra
    public void eliminarSiembra(Long id){
        siembraInterface.deleteById(id);
    }
}
