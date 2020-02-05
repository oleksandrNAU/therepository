package com.oleksandr.jdbcpgej;

/**
 *Oleksandr Naumov
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App 
{	static final String db = "jdbc:postgresql://localhost:5433/Deporte";
	static final String user = "postgres";
	static final String pass = "benidorm33";
public static void arrancar(){
	 try {
	    	try {   Class.forName("org.postgresql.Driver");}
	    	catch (ClassNotFoundException ex) {
			    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
	    		    Connection conn = DriverManager.getConnection(db, user, pass);
	    		    Statement st = conn.createStatement();
	    		    st.executeQuery("drop table if exists deporte,deportistas");    		    
	    			}catch (java.sql.SQLException sqle) {
	                System.out.println("Error: " + sqle);
	            }
	    try {
	    	try {   Class.forName("org.postgresql.Driver");}
	    	catch (ClassNotFoundException ex) {
			    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
	    		    Connection conn = DriverManager.getConnection(db, user, pass);
	    		    Statement st = conn.createStatement();
	    		    st.executeQuery("create table deporte (cod integer PRIMARY KEY,nombre varchar(60))");
	    			}catch (java.sql.SQLException sqle) {
	                System.out.println("Error: " + sqle);
	            }
	    try {
	    	try {   Class.forName("org.postgresql.Driver");}
	    	catch (ClassNotFoundException ex) {
			    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
	    		    Connection conn = DriverManager.getConnection(db, user, pass);
	    		    Statement st = conn.createStatement();
	    		    st.executeQuery("create table deportistas (cod integer PRIMARY KEY,nombre varchar(60),codDeporte integer references deporte(cod))");
	    			}catch (java.sql.SQLException sqle) {
	                System.out.println("Error: " + sqle);
	            }
	    try {
	    	try {   Class.forName("org.postgresql.Driver");}
	    	catch (ClassNotFoundException ex) {
			    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
	    		    Connection conn = DriverManager.getConnection(db, user, pass);
	    		    Statement st = conn.createStatement();
	    		    st.executeQuery("insert into deporte values(1,'Baloncesto'),(2,'Futbol'),(3,'Rugby'),(4,'Tenis')");	
	    		    
	    			}catch (java.sql.SQLException sqle) {
	                System.out.println("Error: " + sqle);
	            }
	    try {
	    	try {   Class.forName("org.postgresql.Driver");}
	    	catch (ClassNotFoundException ex) {
			    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
	    		    Connection conn = DriverManager.getConnection(db, user, pass);
	    		    Statement st = conn.createStatement();
	    		    st.executeQuery("insert into deportistas values(1,'Juan Miguel',1),(2,'Francisco',1),(3,'Miguel de santa fe',4),(4,'Kobe bronco',3),(5,'Don Pom',NULL)");
	 
	    			}catch (java.sql.SQLException sqle) {
	                System.out.println("Error: " + sqle);
	            }
	    
	    
	    
	    
}

	public static void insertarDeporte() throws SQLException {
		Scanner sc = new Scanner(System.in);
		  System.out.println("Inserte el nombre de deporte : ");
		  String nombre=sc.next();
		  System.out.println("Inserte el código del deporte: ");
		  int cod=sc.nextInt();
		  
		    	try {   Class.forName("org.postgresql.Driver");}
		    	catch (ClassNotFoundException ex) {
				    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
				}
		    		    Connection conn = DriverManager.getConnection(db, user, pass);
		    		    Statement st = conn.createStatement();
		    		    st.executeQuery("insert into deporte values("+cod+",'"+nombre+"')");
		    	return ;
	}
	
	
	
	private static boolean insertDep(int cod,String nombre) 
			throws SQLException { 
				boolean ok = true;
				try (Connection conn = DriverManager.getConnection(db, user, pass)) {
					conn.setAutoCommit(false);
					try {
						PreparedStatement st = conn.prepareStatement("insert into deporte values(?, ?)",Statement.RETURN_GENERATED_KEYS);
						st.setInt(1, cod);
						st.setString(2, nombre);
						st.executeUpdate();
					
					
						// Aquí insertaríamos el producto
						conn.commit(); // Todo ok!
						} 
					catch (SQLException ex) {
						System.err.println(ex.getMessage());conn.rollback(); // Error!
						ok = false;}}
				return ok;}
	
	
	
    public static void main( String[] args ) throws SQLException 
    {  
    		//arrancar();
    		//insertarDeporte();
    		//insertDep(90,"Haltero");
}
    }
