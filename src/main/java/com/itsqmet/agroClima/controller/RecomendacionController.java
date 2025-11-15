package com.itsqmet.agroClima.controller;

import com.itsqmet.agroClima.entity.Recomendacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itsqmet.agroClima.service.RecomendacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {
    @Autowired
    private RecomendacionService recomendacionService;

    //leer todos los recomendaciones
    @GetMapping
    public List<Recomendacion> mostrarRecomendacions() {
        return recomendacionService.allRecomendaciones();
    }

    //guardar nuevo recomendacion
    @PostMapping
    public Recomendacion guardarRecomendacion(@RequestBody Recomendacion recomendacion) {
        return recomendacionService.guardarRecomendacion(recomendacion);
    }

    //buscar recomendacion por id
    @GetMapping("/{id}")
    public Optional<Recomendacion> buscarRecomendacionId(@PathVariable Long id) {
        return recomendacionService.buscarRecomendacionId(id);
    }

    //actualizar recomendacion
    @PutMapping("/{id}")
    public Recomendacion actualizarRecomendacion(@PathVariable Long id, @RequestBody Recomendacion recomendacion) {
        Optional<Recomendacion> recomendacionOptional = recomendacionService.buscarRecomendacionId(id);
        if (recomendacionOptional.isPresent()) {
            Recomendacion recomendacionExistente = recomendacionOptional.get();
            recomendacionExistente.setMensaje(recomendacion.getMensaje());
            recomendacionExistente.setTipo(recomendacion.getTipo());
            recomendacionExistente.setFechaGeneracion(recomendacion.getFechaGeneracion());
            recomendacionExistente.setUsuario(recomendacion.getUsuario());
            return recomendacionService.guardarRecomendacion(recomendacionExistente);
        }
        return null;
    }

    //eliminar recomendacion
    @DeleteMapping("/{id}")
    public void eliminarRecomendacion(@PathVariable Long id) {
        recomendacionService.eliminarRecomendacion(id);
    }

}
