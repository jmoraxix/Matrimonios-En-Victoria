package com.mev.web.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mev.web.service.CategoriaBO;

@Controller
public class UsuarioController {

	// @Autowired
	// private CategoriaBO categoriaBO;

	final static Logger log = Logger.getLogger(UsuarioController.class);

	@RequestMapping(value = "/usuario/new", method = RequestMethod.GET)
	public ModelAndView getNew() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("Usuario/new", "message", message);
	}//END GET NEW

	@RequestMapping(value = "/usuario/new", params = "new", method = RequestMethod.POST)
	public ModelAndView postNew(@RequestParam String cedula, @RequestParam String password,
			@RequestParam String passwordConfirm, @RequestParam String nombre, @RequestParam String apellidoUno,
			@RequestParam String apellidoDos, @RequestParam String fechaNacimiento, @RequestParam String detalleDireccion) {
		
		String message = "Nombre " + nombre + " -- Apellido 1: " + apellidoUno;
		return new ModelAndView("welcome", "message", message);
	}//END POST NEW

}
