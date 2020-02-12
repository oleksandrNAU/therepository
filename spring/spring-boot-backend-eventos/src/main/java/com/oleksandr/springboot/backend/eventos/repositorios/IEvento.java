package com.oleksandr.springboot.backend.eventos.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oleksandr.springboot.backend.eventos.entidades.Evento;

@RepositoryRestResource(path="eventos",collectionResourceRel="eventos")
public interface IEvento extends JpaRepository<Evento,Integer> {

}
