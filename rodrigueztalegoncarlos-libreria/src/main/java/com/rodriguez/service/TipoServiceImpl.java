package com.rodriguez.service;

import java.util.ArrayList;
import java.util.List;

import com.rodriguez.dao.TipoDAO;
import com.rodriguez.dao.TipoDAOImpl;

import com.rodriguez.dto.TipoDTO;

import com.rodriguez.model.Tipo;

public class TipoServiceImpl implements TipoService {

	private TipoDAO dao = new TipoDAOImpl();

	@Override
	public void insertar(TipoDTO dto) {

		if (dao.obtener(dto.getIdtipo()) != null) {

			return;

		}

		Tipo tipo = new Tipo();

		tipo.setIdtipo(dto.getIdtipo());

		tipo.setDescripcion(dto.getDescripcion());

		dao.insertar(tipo);

	}

	@Override
	public void actualizar(TipoDTO dto) {

		Tipo tipo = dao.obtener(dto.getIdtipo());

		if (tipo == null) {

			return;

		}

		tipo.setDescripcion(dto.getDescripcion());

		dao.actualizar(tipo);

	}

	@Override
	public List<TipoDTO> listar(String id, String descripcion) {

		List<Tipo> lista = dao.listar(id, descripcion);

		List<TipoDTO> dtoLista = new ArrayList<>();

		for (Tipo t : lista) {

			TipoDTO dto = new TipoDTO();

			dto.setIdtipo(t.getIdtipo());

			dto.setDescripcion(t.getDescripcion());

			dtoLista.add(dto);

		}

		return dtoLista;

	}

}