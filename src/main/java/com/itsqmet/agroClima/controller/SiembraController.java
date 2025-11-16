package com.itsqmet.agroClima.controller;

import com.itsqmet.agroClima.entity.Cultivo;
import com.itsqmet.agroClima.entity.Siembra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itsqmet.agroClima.service.SiembraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/siembras")
public class SiembraController {
    @Autowired
    private SiembraService siembraService;

    //leer todos los siembras
    @GetMapping
    public List<Siembra> mostrarSiembras() {
        return siembraService.allSiembras();
    }

    //guardar nuevo siembra
    @PostMapping
    public Siembra guardarSiembra(@RequestBody Siembra siembra) {
        return siembraService.guardarSiembra(siembra);
    }

    //buscar siembra por id
    @GetMapping("/{id}")
    public Optional<Siembra> buscarSiembraId(@PathVariable Long id) {
        return siembraService.buscarSiembraId(id);
    }

    //actualizar siembra
    @PutMapping("/{id}")
    public Siembra actualizarSiembra(@PathVariable Long id, @RequestBody Siembra siembra) {
        Optional<Siembra> siembraOptional = siembraService.buscarSiembraId(id);
        if (siembraOptional.isPresent()) {
            Siembra siembraExistente = siembraOptional.get();
            siembraExistente.setFechaSiembra(siembra.getFechaSiembra());
            siembraExistente.setEstado(siembra.getEstado());
            return siembraService.guardarSiembra(siembraExistente);
        }
        return null;
    }

    //eliminar siembra
    @DeleteMapping("/{id}")
    public void eliminarSiembra(@PathVariable Long id) {
        siembraService.eliminarSiembra(id);
    }
    //obtener siembras por cultivo
    @GetMapping("/cultivo/{cultivoId}")
    public List<Siembra> obtenerSiembrasPorCultivo(@PathVariable Long cultivoId) {
        return siembraService.obtenerSiembrasPorCultivo(cultivoId);
    }

}
