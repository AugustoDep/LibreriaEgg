package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Editorial {
	
	 	@Id
	 	@GeneratedValue
	    private String id;
	    private String nombre;
	    private Boolean alta;

	    public Editorial() {
	    }

	    public Editorial(String id, String nombre, Boolean alta) {
	        this.id = id;
	        this.nombre = nombre;
	        this.alta = alta;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public Boolean getAlta() {
	        return alta;
	    }

	    public void setAlta(Boolean alta) {
	        this.alta = alta;
	    }
	        
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

}