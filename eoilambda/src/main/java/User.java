/**
 * 
 */

/**
 * @author formacion
 *
 */
public class User {

	private int id;
	private String nombre;
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	public  User(String nombre, int id) {
		super();
		this.nombre= nombre;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
