package com.example.demo.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Autor;




@Repository
public interface AutorRepositorio extends JpaRepository <Autor, String>{

	
	@Query("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
	public ArrayList<Autor> buscarPorNombre(@Param ("nombre") String nombre);
	
	
	
}
