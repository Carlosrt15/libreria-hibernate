package com.rodriguez.servlet;

import java.io.IOException;
import java.util.List;

import com.rodriguez.service.PublicacionService;
import com.rodriguez.service.PublicacionServiceImpl;

import com.rodriguez.dao.TipoDAO;
import com.rodriguez.dao.TipoDAOImpl;

import com.rodriguez.dto.PublicacionDTO;

import com.rodriguez.model.Publicacion;
import com.rodriguez.model.Tipo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/publicaciones")

public class PublicacionServlet extends HttpServlet {

	private PublicacionService service = new PublicacionServiceImpl();

	private TipoDAO tipoDAO = new TipoDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		List<Publicacion> lista = service.listar();

		List<Tipo> tipos = tipoDAO.listar(null, null);

		request.setAttribute("lista", lista);

		request.setAttribute("tipos", tipos);

		request.getRequestDispatcher("/jsp/publicaciones.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String accion = request.getParameter("accion");

		PublicacionDTO dto = new PublicacionDTO();

		dto.setIdpublicacion(request.getParameter("idpublicacion"));

		dto.setTitulo(request.getParameter("titulo"));

		dto.setAutor(request.getParameter("autor"));

		dto.setNroedicion(Integer.parseInt(request.getParameter("nroedicion")));

		dto.setPrecio(Double.parseDouble(request.getParameter("precio")));

		dto.setStock(Integer.parseInt(request.getParameter("stock")));

		dto.setIdtipo(request.getParameter("idtipo"));

		if ("insertar".equals(accion)) {

			service.insertar(dto);

		}

		if ("actualizar".equals(accion)) {

			service.actualizar(dto);

		}

		response.sendRedirect("publicaciones");

	}

}