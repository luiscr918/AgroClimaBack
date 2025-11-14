package controller;

import entity.Terreno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TerrenoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/terrenos")
@CrossOrigin(origins = "http://localhost:4200")
public class TerrenoController {
    @Autowired
    private TerrenoService terrenoService;

    //leer todos los terrenos
    @GetMapping
    public List<Terreno> mostrarTerrenos() {
        return terrenoService.allTerrenos();
    }

    //guardar nuevo terreno
    @PostMapping
    public Terreno guardarTerreno(@RequestBody Terreno terreno) {
        return terrenoService.guardarTerreno(terreno);
    }

    //buscar terreno por id
    @GetMapping("/{id}")
    public Optional<Terreno> buscarTerrenoId(@PathVariable Long id) {
        return terrenoService.buscarTerrenoId(id);
    }

    //actualizar terreno
    @PutMapping("/{id}")
    public Terreno actualizarTerreno(@PathVariable Long id, @RequestBody Terreno terreno) {
        Optional<Terreno> terrenoOptional = terrenoService.buscarTerrenoId(id);
        if (terrenoOptional.isPresent()) {
            Terreno terrenoExistente = terrenoOptional.get();
            terrenoExistente.setNombre(terreno.getNombre());
            terrenoExistente.setTamanioHectareas(terreno.getTamanioHectareas());
            terrenoExistente.setUbicacion(terreno.getUbicacion());
            terrenoExistente.setTipoSuelo(terreno.getTipoSuelo());
            terrenoExistente.setCultivos(terreno.getCultivos());
            terrenoExistente.setPronosticos(terreno.getPronosticos());
            terrenoExistente.setUsuario(terreno.getUsuario());
            return terrenoService.guardarTerreno(terrenoExistente);
        }
        return null;
    }

    //eliminar terreno
    @DeleteMapping("/{id}")
    public void eliminarTerreno(@PathVariable Long id) {
        terrenoService.eliminarTerreno(id);
    }

}
