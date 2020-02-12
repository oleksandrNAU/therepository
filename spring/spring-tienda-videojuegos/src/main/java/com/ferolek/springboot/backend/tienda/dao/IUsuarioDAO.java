package com.ferolek.springboot.backend.tienda.dao;
import org.springframework.data.repository.CrudRepository;

import com.ferolek.springboot.backend.tienda.entity.Usuario;
public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

}
