package com.ferolek.springboot.backend.tienda.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

import com.ferolek.springboot.backend.tienda.entity.Usuario;
import com.ferolek.springboot.backend.tienda.services.IUsuarioService;
import com.ferolek.springboot.backend.tienda.entity.Juego;
import com.ferolek.springboot.backend.tienda.services.IJuegoService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
			
			@Autowired
			private IUsuarioService usuarioService;
			private IJuegoService juegoService;
			
			@PostMapping("/usuarios/login")
			public  ResponseEntity<?> validate2(@Valid @RequestBody Usuario usuario, BindingResult result) {
				Map<String, Object> response=new HashMap<>();
				String mensaje;
				
				Usuario respuesta = usuarioService.existeUsuario(usuario.getUsername(),usuario.getPassword());
				//response.put("usuario", usuarios);
				if(respuesta.getId()!=-1.0) {
					mensaje="ok";
					response.put("ok", true);
					response.put("usuario", respuesta);
				}
				else {
					mensaje="false";
					response.put("ok", false);
				}
				
				//return mensaje;
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
	
			
			@PostMapping("/usuarios/{id}/juegos")
			public ResponseEntity<?> addGame(@RequestBody Juego juego,BindingResult result,@PathVariable Long id) {
				Usuario user=usuarioService.findById(id);
				Map<String, Object> response=new HashMap<>();
				try {
				user.getJuegos().add(juego);
				usuarioService.save(user);
				
				}catch(DataAccessException e) {
					response.put("mensaje", "Error al actualizar usuario y sus juegos en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				response.put("user",user.getJuegos() );
		//		response.put("juego", juegoService.findById(juego.getId()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
				
				}
			@GetMapping("/usuarios/{id}/juegos")
			public ResponseEntity<?> showGame(@PathVariable Long id) {
				
				Usuario usuario = null;
				
				Map<String, Object> response=new HashMap<>();
				
				try {
				usuario=usuarioService.findById(id);
				}catch(DataAccessException e) {
					response.put("mensaje", "Error al realizar la consulta en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				if(usuario==null) {
					response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				}
				response.put("juegos", usuario.getJuegos());
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
				

			}
			
			
			@DeleteMapping("/usuarios/{id}/juegos/{id2}")
				public ResponseEntity<?> delete2(@PathVariable Long id,@PathVariable Long id2) {
	
				Map<String, Object> response= new HashMap<>();
			
			
				try {
					usuarioService.delete2(id, id2);
				
	
				}catch(DataAccessException e) {
					response.put("mensaje", "Error al eliminar juego asociado a usuario en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
				}
				response.put("juegos", usuarioService.findById(id).getJuegos());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
				
			
			
			
		
			
			@GetMapping("/usuario")
			public List<Usuario> index() {
				return usuarioService.findAll();
			}
			
			@GetMapping("/usuarios/{id}")
			public ResponseEntity<?> show(@PathVariable Long id) {
				
				Usuario usuario = null;
				Map<String, Object> response=new HashMap<>();
				
				try {
					usuario=usuarioService.findById(id);		
				}catch(DataAccessException e) {
					response.put("mensaje", "Error al realizar la consulta en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				if(usuario==null) {
					response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
				

			}
			
			@PostMapping("/usuarios")
			public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
				Usuario usuarioNew = null;
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
					usuarioNew=usuarioService.save(usuario);
				}catch(DataAccessException e){
					response.put("mensaje", "Error al realizar la consulta en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
				response.put("mensaje", "usuario creado con exito");
				response.put("usuario", usuarioNew);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			
			}
			
			@PutMapping("/usuarios/{id}")
			public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id) {
				
				
				Usuario currentUsuario=this.usuarioService.findById(id);
				
				Usuario usuarioUpdated= null;
				
				Map<String, Object> response= new HashMap<>();
				
				if(result.hasErrors()) {
					List<String> errors=result.getFieldErrors()
							.stream()
							.map(err -> "'El campo '"+err.getField()+"' "+err.getDefaultMessage())
							.collect(Collectors.toList());
					
					response.put("errors", errors);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
				
				
				if (currentUsuario == null) {
					response.put("mensaje", "Error no se pudo editar,el usuario ID:"
							.concat(id.toString().concat(" no existe en la base de datos!")));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
					
				}
				try {
				currentUsuario.setUsername(usuario.getUsername());
				currentUsuario.setEmail(usuario.getEmail());
				currentUsuario.setPassword(usuario.getPassword());
				currentUsuario.setJuegos(usuario.getJuegos());
	
				usuarioUpdated = usuarioService.save(currentUsuario);
				
				}catch(DataAccessException e) {
					response.put("mensaje", "Error al actualizar usuario en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				response.put("mensaje", "El usuario ha sido actualizado con éxito!");
				response.put("usuario", usuarioUpdated);
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			
			}
			
			
			
			@DeleteMapping("/usuarios/{id}")
			public ResponseEntity<?> delete(@PathVariable Long id) {
				
				Map<String, Object> response= new HashMap<>();
				
				try {
					usuarioService.delete(id);
				}catch(DataAccessException e) {
					response.put("mensaje", "Error al eliminar usuario en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
					
				}
				response.put("mensaje", "El usuario ha sido eliminado con éxito!");
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
			
}
