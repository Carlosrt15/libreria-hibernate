package com.rodriguez.dao;

import java.util.List;
import com.rodriguez.model.Venta;

public interface VentaDAO {

	void insertarVenta(

			String idventa, String cliente, int cantidad, String idpublicacion, int idempleado

	);

	List<Venta> listar(

			String id, String cliente, String empleado

	);

}