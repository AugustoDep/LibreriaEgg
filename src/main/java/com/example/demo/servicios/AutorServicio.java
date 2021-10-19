package com.example.demo.servicios;

import java.util.ArrayList;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Autor;
import com.example.demo.repositorios.AutorRepositorio;


@Service
public class AutorServicio {

	@Autowired
	private AutorRepositorio autorRepositorio;
	
	

	@Transactional
	public Autor cargarAutor(String nombre) {

		Autor autor = new Autor();
		autor.setNombre(nombre);
		autor.setAlta(true);

		return autorRepositorio.save(autor);
	}

	@Transactional
	public void editarAutor(String id) {
		Autor autor = autorRepositorio.findById(id).get();
		if(autor.getAlta()) {
			autor.setAlta(false);
		}else {
			autor.setAlta(true);
		}
		

		autorRepositorio.save(autor);

	}

	@Transactional
	public ArrayList<Autor> listarTodos() {

		return (ArrayList<Autor>) autorRepositorio.findAll();

	}

	@Transactional
	public void eliminarAutor(String id) {
		
		try {
			
			
			autorRepositorio.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
			
		}

		
	}
	
	public ArrayList<Autor> buscarAutor(String nombre) {

		return autorRepositorio.buscarPorNombre(nombre);

	}
	
	@Transactional
	public Autor editarNombre(String id, String nombre) {
		
		Autor a =  autorRepositorio.getById(id);
		a.setNombre(nombre);
		
		System.out.println(a.getNombre());
		System.out.println(nombre);
		System.out.println(id);
		
		return autorRepositorio.save(a);
		
	}

}
