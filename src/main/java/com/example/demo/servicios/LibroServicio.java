package com.example.demo.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Autor;
import com.example.demo.entidades.Libro;
import com.example.demo.repositorios.AutorRepositorio;
import com.example.demo.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

	@Autowired
	private LibroRepositorio libroRepositorio;
	
	@Autowired
	private AutorRepositorio autorRepositorio;

	@Transactional
	public void eliminarAutorDesdeLibro(String autor_id) {
		
		Libro l = (Libro) libroRepositorio.buscarPorIdAutor(autor_id);
		
		l.setAutor(null);
		
		
	}

}
