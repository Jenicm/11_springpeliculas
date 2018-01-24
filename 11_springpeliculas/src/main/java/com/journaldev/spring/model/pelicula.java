package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="peliculas")
public class pelicula {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String director;
	private String duracion;
	private String pais;
	private String categoria;
	private String anio;
	


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}


	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}




	@Override
	public String toString(){
		return "id="+id+", nombre="+nombre+", director="+director+", duracion="+duracion+", pais="+pais+", categoria="+categoria+", anio="+anio;
	}
}
