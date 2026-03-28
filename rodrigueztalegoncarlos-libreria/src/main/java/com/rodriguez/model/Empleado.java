package com.rodriguez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")

public class Empleado {

    @Id

    private int idempleado;

    private String apellido;

    private String nombre;

    private String direccion;

    private String email;

    private int activo;

    public Empleado(){}

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

}