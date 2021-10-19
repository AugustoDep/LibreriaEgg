package com.example.demo.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Autor;
import com.example.demo.servicios.AutorServicio;

@Controller
@RequestMapping("/autores")
public class AutorControlador {

	@Autowired
	private AutorServicio as;

	@GetMapping("/lista")
	public String listarAutores(ModelMap modelo) {
		ArrayList<Autor> listaAutores = as.listarTodos();
		modelo.addAttribute("autores", listaAutores);
		return "listaAutores";
	}

	@GetMapping("/cargar")
	public String cargarAutor() {
		return "cargar-autor";
	}

	@PostMapping("/cargar")
	public String ingresarAutor(@RequestParam String nombre) {		
		as.cargarAutor(nombre);
		return "redirect:/autores/lista";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarAutor(@PathVariable("id") String id) {	
		
		try {
			as.eliminarAutor(id);
			return "redirect:/autores/lista";
			
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/autores/lista";
		}
		
	}
	
	@GetMapping("/editar/{id}")
	public String editarAutor(@PathVariable ("id") String id) {
		as.editarAutor(id);
		return "redirect:/autores/lista";
	}
	
	@GetMapping("/buscar")
	public String buscarAutor(ModelMap modelo, @RequestParam String nombre) {
		ArrayList<Autor> listaAutores = as.buscarAutor(nombre);
		modelo.addAttribute("autores", listaAutores);
		
		return "listaAutores";
		
	}
	

}
