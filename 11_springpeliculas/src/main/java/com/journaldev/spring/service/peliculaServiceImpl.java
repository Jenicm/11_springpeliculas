package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.peliculaDAO;
import com.journaldev.spring.model.pelicula;

@Service
public class peliculaServiceImpl implements peliculaService {
	
	private peliculaDAO peliculaDAO;

	public void setpeliculaDAO(peliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}
//	@Override
	@Transactional
	public void addpelicula(pelicula p) {
		this.peliculaDAO.addpelicula(p);
	}

//	@Override
	@Transactional
	public void updatepelicula(pelicula p) {
		this.peliculaDAO.updatepelicula(p);
	}

//	@Override
	@Transactional
	public List<pelicula> listpeliculas() {
		return this.peliculaDAO.listpeliculas();
	}

//	@Override
	@Transactional
	public pelicula getpeliculaById(int id) {
		return this.peliculaDAO.getpeliculaById(id);
	}

//	@Override
	@Transactional
	public void removepelicula(int id) {
		this.peliculaDAO.removepelicula(id);
	}

}
