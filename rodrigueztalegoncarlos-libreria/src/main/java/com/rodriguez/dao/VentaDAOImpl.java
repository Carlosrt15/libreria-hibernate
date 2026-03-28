package com.rodriguez.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rodriguez.model.Venta;
import com.rodriguez.model.Publicacion;
import com.rodriguez.model.Empleado;
import com.rodriguez.model.Promocion;

import com.rodriguez.util.DBUtils;

public class VentaDAOImpl implements VentaDAO {

	@Override

	public void insertarVenta(

			String idventa, String cliente, int cantidad, String idpublicacion, int idempleado) {

		Session session =

				DBUtils.creadorSessionFactory().openSession();

		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			Publicacion pub =

					session.get(Publicacion.class, idpublicacion);

			Empleado emp =

					session.get(Empleado.class, idempleado);

			if (pub.getStock() < cantidad) {

				throw new RuntimeException("No hay stock suficiente");

			}

			Query<Promocion> query =

					session.createQuery(

							"from Promocion p where :cantidad between p.cantmin and p.cantmax",

							Promocion.class

					);

			query.setParameter("cantidad", cantidad);

			Promocion promo = query.uniqueResult();

			double precio = pub.getPrecio() * cantidad;

			double dcto = 0;

			if (promo != null) {

				dcto = precio * (promo.getPorcentaje() / 100);

			}

			double impuesto =

					(precio - dcto) * 0.04;

			Venta venta = new Venta();

			venta.setIdventa(idventa);

			venta.setCliente(cliente);

			venta.setCantidad(cantidad);

			venta.setPrecio(precio);

			venta.setDcto(dcto);

			venta.setImpuesto(impuesto);

			venta.setPublicacion(pub);

			venta.setEmpleado(emp);

			venta.setFecha(new java.util.Date());

			pub.setStock(

					pub.getStock() - cantidad

			);

			session.update(pub);

			session.save(venta);

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {

				tx.rollback();

			}

			e.printStackTrace();

		} finally {

			session.close();

		}

	}

	@Override

	public List<Venta> listar(

			String id, String cliente, String empleado) {

		Session session =

				DBUtils.creadorSessionFactory().openSession();

		String hql =

				"select v from Venta v " + "join fetch v.publicacion " + "join fetch v.empleado " + "where 1=1";

		if (id != null && !id.isEmpty()) {

			hql += " and v.idventa like :id";

		}

		if (cliente != null && !cliente.isEmpty()) {

			hql += " and v.cliente like :cliente";

		}

		if (empleado != null && !empleado.isEmpty()) {

			hql += " and v.empleado.idempleado=:emp";

		}
		
		// Ordena por id bien 
		
		hql+=" order by v.idventa";

		Query<Venta> query =

				session.createQuery(hql, Venta.class);

		if (id != null && !id.isEmpty()) {

			query.setParameter(

					"id", "%" + id + "%"

			);

		}

		if (cliente != null && !cliente.isEmpty()) {

			query.setParameter(

					"cliente", "%" + cliente + "%"

			);

		}

		if (empleado != null && !empleado.isEmpty()) {

			query.setParameter(

					"emp", Integer.parseInt(empleado)

			);

		}

		List<Venta> lista =

				query.list();

		session.close();

		return lista;

	}

}