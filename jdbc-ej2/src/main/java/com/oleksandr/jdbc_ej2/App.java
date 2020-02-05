package com.oleksandr.jdbc_ej2;

/**
 * Oleksandr Naumov
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
{
	
	
	static final String db = "jdbc:mysql://localhost:3306/product-manager?serverTimezone=UTC";
	static final String user = "root";
	static final String pass = "";
	static final Connection conn = null;
	
	// EJ 4
	
	private static boolean insertCategoriaProducto(String categoria, String referencia, String nombre, double precio)
			throws SQLException {
		boolean ok = true;
		try (Connection conn = DriverManager.getConnection(db, user, pass)) {
			conn.setAutoCommit(false); // Desactivar el auto commit
			try {
				PreparedStatement st = conn.prepareStatement("insert into category values(NULL, ?)",
						Statement.RETURN_GENERATED_KEYS);
				st.setString(1, categoria);
				st.executeUpdate();

				ResultSet keys = st.getGeneratedKeys();
				keys.first();
				int idCategoria = keys.getInt(1);
				System.out.println("categoria insertada: " + idCategoria);
				// Aquí insertaríamos el producto
				PreparedStatement st2 = conn.prepareStatement(
						"insert into product(id,reference,name,price,category) values(NULL, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				st2.setString(1, referencia);
				st2.setString(2, nombre);
				st2.setDouble(3, precio);
				// st2.setInt(4, idCategoria+1); // Esto lo hace fallar
				st2.setInt(4, idCategoria);

				int filas = st2.executeUpdate();

				conn.commit(); // Todo ok!
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
				conn.rollback(); // Error!
				ok = false;
			}
		}
		return ok;
	}
	
	
	
	public static void selectFormateada() {
		try (Connection conn = DriverManager.getConnection(db, user, pass);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select * from category")) {

			while (rs.next()) {
				System.out.printf("\nCategoría número: "+ rs.getInt("id")+"  \nnombre "+ rs.getString("name")+"\n----------------");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	
	private static void borrarCategoria()
			throws SQLException {
		System.out.println("Buenos dias, seleccione una categoria a borrar");
		selectFormateada();
		Scanner sc=new Scanner(System.in);
		int categor= sc.nextInt();
		try (Connection conn = DriverManager.getConnection(db, user, pass)) {
			conn.setAutoCommit(false); // Desactivar el auto commit
			try {
				PreparedStatement st = conn.prepareStatement("delete from product where category = ?");
					st.setInt(1, categor);
					st.executeUpdate();
			
				PreparedStatement st2 = conn.prepareStatement("delete from category where id=?");
				st2.setInt(1, categor);
				st2.executeUpdate();

			//	ResultSet keys = st2.getGeneratedKeys();
				//keys.first();
				//int idCategoria = keys.getInt(1);
				//System.out.println("categoria borrada: " + idCategoria);
				// Aquí insertaríamos el producto

				conn.commit(); // Todo ok!
				System.out.println("Se ha borrado correctamente");
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
				conn.rollback(); // Error!
				
			}
		}
		
	}
	
	
	
	
	public static void conseguirProductos(int category) {
		String format = "%4d - %4.4s %-25.25s: %5.2f€\n";
		try (Connection conn = DriverManager.getConnection(db, user, pass);
				PreparedStatement st = conn.prepareStatement("select * from product where category = ? ")) {

			st.setInt(1, category); // category = 1
			try (ResultSet rs = st.executeQuery()) { // Dentro del try para que cierre el ResultSet
				while (rs.next()) {
					System.out.printf(format, rs.getInt("id"), rs.getString("reference"), rs.getString("name"),
							rs.getDouble("price"));
				}
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	
	
	
	private static boolean updateProducto(int id,  double precio) {
		try (Connection conn = DriverManager.getConnection(db, user, pass);
				PreparedStatement st = conn.prepareStatement(
						"update product set  price = ? where id = ?");) {
			st.setDouble(1, precio);
			st.setInt(2, id);

			int filas = st.executeUpdate();

			return filas > 0;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}
	
	
	// EJERCICIO 6
	
	public static void actualizarProducto() {
		System.out.println("Buenos dias, seleccione una categoria a borrar");
		selectFormateada();
		Scanner sc=new Scanner(System.in);
		int categor= sc.nextInt();
		conseguirProductos(categor);
		System.out.println("seleccione ID producto para actualizar:");
	    int sel= sc.nextInt();
	    System.out.println("seleccione el nuevo precio producto :");
	    double precio= sc.nextDouble();
	    updateProducto(sel, precio);
		
	}
	
	
    public static void main( String[] args ) 
    {
    	/*EJERCICIO 4
    	 * try {
    	insertCategoriaProducto("Jamon","4099","Placa_Madre",23.99);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
       /*EJERCICIO 5
        * 
        
    	try {
        	borrarCategoria();
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}*/
    	
    	
    	// EJERCICIO 6
    	actualizarProducto();
    }
}
