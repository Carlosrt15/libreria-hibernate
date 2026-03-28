package com.rodriguez.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rodriguez.model.Tipo;
import com.rodriguez.util.DBUtils;

public class TipoDAOImpl implements TipoDAO {

	@Override
	public void insertar(Tipo tipo) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.save(tipo);

		tx.commit();

		session.close();

	}

	@Override
	public void actualizar(Tipo tipo) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.merge(tipo);

		tx.commit();

		session.close();

	}

	@Override
	public Tipo obtener(String id) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Tipo tipo = session.get(Tipo.class, id);

		session.close();

		return tipo;

	}

	@Override
	public List<Tipo> listar(String id, String descripcion) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		String hql = "from Tipo where 1=1";

		if (id != null && !id.isEmpty()) {

			hql += " and idtipo like :id";

		}

		if (descripcion != null && !descripcion.isEmpty()) {

			hql += " and descripcion like :desc";

		}

		Query<Tipo> query = session.createQuery(hql, Tipo.class);

		if (id != null && !id.isEmpty()) {

			query.setParameter("id", "%" + id + "%");

		}

		if (descripcion != null && !descripcion.isEmpty()) {

			query.setParameter("desc", "%" + descripcion + "%");

		}

		List<Tipo> lista = query.list();

		session.close();

		return lista;

	}

}