package com.oleksandr.spring.models.dao;



import org.springframework.data.repository.CrudRepository;

import com.oleksandr.spring.models.entity.Cliente;
public interface IclienteDAO extends CrudRepository<Cliente, Long> {

	
}
