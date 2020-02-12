package com.ferolek.springboot.backend.tienda.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferolek.springboot.backend.tienda.entity.Juego;
import com.ferolek.springboot.backend.tienda.services.IJuegoService;


@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class JuegoRestController {
	
		
		@Autowired
		private IJuegoService juegoService;
		
		@GetMapping("/juegos")
		public List<Juego> index() {
			return juegoService.findAll();
		}
		
		@GetMapping("/juegos/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {
			
			Juego juego = null;
			Map<String, Object> response=new HashMap<>();
			
			try {
				juego=juegoService.findById(id);		
			}catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if(juego==null) {
				response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Juego>(juego,HttpStatus.OK);
			

		}
		
		@PostMapping("/juegos")
		public ResponseEntity<?> create(@Valid @RequestBody Juego juego, BindingResult result) {
			Juego juegoNew = null;
			Map<String, Object> response=new HashMap<>();
			
			
			if(result.hasErrors()) {
				List<String> errors=result.getFieldErrors()
						.stream()
						.map(err -> "'El campo '"+err.getField()+"' "+err.getDefaultMessage())
						.collect(Collectors.toList());
				
				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			
			try {
				juegoNew=juegoService.save(juego);
			}catch(DataAccessException e){
				response.put("mensaje", "Error al realizar la consulta en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("mensaje", "juego creado con exito");
			response.put("juego", juegoNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		}
		
		@PutMapping("/juegos/{id}")
		public ResponseEntity<?> update(@Valid @RequestBody Juego juego, BindingResult result, @PathVariable Long id) {
			
			
			Juego currentJuego=this.juegoService.findById(id);
			
			Juego juegoUpdated= null;
			
			Map<String, Object> response= new HashMap<>();
			
			if(result.hasErrors()) {
				List<String> errors=result.getFieldErrors()
						.stream()
						.map(err -> "'El campo '"+err.getField()+"' "+err.getDefaultMessage())
						.collect(Collectors.toList());
				
				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			
			
			if (currentJuego == null) {
				response.put("mensaje", "Error no se pudo editar,el juego ID:"
						.concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				
			}
			try {
			currentJuego.setTitulo(juego.getTitulo());
			currentJuego.setURL(juego.getURL());
			currentJuego.setPlataforma(juego.getPlataforma());
			currentJuego.setImagen(juego.getImagen());
			juegoUpdated = juegoService.save(currentJuego);
			}catch(DataAccessException e) {
				response.put("mensaje", "Error al actualizar juego en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El juego ha sido actualizado con éxito!");
			response.put("juego", juegoUpdated);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		}
		
		
		
		@DeleteMapping("/juegos/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {
			
			Map<String, Object> response= new HashMap<>();
			
			try {
				juegoService.delete(id);
			}catch(DataAccessException e) {
				response.put("mensaje", "Error al eliminar juego en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			response.put("mensaje", "El juego ha sido eliminado con éxito!");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
}
