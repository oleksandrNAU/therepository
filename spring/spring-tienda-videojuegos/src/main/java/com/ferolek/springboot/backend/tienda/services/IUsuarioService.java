package com.ferolek.springboot.backend.tienda.services;

import java.util.List;

import com.ferolek.springboot.backend.tienda.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public  Usuario save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);
	

}
