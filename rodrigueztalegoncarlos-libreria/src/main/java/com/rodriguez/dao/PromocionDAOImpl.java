package com.rodriguez.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.rodriguez.model.Promocion;
import com.rodriguez.util.DBUtils;

public class PromocionDAOImpl implements PromocionDAO{

@Override
public Promocion obtenerPorCantidad(int cantidad){

Session session=
DBUtils.creadorSessionFactory().openSession();

Query<Promocion> query=
session.createQuery(

"from Promocion where :cant between cantidadMin and cantidadMax",

Promocion.class
);

query.setParameter("cant",cantidad);

Promocion promo=
query.uniqueResult();

session.close();

return promo;

}

}