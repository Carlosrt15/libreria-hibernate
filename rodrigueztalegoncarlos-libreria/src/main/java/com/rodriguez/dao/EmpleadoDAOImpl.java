package com.rodriguez.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.rodriguez.model.Empleado;
import com.rodriguez.util.DBUtils;

public class EmpleadoDAOImpl implements EmpleadoDAO {

	@Override
	public List<Empleado> listar() {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Query<Empleado> query = session.createQuery("from Empleado where activo=1", Empleado.class);

		List<Empleado> lista = query.list();

		session.close();

		return lista;

	}

}