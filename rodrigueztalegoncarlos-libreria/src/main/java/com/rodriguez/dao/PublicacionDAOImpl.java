package com.rodriguez.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rodriguez.model.Publicacion;
import com.rodriguez.util.DBUtils;

public class PublicacionDAOImpl implements PublicacionDAO {

	@Override
	public void insertar(Publicacion pub) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.save(pub);

		tx.commit();

		session.close();

	}

	@Override
	public List<Publicacion> listar() {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Query<Publicacion> query = session.createQuery("from Publicacion", Publicacion.class);

		List<Publicacion> lista = query.list();

		session.close();

		return lista;

	}

	@Override
	public void actualizar(Publicacion pub) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.update(pub);

		tx.commit();

		session.close();

	}

	@Override
	public Publicacion obtener(String id) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		Publicacion pub = session.get(Publicacion.class, id);

		session.close();

		return pub;

	}

	@Override
	public List<Publicacion> filtrar(String id, String titulo, String autor, Integer edicion, Double precio,
			Integer stock, String idtipo) {

		Session session = DBUtils.creadorSessionFactory().openSession();

		String hql = "from Publicacion p where 1=1 ";

		if (id != null && !id.isEmpty())
			hql += " and p.idpublicacion like :id";

		if (titulo != null && !titulo.isEmpty())
			hql += " and p.titulo like :titulo";

		if (autor != null && !autor.isEmpty())
			hql += " and p.autor like :autor";

		if (edicion != null)
			hql += " and p.nroedicion=:edicion";

		if (precio != null)
			hql += " and p.precio>=:precio";

		if (stock != null)
			hql += " and p.stock>=:stock";

		if (idtipo != null && !idtipo.isEmpty())
			hql += " and p.tipo.idtipo=:idtipo";

		Query<Publicacion> query = session.createQuery(hql, Publicacion.class);

		if (id != null && !id.isEmpty())
			query.setParameter("id", "%" + id + "%");

		if (titulo != null && !titulo.isEmpty())
			query.setParameter("titulo", "%" + titulo + "%");

		if (autor != null && !autor.isEmpty())
			query.setParameter("autor", "%" + autor + "%");

		if (edicion != null)
			query.setParameter("edicion", edicion);

		if (precio != null)
			query.setParameter("precio", precio);

		if (stock != null)
			query.setParameter("stock", stock);

		if (idtipo != null && !idtipo.isEmpty())
			query.setParameter("idtipo", idtipo);

		List<Publicacion> lista = query.list();

		session.close();

		return lista;

	}

}