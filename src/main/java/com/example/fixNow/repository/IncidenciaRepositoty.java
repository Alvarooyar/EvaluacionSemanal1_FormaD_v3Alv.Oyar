package com.example.fixNow.repository;
//import de la modelo.fixModel
import com.example.fixNow.model.Incidencia;
//import jpa repository
import org.springframework.data.jpa.repository.JpaRepository;
public interface IncidenciaRepositoty extends JpaRepository<Incidencia,Integer> {
}
