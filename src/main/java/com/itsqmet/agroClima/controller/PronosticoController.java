package com.itsqmet.agroClima.controller;

import com.itsqmet.agroClima.entity.Pronostico;
import com.itsqmet.agroClima.entity.Terreno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itsqmet.agroClima.service.PronosticoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pronosticos")
public class PronosticoController {
    @Autowired
    private PronosticoService pronosticoService;

    //leer todos los pronosticos
    @GetMapping
    public List<Pronostico> mostrarPronosticos() {
        return pronosticoService.allPronosticos();
    }

    //guardar nuevo pronostico
    @PostMapping
    public Pronostico guardarPronostico(@RequestBody Pronostico pronostico) {
        return pronosticoService.guardarPronostico(pronostico);
    }

    //buscar pronostico por id
    @GetMapping("/{id}")
    public Optional<Pronostico> buscarPronosticoId(@PathVariable Long id) {
        return pronosticoService.buscarPronosticoId(id);
    }

    //actualizar pronostico
    @PutMapping("/{id}")
    public Pronostico actualizarPronostico(@PathVariable Long id, @RequestBody Pronostico pronostico) {
        Optional<Pronostico> pronosticoOptional = pronosticoService.buscarPronosticoId(id);
        if (pronosticoOptional.isPresent()) {
            Pronostico pronosticoExistente = pronosticoOptional.get();
            pronosticoExistente.setFecha(pronostico.getFecha());
            pronosticoExistente.setTemperaturaMinima(pronostico.getTemperaturaMinima());
            pronosticoExistente.setTemperaturaMaxima(pronostico.getTemperaturaMaxima());
            pronosticoExistente.setPrecipitacion(pronostico.getPrecipitacion());
            pronosticoExistente.setHumedad(pronostico.getHumedad());
            pronosticoExistente.setDescripcion(pronostico.getDescripcion());
            return pronosticoService.guardarPronostico(pronosticoExistente);
        }
        return null;
    }

    //eliminar pronostico
    @DeleteMapping("/{id}")
    public void eliminarPronostico(@PathVariable Long id) {
        pronosticoService.eliminarPronostico(id);
    }
    //obtener pronosticos por terreno
    @GetMapping("/terreno/{terrenoId}")
    public List<Pronostico> obtenerPronosticosPorTerreno(@PathVariable Long terrenoId) {
        return pronosticoService.obtenerPronosticosPorTerreno(terrenoId);
    }
}
