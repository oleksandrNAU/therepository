package eoi.hibernateej;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fran.eoihibernate2.Autores;
import com.fran.eoihibernate2.Libros;

/**
 * Hello world!
 *
 */
public class App {
	static SessionFactory sessionFactory = null;
	static Session session = null;

	public static void verLibros() {
		// probar la conexion
		/*
		 * if (session != null) { System.out.println("Sesión abierta"); } else {
		 * System.out.println("Fallo en la sesión"); }
		 */
		// Crear la conexión con la base de datos
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		Query<Libros> consulta = session.createQuery("from Libros");
		List<Libros> resultados = consulta.list();

		for (Object resultado : resultados) {
			Libros libro = (Libros) resultado;
			System.out.println(libro.getId() + ": " + libro.getTitulo() + ", de " 
			+ (libro.getAutores()!=null?libro.getAutores().getNombre():"Anónimo"));
		}
		// Cerramos la sesión
		session.close();
	}

/*	public static void insertarLibro() {
		// Crear la conexión con la base de datos
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Libros libro = new Libros(5, new Autores("WSHAK"), "Romeo y Julieta");
		session.save(libro);
		trans.commit();
		// Cerramos la sesión
		session.close();
	}*/

/*	public static void insertarAutoryLibro() {
		// Crear la conexión con la base de datos
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		Transaction trans = session.beginTransaction();

		Autores autor = new Autores("ELIAB", "Hibernate", null);
		session.save(autor);
		Libros libro1 = new Libros(6, autor, "Libro Eliab1");
		Libros libro2 = new Libros(7, autor, "Libro Eliab2");
		session.save(libro1);
		session.save(libro2);
		trans.commit();

		// Cerramos la sesión
		session.close();
	}*/

	/*public static void actualizarAutor(String codautor) {
		// Crear la conexión con la base de datos
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		
        Query consulta = session.createQuery("FROM Autores WHERE cod='" + codautor + "'");
        List resultados = consulta.list();
        Transaction trans = session.beginTransaction();
        Autores autorAModificar = (Autores) resultados.get(0);
        autorAModificar.setNombre("Eliab el Grande");
        session.update(autorAModificar);
		trans.commit();

		// Cerramos la sesión
		session.close();
	}*/
	
	/*public static void borrarAutor(String codautor) {
		// Crear la conexión con la base de datos
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		
        Query consulta = session.createQuery("FROM Autores WHERE cod='" + codautor + "'");
        List resultados = consulta.list();
        Transaction trans = session.beginTransaction();
        Autores autorABorrar = (Autores) resultados.get(0);
        autorABorrar.getLibros().forEach(libro->libro.setAutores(null)); // Pone la FK a null
        session.delete(autorABorrar);
		trans.commit();

		// Cerramos la sesión
		session.close();
	}*/
	
/*	public static void buscarAutores(String patron) {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		List<Autores> autores = session.createNativeQuery(
				"Select * from autores where nombre like :name")
				.addEntity(Autores.class)
				.setParameter("name", "%" + patron + "%")
				.list();
		for(Autores autor: autores) {
			System.out.println(autor.getNombre());
		}
		
		session.close();
	}*/
	
	

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

		//verLibros();
		// insertarLibro();
		//insertarAutoryLibro();
		//actualizarAutor("ELIAB");
		//borrarAutor("ELIAB");
		verLibros();
		//buscarAutores("a");
	}
}
