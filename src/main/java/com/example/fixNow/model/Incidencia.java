package com.example.fixNow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Incidencia {
    @Id
    private Integer id; // por ahora integer
    private String titulo; //resumen breve del problema
    private String descripcion; //explicacion del problema reportado
    private String estado; //ABIERTA | EN_PROCESO | RESUELTA | CERRADA
    private String preoridad; //BAJA | MEDIA | ALTA | CRITICA
    private String usuarioReportante; //nombre del usuario
    private String frchaRegistro; //fecha que se ingreso

    public Incidencia() {
    }

    public Incidencia(Integer id, String titulo, String descripcion, String estado, String preoridad, String usuarioReportante, String frchaRegistro) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.preoridad = preoridad;
        this.usuarioReportante = usuarioReportante;
        this.frchaRegistro = frchaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPreoridad() {
        return preoridad;
    }

    public void setPreoridad(String preoridad) {
        this.preoridad = preoridad;
    }

    public String getUsuarioReportante() {
        return usuarioReportante;
    }

    public void setUsuarioReportante(String usuarioReportante) {
        this.usuarioReportante = usuarioReportante;
    }

    public String getFrchaRegistro() {
        return frchaRegistro;
    }

    public void setFrchaRegistro(String frchaRegistro) {
        this.frchaRegistro = frchaRegistro;
    }
}
