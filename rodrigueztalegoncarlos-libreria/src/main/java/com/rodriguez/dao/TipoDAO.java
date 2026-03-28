package com.rodriguez.dao;

import java.util.List;
import com.rodriguez.model.Tipo;

public interface TipoDAO {

void insertar(Tipo tipo);

void actualizar(Tipo tipo);

Tipo obtener(String id);

List<Tipo> listar(String id,String descripcion);

}