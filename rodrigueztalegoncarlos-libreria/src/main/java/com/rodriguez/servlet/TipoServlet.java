package com.rodriguez.servlet;

import java.io.IOException;
import java.util.List;

import com.rodriguez.service.TipoService;
import com.rodriguez.service.TipoServiceImpl;

import com.rodriguez.dto.TipoDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tipos")

public class TipoServlet extends HttpServlet {

	private TipoService service = new TipoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String id = request.getParameter("id");

		String descripcion = request.getParameter("descripcion");

		List<TipoDTO> lista = service.listar(id, descripcion);

		request.setAttribute("lista", lista);

		request.getRequestDispatcher("/jsp/tipos.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		TipoDTO dto = new TipoDTO();

		dto.setIdtipo(request.getParameter("idtipo"));

		dto.setDescripcion(request.getParameter("descripcion"));

		if ("insertar".equals(accion)) {

			service.insertar(dto);

		}

		if ("actualizar".equals(accion)) {

			service.actualizar(dto);

		}

		response.sendRedirect("tipos");

	}

}