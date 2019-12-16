package com.oleksandr.eoi16_12;

public class Persona {
	//cada instancia valor diferente eso es de instancia
	//valor compartido es atributo de clase;
	
	//Atributos
	private int edad;
	private String nombre;
	private String dni;
	private String titulacion;
	
	private static int cantidadAlumnos; //unica para todos
	//Constructores
	public Persona() {// constructor vacío
		
	}

	public Persona(int edad, String nombre, String dni, String titulacion) {// constructor con argumentos
	
		this.edad = edad;
		this.nombre = nombre;
		this.dni = dni;
		this.titulacion = titulacion;
	}
	//constructor de copia
	public Persona(Persona p) {
		this.edad = p.edad;
		this.nombre = p.nombre;
		this.dni = p.dni;
		this.titulacion = p.titulacion;
	}

	
	//Getters and setters
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public String toString() {
		return "Persona [edad=" + edad + ", nombre=" + nombre + ", dni=" + dni + ", titulacion=" + titulacion + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		return true;
	}

	
	
}
