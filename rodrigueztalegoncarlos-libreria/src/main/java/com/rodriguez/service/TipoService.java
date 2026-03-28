package com.rodriguez.service;

import java.util.List;
import com.rodriguez.dto.TipoDTO;

public interface TipoService{

void insertar(TipoDTO dto);

void actualizar(TipoDTO dto);

List<TipoDTO> listar(String id,String descripcion);

}