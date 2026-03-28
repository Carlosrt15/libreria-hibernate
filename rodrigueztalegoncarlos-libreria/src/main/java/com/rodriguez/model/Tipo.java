package com.rodriguez.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo")

public class Tipo {

    @Id
    @Column(name="idtipo")

    private String idtipo;

    @Column(name="descripcion")

    private String descripcion;

    @OneToMany(mappedBy="tipo")

    private List<Publicacion> publicaciones;

    public Tipo() {}

    public String getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}