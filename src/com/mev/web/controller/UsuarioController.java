package com.mev.web.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mev.web.model.Miembro;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;

@Controller
public class UsuarioController {

	 @Autowired
	 private MiembroBO miembroBO;

	final static Logger log = Logger.getLogger(UsuarioController.class);

	@RequestMapping(value = "/usuario/new", method = RequestMethod.GET)
	public ModelAndView getNew() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("Usuario/new", "message", message);
	}// END GET NEW

	@RequestMapping(value = "/usuario/new", params = "new", method = RequestMethod.POST)
	public ModelAndView postNew(@RequestParam String cedula, @RequestParam String password,
			@RequestParam String passwordConfirm, @RequestParam String nombre, @RequestParam String apellidoUno,
			@RequestParam String apellidoDos, @RequestParam String fechaNacimiento,
			@RequestParam String detalleDireccion) {

		String message = "Nombre " + nombre + " -- Apellido 1: " + apellidoUno;
		return new ModelAndView("welcome", "message", message);
	}// END POST NEW

	/// LOGIN

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		return "Usuario/login";
	}// END GET NEW

	@RequestMapping(value = "/login", params = "login", method = RequestMethod.POST)
	public String postLogin(@RequestParam String cedula, 
			@RequestParam String password, Model model) {
		
		
		Miembro miembro = null;
		//miembro = miembro = miembroBO.getMiembroByID(cedula); //Esto funciona pero aun no tengo la BD asi que esta comentado
		if(miembro != null) {
			//TODO: Se revisa la contrasena y si funciona se regirige al landing
		}else {
			//Si estamos aqui la cedula no existe
			model.addAttribute("error", "Este usuario no existe");
			return "Usuario/login";
		}
		return "Usuario/login";
	}// END POST NEW

}
