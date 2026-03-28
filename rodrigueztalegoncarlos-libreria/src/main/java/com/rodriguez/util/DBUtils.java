package com.rodriguez.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {

	private static SessionFactory sessionFactory;

	public static SessionFactory creadorSessionFactory() {

		if (sessionFactory == null) {

			try {

				sessionFactory = new Configuration().configure().buildSessionFactory();

			} catch (Throwable ex) {

				System.out.println("Error SessionFactory");

				throw new ExceptionInInitializerError(ex);

			}

		}

		return sessionFactory;

	}

}