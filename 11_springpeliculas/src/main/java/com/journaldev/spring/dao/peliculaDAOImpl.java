package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.pelicula;

@Repository
public class peliculaDAOImpl implements peliculaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(peliculaDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

//	@Override
	public void addpelicula(pelicula p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("pelicula saved successfully, pelicula Details="+p);
	}

//	@Override
	public void updatepelicula(pelicula p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("pelicula updated successfully, pelicula Details="+p);
	}

	@SuppressWarnings("unchecked")
//	@Override
	public List<pelicula> listpeliculas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<pelicula> peliculasList = session.createQuery("from pelicula").list();
		for(pelicula p : peliculasList){
			logger.info("pelicula List::"+p);
		}
		return peliculasList;
	}

//	@Override
	public pelicula getpeliculaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		pelicula p = (pelicula) session.load(pelicula.class, new Integer(id));
		logger.info("pelicula loaded successfully, pelicula details="+p);
		return p;
	}

//	@Override
	public void removepelicula(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		pelicula p = (pelicula) session.load(pelicula.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("pelicula deleted successfully, pelicula details="+p);
	}

}
