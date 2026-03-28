package com.rodriguez.service;

import java.util.List;

import com.rodriguez.dto.PublicacionDTO;
import com.rodriguez.model.Publicacion;

public interface PublicacionService{

void insertar(PublicacionDTO dto);

List<Publicacion> listar();

void actualizar(PublicacionDTO dto);

}