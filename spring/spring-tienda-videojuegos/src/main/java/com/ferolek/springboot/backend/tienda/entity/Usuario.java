package com.ferolek.springboot.backend.tienda.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



import com.ferolek.springboot.backend.tienda.entity.Juego;


@Entity
@Table(name="usuarios") 
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty(message="no puede estar vacio")
	@Size(min= 4,max=12, message="el tamaño tiene que estar entre 4 y 12")
	@Column(nullable=false, unique= true)
	private String username;
	
	@Column(nullable=false)
	@NotEmpty(message="no puede estar vacio")
	private String password;
	
	@NotEmpty(message="no puede estar vacio")
	@Email(message="no es una direccion de correo bien formanda")
	@Column(nullable=false, unique=true)
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_tiene_juegos", schema = "public", joinColumns = {
			@JoinColumn(name = "usuarios", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "juegos", nullable = false, updatable = false) })
	private Set<Juego> juegos = new HashSet<Juego>(0);
	
	
	public Usuario() {
	
	}
	public Usuario(Long id,
			@NotEmpty(message = "no puede estar vacio") @Size(min = 4, max = 12, message = "el tamaño tiene que estar esnte 4 y 12") String username,
			@NotEmpty(message = "no puede estar vacio") String password,
			@NotEmpty(message = "no puede estar vacio") @Email(message = "no es una direccion de correo bien formanda") String email,
			Set<Juego> juegos) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.juegos = juegos;
	}
	
	public Usuario(Long id) {
		this.id = id;
	}
	
	
	public Long getId() {
		return id;  
		} 
	public void setId(Long id) {
		this.id = id; 
		}

	
	public String getEmail() { 
		return email; 
		} 
	public void setEmail(String email) { 
		this.email = email;  
		}  
	
	@Column(name = "usuario", nullable = false, length = 100)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<Juego> getJuegos() {
		return juegos;
	}
	public void setJuegos(Set<Juego> juegos) {
		this.juegos = juegos;
	}


	private static final long serialVersionUID = 1L; 
}
