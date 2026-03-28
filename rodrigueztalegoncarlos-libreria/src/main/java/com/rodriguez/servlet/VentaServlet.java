package com.rodriguez.servlet;

import java.io.IOException;
import java.util.List;

import com.rodriguez.service.VentaService;
import com.rodriguez.service.VentaServiceImpl;

import com.rodriguez.dao.PublicacionDAO;
import com.rodriguez.dao.PublicacionDAOImpl;

import com.rodriguez.dao.EmpleadoDAO;
import com.rodriguez.dao.EmpleadoDAOImpl;

import com.rodriguez.dto.VentaDTO;

import com.rodriguez.model.Venta;
import com.rodriguez.model.Publicacion;
import com.rodriguez.model.Empleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ventas")

public class VentaServlet extends HttpServlet {

	private VentaService service = new VentaServiceImpl();

	private PublicacionDAO pubDAO = new PublicacionDAOImpl();

	private EmpleadoDAO empDAO = new EmpleadoDAOImpl();

	@Override
	protected void doGet(

			HttpServletRequest request,

			HttpServletResponse response)

			throws ServletException, IOException {

		String id = request.getParameter("idventa");

		String cliente = request.getParameter("cliente");

		String empleado = request.getParameter("idempleado");

		List<Venta> ventas = service.listar(id, cliente, empleado);

		List<Publicacion> pubs = pubDAO.listar();

		List<Empleado> empleados = empDAO.listar();

		request.setAttribute("ventas", ventas);

		request.setAttribute("publicaciones", pubs);

		request.setAttribute("empleados", empleados);

		request.getRequestDispatcher("/jsp/ventas.jsp").forward(request, response);

	}

	@Override
	protected void doPost(

			HttpServletRequest request,

			HttpServletResponse response)

			throws ServletException, IOException {

		VentaDTO dto = new VentaDTO();

		dto.setIdventa(request.getParameter("idventa"));

		dto.setCliente(request.getParameter("cliente"));

		dto.setCantidad(

				Integer.parseInt(request.getParameter("cantidad")));

		dto.setIdpublicacion(

				request.getParameter("idpublicacion"));

		dto.setIdempleado(

				Integer.parseInt(request.getParameter("idempleado")));

		service.registrarVenta(dto);

		response.sendRedirect("ventas");

	}

}