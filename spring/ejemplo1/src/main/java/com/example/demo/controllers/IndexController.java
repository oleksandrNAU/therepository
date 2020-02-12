package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping(value = "/perfil")
	public String perfil(Model model) {
		
		Usuario usuario=new Usuario();
		usuario.setNombre("Jose");
		usuario.setApellido("Gomez");
		usuario.setEmail("jose@gmail.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping(value = "/listar")
	public String listar(Model model) {
		//List<Usuario> usuarios=new ArrayList();
		//usuarios.add(new Usuario("Ivan","Petro","iva@gmail.com"));
		//usuarios.add(new Usuario("Petro","Grozni","petro@gmail.com"));
		//usuarios.add(new Usuario("Chinno","Reem","cr@gmail.com"));
		//model.addAttribute("usuarios",usuarios);
		model.addAttribute("titulo",textoListar);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios=new ArrayList();
		usuarios.add(new Usuario("Ivano","Pertro","ivan@gmail.com"));
		usuarios.add(new Usuario("Kilo","Rtro","ijva@gmail.com"));
		usuarios.add(new Usuario("KILOvan","Peotr","ivka@gmail.com"));
		return usuarios;
	}
	
	
	
	
	

}
