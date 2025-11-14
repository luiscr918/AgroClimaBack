package controller;

import entity.Cultivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CultivoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cultivos")
@CrossOrigin(origins = "http://localhost:4200")
public class CultivoController {
    @Autowired
    private CultivoService cultivoService;

    //leer todos los cultivos
    @GetMapping
    public List<Cultivo> mostrarCultivos() {
        return cultivoService.allCultivos();
    }

    //guardar nuevo cultivo
    @PostMapping
    public Cultivo guardarCultivo(@RequestBody Cultivo cultivo) {
        return cultivoService.guardarCultivo(cultivo);
    }

    //buscar cultivo por id
    @GetMapping("/{id}")
    public Optional<Cultivo> buscarCultivoId(@PathVariable Long id) {
        return cultivoService.buscarCultivoId(id);
    }

    //actualizar cultivo
    @PutMapping("/{id}")
    public Cultivo actualizarCultivo(@PathVariable Long id, @RequestBody Cultivo cultivo) {
        Optional<Cultivo> cultivoOptional = cultivoService.buscarCultivoId(id);
        if (cultivoOptional.isPresent()) {
            Cultivo cultivoExistente = cultivoOptional.get();
            cultivoExistente.setNombre(cultivo.getNombre());
            cultivoExistente.setTipo(cultivo.getTipo());
            cultivoExistente.setCicloDias(cultivo.getCicloDias());
            cultivoExistente.setTemporadaOptima(cultivo.getTemporadaOptima());
            cultivoExistente.setSiembras(cultivo.getSiembras());
            cultivoExistente.setTerreno(cultivo.getTerreno());
            return cultivoService.guardarCultivo(cultivoExistente);
        }
        return null;
    }

    //eliminar cultivo
    @DeleteMapping("/{id}")
    public void eliminarCultivo(@PathVariable Long id) {
        cultivoService.eliminarCultivo(id);
    }

}
