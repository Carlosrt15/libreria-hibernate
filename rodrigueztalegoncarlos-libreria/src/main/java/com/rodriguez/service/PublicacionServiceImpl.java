package com.rodriguez.service;

import java.util.List;

import com.rodriguez.dao.PublicacionDAO;
import com.rodriguez.dao.PublicacionDAOImpl;

import com.rodriguez.dao.TipoDAO;
import com.rodriguez.dao.TipoDAOImpl;

import com.rodriguez.dto.PublicacionDTO;

import com.rodriguez.model.Publicacion;
import com.rodriguez.model.Tipo;

public class PublicacionServiceImpl implements PublicacionService {

	private PublicacionDAO dao = new PublicacionDAOImpl();

	private TipoDAO tipoDAO = new TipoDAOImpl();

	@Override
	public void insertar(PublicacionDTO dto) {

		Tipo tipo = tipoDAO.obtener(dto.getIdtipo());

		Publicacion pub = new Publicacion();

		pub.setIdpublicacion(dto.getIdpublicacion());

		pub.setTitulo(dto.getTitulo());

		pub.setAutor(dto.getAutor());

		pub.setNroedicion(dto.getNroedicion());

		pub.setPrecio(dto.getPrecio());

		pub.setStock(dto.getStock());

		pub.setTipo(tipo);

		dao.insertar(pub);

	}

	@Override
	public List<Publicacion> listar() {

		return dao.listar();

	}

	@Override
	public void actualizar(PublicacionDTO dto) {

		Tipo tipo = tipoDAO.obtener(dto.getIdtipo());

		Publicacion pub = new Publicacion();

		pub.setIdpublicacion(dto.getIdpublicacion());

		pub.setTitulo(dto.getTitulo());

		pub.setAutor(dto.getAutor());

		pub.setNroedicion(dto.getNroedicion());

		pub.setPrecio(dto.getPrecio());

		pub.setStock(dto.getStock());

		pub.setTipo(tipo);

		dao.actualizar(pub);

	}

}