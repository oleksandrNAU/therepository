package com.oleksandr.spring.models.services;

import java.util.List;

import com.oleksandr.spring.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public  Cliente save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void delete(Long id);
	
	
}
