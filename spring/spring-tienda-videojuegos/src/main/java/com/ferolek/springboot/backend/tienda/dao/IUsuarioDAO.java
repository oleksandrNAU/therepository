package com.ferolek.springboot.backend.tienda.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ferolek.springboot.backend.tienda.entity.Usuario;
public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
	
	@Query(value="Select * from usuarios where username = ?1 and password = ?2", nativeQuery = true)
	Optional<Usuario> existeUsuario(@Param("username") String username, @Param("password") String password);

	@Modifying
	@Query(value="Delete from usuario_tiene_juegos where usuarios = ?1 and juegos = ?2", nativeQuery=true)
	void deleteById2(@Param("usuarios") Long usuarios,@Param("juegos") Long juegos);
	
	
	
}
