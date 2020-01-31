package com.oleksandr.hibernateej2;

import java.util.InputMismatchException;
/**
 * Hello world!
 *
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import java.util.Scanner;

@SuppressWarnings("deprecation")
public class App 
{	
	static SessionFactory sessionFactory = null;
	static Session session = null;
	static int numer;
	static Scanner sc=new Scanner(System.in) ;
	
	
	
public static void verSeries() {
	// probar la conexion
	/*
	 * if (session != null) { System.out.println("Sesión abierta"); } else {
	 * System.out.println("Fallo en la sesión"); }
	 */
	// Crear la conexión con la base de datos
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();

	Query<Series> consulta = session.createQuery("from Series");
	List<Series> resultados = consulta.list();

	for (Object resultado : resultados) {
		Series serie = (Series) resultado;
		System.out.println(serie.getCodSeries() + ": " + serie.getNombre() + ", de " 
		+ (serie.getCadenas()!=null?serie.getCadenas().getNombre():null)+"  con una duración de "+(serie.getDuracion())+" minutos");
	}
	// Cerramos la sesión
	session.close();
}

public static void insertarCadena() {
	// Crear la conexión con la base de datos
	Scanner sc2=new Scanner(System.in) ;
	System.out.println("Introduzca código de cadena: ");
	String cod=sc2.next();	
	Scanner sc3=new Scanner(System.in) ;
	System.out.println("Introduzca nombre de cadena: ");
	String nombre=sc3.nextLine();
	
	
	System.out.println(" --------------------------------- ");
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();
	Transaction trans = session.beginTransaction();
	Cadenas cadena = new Cadenas(cod, nombre, null);
	session.save(cadena);
	trans.commit();
	// Cerramos la sesión
	session.close();
}

public static void insertarSerie() {
	// Crear la conexión con la base de datos
	Scanner sc2=new Scanner(System.in) ;
	System.out.println("Introduzca código de serie: ");
	int cod=sc2.nextInt();	
	Scanner sc3=new Scanner(System.in) ;
	System.out.println("Introduzca nombre de la serie: ");
	String nombre=sc3.nextLine();
	Scanner sc4=new Scanner(System.in) ;
	System.out.println("Introduzca código de la cadena: ");
	String cadena=sc4.nextLine();
	Scanner sc5=new Scanner(System.in) ;
	System.out.println("Introduzca duración de la serie: ");
	int duracion=sc5.nextInt();
	
	System.out.println(" --------------------------------- ");
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();
	Transaction trans = session.beginTransaction();
	Series serie = new Series(cod,new Cadenas(cadena), nombre, duracion,null);
	session.save(serie);
	trans.commit();
	// Cerramos la sesión
	session.close();
}

public static void insertarActor() {
	// Crear la conexión con la base de datos
	Scanner sc2=new Scanner(System.in) ;
	System.out.println("Introduzca código de actor: ");
	int cod=sc2.nextInt();	
	Scanner sc3=new Scanner(System.in) ;
	System.out.println("Introduzca nombre de actor: ");
	String nombre=sc3.nextLine();
	Scanner sc4=new Scanner(System.in) ;
	System.out.println("Introduzca apellido de actor: ");
	String apellido=sc4.nextLine();
	Scanner sc5=new Scanner(System.in) ;
	System.out.println("Introduzca series que participo actor: ");
	String duracion=sc5.nextLine();
	
	System.out.println(" --------------------------------- ");
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();
	Transaction trans = session.beginTransaction();
	Series d=new Series();
	Actores actor = new Actores(cod, nombre, apellido ,);
	session.save(actor);
	trans.commit();
	// Cerramos la sesión
	session.close();
}

public static void actualizarSerie() {
	// Crear la conexión con la base de datos
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();
	Scanner sc2=new Scanner(System.in) ;
	System.out.println("Introduzca código de serie a modificar: ");
	int cod=sc2.nextInt();	
	Scanner sc3=new Scanner(System.in) ;
	System.out.println("Introduzca el nuevo nombre de la serie: ");
	String nombre=sc3.nextLine();
	Scanner sc4=new Scanner(System.in) ;
	System.out.println("Introduzca nueva duracion de la serie: ");
	int duracion=sc4.nextInt();
	
    Query consulta = session.createQuery("FROM Series WHERE cod_series='" + cod + "'");
    List resultados = consulta.list();
    Transaction trans = session.beginTransaction();
    Series serieModificar = (Series) resultados.get(0);
    serieModificar.setNombre(nombre);
    serieModificar.setDuracion(duracion);
    session.update(serieModificar);
	trans.commit();

	// Cerramos la sesión
	session.close();
}

public static void actualizarCadena() {
	// Crear la conexión con la base de datos
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();
	Scanner sc2=new Scanner(System.in) ;
	System.out.println("Introduzca código de la cadena a modificar: ");
	String cod=sc2.next();	
	Scanner sc3=new Scanner(System.in) ;
	System.out.println("Introduzca el nuevo nombre de la cadena: ");
	String nombre=sc3.nextLine();
	
    Query consulta = session.createQuery("FROM Cadenas WHERE cod='" + cod + "'");
    List resultados = consulta.list();
    Transaction trans = session.beginTransaction();
    Cadenas cadenaModificar = (Cadenas) resultados.get(0);
    cadenaModificar.setNombre(nombre);
    session.save(cadenaModificar);
	trans.commit();

	// Cerramos la sesión
	session.close();
}

public static void borrarSerie() {
	// Crear la conexión con la base de datos
	Scanner sc2=new Scanner(System.in) ;
	System.out.println("Introduzca código de la serie que quiere borrar: ");
	int cod=sc2.nextInt();	
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();
	
	
	try {
    Query consulta = session.createQuery("FROM Series WHERE cod_series=" + cod );
    List resultados = consulta.list();
    Series serieaBorrar = (Series) resultados.get(0);
    if(serieaBorrar!=null) {
    	Scanner sc3=new Scanner(System.in) ;
    	System.out.println("¿Esta seguro de borrar esta serie: "+serieaBorrar.getNombre()+" (S/N)?");
    	String decision = sc3.nextLine().toUpperCase();
    	if(decision.equals("S")) {
    Transaction trans = session.beginTransaction();
    session.delete(serieaBorrar);
	trans.commit();
	System.out.println("Borrada la serie ;)");}
	}
    else{System.out.println("No existe ninguna serie con ese código");}
    }
  catch(Exception e) {
	  System.out.println("ERROR 455: Serie no borrada ");
  }
	// Cerramos la sesión
	session.close();
}



public static void borrarEspaciosNombresSeries() {
// TODO Auto-generated method stub
	Scanner sc2=new Scanner(System.in) ;
	System.out.println("Introduzca código de la serie a la que quiere corregir espacios: ");
	int cod=sc2.nextInt();	
	sessionFactory = new Configuration().configure().buildSessionFactory();
	session = sessionFactory.openSession();
	
	try {
		Query<Series> consulta = session.createQuery("from Series where cod_series="+cod);
		List<Series> resultados = consulta.list();
		System.out.println("Imprimiendo original... ["+resultados.get(0).getNombre()+"]");
		System.out.println("Imprimiendo con TRIM... ["+resultados.get(0).getNombre().trim()+"]");
	   
	
	
    	
		
	  }
	  catch(Exception e) {
	 System.out.println("ERROR 455: Serie no encontrada ");
	 }
		// Cerramos la sesión
		session.close();
	
}



public static void menu() {
	boolean salir = false;
	while(!salir){
		System.out.println("Elija una opción del menú");
		System.out.println("1. Ver series listadas");
		System.out.println("2.Insertar cadena nueva");
		System.out.println("3. Insertar nueva serie");
		System.out.println("4. Actualizar datos serie");
		System.out.println("5. Actualizar nombre cadena");
		System.out.println("6. Borrar serie");
		System.out.println("7. Borrar espacios");
		System.out.println("0. Salir");
		
		try {
			
			numer=sc.nextInt();
		switch(numer){
        case 1:
        	verSeries();
            break;
        case 2:
            insertarCadena();          
            break;
         case 3:
            insertarSerie();
            break;
         case 4:
             actualizarSerie();
             break;
         case 5:
             actualizarCadena();
             break;
         case 6:
             borrarSerie();
             break;
         case 7:
             borrarEspaciosNombresSeries();
             break;
         case 0:
            salir=true;
            break;
         default:
            System.out.println("Solo números entre 0 y 6");
    }
        
    }
		catch (InputMismatchException e) {
	        System.out.println("Debes insertar un número");
	        sc.next();
	    }}
	
    
	
		
	
}



	public static void main( String[] args )
    {
    	@SuppressWarnings("unused")
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
		
	menu();
       
    }
}
