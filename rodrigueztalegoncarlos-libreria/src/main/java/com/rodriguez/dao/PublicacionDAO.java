package com.rodriguez.dao;

import java.util.List;
import com.rodriguez.model.Publicacion;

public interface PublicacionDAO {

	void insertar(Publicacion pub);

	List<Publicacion> listar();

	void actualizar(Publicacion pub);

	Publicacion obtener(String id);

	// filtrar usar esto

	List<Publicacion> filtrar(String id, String titulo, String autor, Integer edicion, Double precio, Integer stock,
			String idtipo);

}