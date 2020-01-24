package eoi.jdbc_product_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	static final String db = "jdbc:mysql://localhost:3306/eoi2?serverTimezone=UTC";
	static final String user = "root";
	static final String pass = "";
	
    public static void main( String[] args )
    {
    	lanzar();
    	
    	
    	
    }
    
    
	public static void lanzar() {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Crear categoría: ");
		  System.out.println("1.Listar las categorías");
		  System.out.println("2.Listar los empleados que tengan al menos 40 años contratados antes del 1 de enero de 1998");
		  System.out.println("3.Crear un nuevo departamento ");
		  System.out.println("4.Salir ");
		  Integer name = sc.nextInt();
		  if(name==1) {
			  ej1();
			  lanzar();
		  }
		  if(name==2) {
			  ej2();
			  lanzar();
		  }
		  if(name==3) {
			  insertProducto();
			  lanzar();
			  
		  }
		  if(name==4) {
			  return;
			  
		  }
		  else {
			  System.out.println("Número introducido no existe");
			  
			  lanzar();
		  }
			
	}
	
	private static boolean insertCategoriaProducto(String categoria, String referencia, String nombre,  double precio) 
	throws SQLException { 
		boolean ok = true;
		try (Connection conn = DriverManager.getConnection(db, user, pass)) {
			conn.setAutoCommit(false);
			try {
				PreparedStatement st = conn.prepareStatement("insert into category values(?, ?)",Statement.RETURN_GENERATED_KEYS);
				st.setString(1, categoria);
				st.executeUpdate();
				ResultSet keys = st.getGeneratedKeys();
				keys.first();
				int idCategoria = keys.getInt(1);
				// Aquí insertaríamos el producto
				conn.commit(); // Todo ok!
				} 
			catch (SQLException ex) {
				System.err.println(ex.getMessage());conn.rollback(); // Error!
				ok = false;}}
		return ok;}
	
			
		
	
	
	
	
	public static void ej2() {
		
		
		try(Connection conn = DriverManager.getConnection(db, user, pass); 
			PreparedStatement st = conn.prepareStatement("select * from empleados where edad>=? AND YEAR(contrato)<?")){
			st.setInt(1,40);
			st.setInt(2,1998);
			//st.setInt(3,01);
			//st.setInt(4,1998);
		
		try (ResultSet rs = st.executeQuery())
			{int n=1;
				while(rs.next()) {
					
					System.out.println("Fila  "+n+" : "+ rs.getInt("num")+" "+ rs.getString("nombre")+" "+
							rs.getInt("edad")+" "+ rs.getInt("departamento")+" "+ rs.getInt("categoria")+" "+ rs.getDate(6));
					n++;
					}
			}
		}catch (SQLException ex) {
			System.err.println(ex.getMessage());
			}
	}
	
	
	
	
	private static void insertProducto() { 
		
	Scanner sc = new Scanner(System.in);
	  System.out.println("Inserte el nombre de departamento : ");
	  String nombre=sc.next();
	  System.out.println("Inserte el numero de departamento: ");
	  int deptno=sc.nextInt();
	 try(Connection conn = DriverManager.getConnection(db, user, pass);
			
			PreparedStatement st = conn.prepareStatement("insert into departamentos values( ?, ?)", Statement.RETURN_GENERATED_KEYS);)
		{
		st.setInt(1, deptno);
		st.setString(2, nombre);
		int filas = st.executeUpdate();
		if(filas > 0) {
			ResultSet keys = st.getGeneratedKeys();keys.first();
		} 
		} 
	
	
	catch (SQLException se){
	    System.out.println(se.getMessage());
	}
	try(Connection conn = DriverManager.getConnection(db, user, pass); 
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from departamentos")){
				while(rs.next()) {
					
					System.out.println("Departamento número "+ rs.getInt("deptno")+" :"+ rs.getString("nombre"));
					}
			}
		catch (SQLException ex) {
			System.err.println(ex.getMessage());
			}
	try(Connection conn = DriverManager.getConnection(db, user, pass);
			PreparedStatement st = conn.prepareStatement("delete from departamentos where deptno = ? ");) {
		st.setInt(1, deptno);
		
		int filas = st.executeUpdate();
		}
	catch (SQLException ex) {
		System.err.println(ex.getMessage());}
	}
	
	
	@Override
	public String toString() {
		return "JDBC [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
