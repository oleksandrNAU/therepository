// default package
// Generated 29-ene-2020 16:05:53 by Hibernate Tools 5.4.7.Final
package com.fran.eoihibernate2;
/**
 * Fran
 */
public class Libros implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Autores autores;
	private String titulo;

	public Libros() {
	}

	public Libros(int id) {
		this.id = id;
	}

	public Libros(int id, Autores autores, String titulo) {
		this.id = id;
		this.autores = autores;
		this.titulo = titulo;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Autores getAutores() {
		return this.autores;
	}

	public void setAutores(Autores autores) {
		this.autores = autores;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
