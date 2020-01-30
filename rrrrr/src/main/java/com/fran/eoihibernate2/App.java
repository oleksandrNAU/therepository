package com.fran.eoihibernate2;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App {
	static SessionFactory sessionFactory = null;
	static Session session = null;

	public static void main(String[] args) {
		//@SuppressWarnings("unused")
		//org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		//java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		// Crear la conexión con la base de datos
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		// probar la conexion
		if (session != null) {
			System.out.println("Sesión abierta");
		} else {
			System.out.println("Fallo en la sesión");
		}
		Query<Libros> consulta = session.createQuery("from Libros");
		List<Libros> resultados = consulta.list();

		for (Object resultado : resultados) {
			Libros libro = (Libros) resultado;
			System.out.println(libro.getId() + ": " 
			+ libro.getTitulo() + ", de " 
					+ libro.getAutores().getNombre());
		}

		// Cerramos la sesión
		session.close();
	}
}
