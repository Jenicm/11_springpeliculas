package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.pelicula;

public interface peliculaService {

	public void addpelicula(pelicula p);
	public void updatepelicula(pelicula p);
	public List<pelicula> listpeliculas();
	public pelicula getpeliculaById(int id);
	public void removepelicula(int id);
	
}
