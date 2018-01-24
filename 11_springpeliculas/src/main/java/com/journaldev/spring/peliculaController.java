package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.pelicula;
import com.journaldev.spring.service.peliculaService;

@Controller
public class peliculaController {
	
	private peliculaService peliculaService;
	
	@Autowired(required=true)
	@Qualifier(value="peliculaService")
	public void setpeliculaService(peliculaService ps){
		this.peliculaService = ps;
	}
	
	@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	public String listpeliculas(Model model) {
		model.addAttribute("pelicula", new pelicula());
		model.addAttribute("listpeliculas", this.peliculaService.listpeliculas());
		return "pelicula";
	}
	
	//For add and update pelicula both
	@RequestMapping(value= "/pelicula/add", method = RequestMethod.POST)
	public String addpelicula(@ModelAttribute("pelicula") pelicula p){
		
		if(p.getId() == 0){
			//new pelicula, add it
			this.peliculaService.addpelicula(p);
		}else{
			//existing pelicula, call update
			this.peliculaService.updatepelicula(p);
		}
		
		return "redirect:/peliculas";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removepelicula(@PathVariable("id") int id){
		
        this.peliculaService.removepelicula(id);
        return "redirect:/peliculas";
    }
 
    @RequestMapping("/edit/{id}")
    public String editpelicula(@PathVariable("id") int id, Model model){
        model.addAttribute("pelicula", this.peliculaService.getpeliculaById(id));
        model.addAttribute("listpeliculas", this.peliculaService.listpeliculas());
        return "pelicula";
    }
	
}
