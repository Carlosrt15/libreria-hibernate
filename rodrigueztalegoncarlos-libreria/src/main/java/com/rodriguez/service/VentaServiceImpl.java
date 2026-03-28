package com.rodriguez.service;

import java.util.List;

import com.rodriguez.dao.VentaDAO;
import com.rodriguez.dao.VentaDAOImpl;

import com.rodriguez.dto.VentaDTO;

import com.rodriguez.model.Venta;

public class VentaServiceImpl implements VentaService {

	private VentaDAO dao = new VentaDAOImpl();

	@Override
	public void registrarVenta(VentaDTO dto) {

		dao.insertarVenta(

				dto.getIdventa(),

				dto.getCliente(),

				dto.getCantidad(),

				dto.getIdpublicacion(),

				dto.getIdempleado()

		);

	}

	@Override
	public List<Venta> listar(

			String id, String cliente, String empleado) {

		return dao.listar(id, cliente, empleado);

	}

}