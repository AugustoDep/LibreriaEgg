package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Libro;


@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {
	

	@Query("SELECT a FROM Libro a JOIN FETCH a.autor m WHERE m.id = autor_id")
	public Libro buscarPorIdAutor(@Param ("autor_id") String autor_id);
	

}
