package com.ferolek.springboot.backend.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferolek.springboot.backend.tienda.entity.Juego;

public interface JuegosRepository extends JpaRepository<Juego, Long>{

}
