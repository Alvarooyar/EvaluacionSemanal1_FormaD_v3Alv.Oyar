package com.example.fixNow.controller;
//import de la clase modelo
import com.example.fixNow.model.Incidencia;
//import de la clase service
import com.example.fixNow.service.IncidenciaServices;

//import de la clases HTTP
import org.springframework.http.HttpStatus;

//import anotacion rest
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import de listas (solo por si acaso)
import java.util.List;

@RestController

//ruta
@RequestMapping("api/FixNow")
public class incidenciaController {
    //para usar el service
    private final IncidenciaServices incidenciaService;
    //constructor
    public incidenciaController(IncidenciaServices incidenciaService) {
        this.incidenciaService = incidenciaService;
    }

    //GET : listar las incidencias
    public ResponseEntity<?> listarIncidencias(){
        try{
            List<Incidencia> incidencias = incidenciaService.listaDeInicdencias();
            return ResponseEntity.ok(incidencias);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar todas las incidencias");
        }
    }

    //GET : buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Integer id){
        try{
            Incidencia incidencia =incidenciaService.BuscarPorId(id);

            if (incidencia == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incidencia no encontrada");
            }
            return ResponseEntity.ok(incidencia);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar la incidencia");
        }
    }

    //POST : guardar Incidencia
    public ResponseEntity<?> guardarIncidencia(@RequestBody Incidencia incidencia){
        try{
            if (incidencia.getId()==null || incidencia.getTitulo()==null || incidencia.getDescripcion()==null || incidencia.getEstado()==null || incidencia.getPreoridad()==null || incidencia.getUsuarioReportante()==null || incidencia.getFrchaRegistro()==null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todos los campos son obligatorios para ingresar la Incidencia");
            }

            if (incidenciaService.existePorId(incidencia.getId()))
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Incidencia ya existente");

            Incidencia nuevoIncidencia = incidenciaService.guardarIncidencia(incidencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoIncidencia);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar incidencia");
        }
    }

    //DELETE : eliminar incidencia
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarIncidencia(@PathVariable Integer id){
        try{
            if (incidenciaService.existePorId(id)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incidencia no encontrada");
            }

            incidenciaService .eliminarPorId(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Incidencia eliminada");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar incidencia");
        }
    }
}

    }
