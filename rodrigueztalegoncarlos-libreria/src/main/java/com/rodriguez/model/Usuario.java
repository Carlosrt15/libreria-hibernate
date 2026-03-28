package com.rodriguez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")

public class Usuario {

    @Id

    private int idempleado;

    private String usuario;

    private String clave;

    private int activo;

    @OneToOne

    @JoinColumn(name="idempleado")

    private Empleado empleado;

}