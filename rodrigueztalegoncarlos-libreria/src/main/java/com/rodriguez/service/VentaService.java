package com.rodriguez.service;

import java.util.List;

import com.rodriguez.dto.VentaDTO;
import com.rodriguez.model.Venta;

public interface VentaService {

	void registrarVenta(VentaDTO dto);

	List<Venta> listar(

			String id, String cliente, String empleado

	);

}