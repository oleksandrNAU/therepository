package com.ferolek.springboot.backend.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferolek.springboot.backend.tienda.dao.IUsuarioDAO;
import com.ferolek.springboot.backend.tienda.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll(){
		return (List<Usuario>) usuarioDao.findAll();
		
	}
	

	
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
		
	}
	
	@Override
	@Transactional
	public Usuario existeUsuario(String username, String password) {
		return usuarioDao.existeUsuario(username, password).orElse(new Usuario((long) -1.0));
		
	}
	
	@Override
	@Transactional
	public void delete2(Long usuarios,Long juegos) {
	 	usuarioDao.deleteById2(usuarios,juegos);
		
	}
	
	
	
}
