package com.ferolek.springboot.backend.tienda.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ferolek.springboot.backend.tienda.entity.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
