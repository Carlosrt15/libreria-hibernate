package com.rodriguez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="usuario_rol")

@IdClass(UsuarioRolId.class)

public class UsuarioRol {

    @Id

    private int idempleado;

    @Id

    private String rol;

}