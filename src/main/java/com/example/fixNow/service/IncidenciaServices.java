package com.example.fixNow.service;
//import de la clase modelo
import com.example.fixNow.model.Incidencia;
//import de la clase repository
import com.example.fixNow.repository.IncidenciaRepositoty;
import org.springframework.stereotype.Service;
//import de opcinal
import java.util.Optional;
//import de listas
import java.util.List;

@Service
public class IncidenciaServices {
    //variable de para usar repository
    private final IncidenciaRepositoty incidenciaRepositoty;

    public IncidenciaServices(IncidenciaRepositoty incidenciaRepositoty) {
        this.incidenciaRepositoty = incidenciaRepositoty;
    }

    //guardar elementos
    public Incidencia guardarIncidencia(Incidencia incidencia){
        return incidenciaRepositoty.save(incidencia);
    }

    //buscar por id
    public Incidencia BuscarPorId(Integer id){
        Optional<Incidencia> reporte = incidenciaRepositoty.findById(id);
        //si existe lo mostrara sino va a devolver un null
        return reporte.orElse(null);
    }

    //listar las incidencias
    public List<Incidencia>listaDeInicdencias(){
        return incidenciaRepositoty.findAll();
    }

    //actualizar detos de la incidencia
    public Incidencia actualizarIncidencia(Integer id, Incidencia nuevoDato){
        return incidenciaRepositoty.findById(id).map(incidenciaRepositoty::save).orElse(null);
    }
    //eliminar incidencias
    public void eliminarPorId(Integer id){
        incidenciaRepositoty.deleteById(id);
    }

    //existe incidencia
    public boolean existePorId(Integer id){
        return incidenciaRepositoty.existsById(id);
    }
}
