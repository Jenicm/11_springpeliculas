package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.pelicula;

public interface peliculaDAO {

	public void addpelicula(pelicula p);
	public void updatepelicula(pelicula p);
	public List<pelicula> listpeliculas();
	public pelicula getpeliculaById(int id);
	public void removepelicula(int id);
}
