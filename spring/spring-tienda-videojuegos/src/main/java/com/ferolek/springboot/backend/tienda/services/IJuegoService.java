package com.ferolek.springboot.backend.tienda.services;

import java.util.List;

import com.ferolek.springboot.backend.tienda.entity.Juego;

public interface IJuegoService {
	
	
	public List<Juego> findAll();
	
	public  Juego save(Juego juego);
	
	public Juego findById(Long id);
	
	public void delete(Long id);

}
