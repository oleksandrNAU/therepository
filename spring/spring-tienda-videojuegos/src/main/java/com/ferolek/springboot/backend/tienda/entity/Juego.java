package com.ferolek.springboot.backend.tienda.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



import com.ferolek.springboot.backend.tienda.entity.Usuario;

@Entity
@Table(name="juegos") 
public class Juego implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String plataforma;
	private String URL;
	private String imagen;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_tiene_juegos", schema = "public", joinColumns = {
			@JoinColumn(name = "juegos", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "usuarios", nullable = false, updatable = false) })
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	
	public Juego() {
		
		
	}
	
	public Juego(Long id, String titulo, String plataforma, String uRL, String imagen, Set<Usuario> usuarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.plataforma = plataforma;
		URL = uRL;
		this.imagen = imagen;
		this.usuarios = usuarios;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
