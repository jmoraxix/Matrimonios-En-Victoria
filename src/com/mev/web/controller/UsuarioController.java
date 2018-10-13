package com.mev.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.mev.web.model.Usuario;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.UsuarioBO;

@Controller
public class UsuarioController {

	 @Autowired
	 private UsuarioBO usuarioBO;

	final static Logger log = Logger.getLogger(UsuarioController.class);

	@RequestMapping(value = "/usuario/new", method = RequestMethod.GET)
	public String getNew(Model model) {
		model.addAttribute(
				"title", "Nuevo Usuario");
		return "Usuario/new";
	}// END GET NEW

	@RequestMapping(value = "/usuario/new", params = "new", method = RequestMethod.POST)
	public String postNew(@RequestParam String cedula, @RequestParam String password,
			@RequestParam String passwordConfirm, @RequestParam String nombre, @RequestParam String apellido
			, @RequestParam String fechaNacimientoString,
			@RequestParam String detalleDireccion, @RequestParam String sexo, Model model) {
		
		Date fechaNacimiento;
		//Convert parameter date to actual date object
		try {
			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoString);
		} catch (ParseException e) {
			e.printStackTrace();
			model.addAttribute("error", e.toString());
			return "Usuario/new";
		}  
		
		//Check if passwords match
		if(!password.equals(passwordConfirm)) {
			model.addAttribute("error", "Las contraseñas no coinciden");
			return "Usuario/new";
		}
		
		//Check if user already exists
		if(usuarioBO.getUsuarioByID(cedula) != null) {
			model.addAttribute("error", "La cedula ya esta registrada");
			return "Usuario/new";
		}
		
		//Create user object
		Usuario usuario = new Usuario(cedula, nombre, apellido, fechaNacimiento, detalleDireccion, sexo, password);
		usuarioBO.save(usuario);
		model.addAttribute("success", "Guardado con exito!");
		return("Usuario/new");
	}// END POST NEW

	/// LOGIN

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		return "Usuario/login";
	}// END GET NEW

	@RequestMapping(value = "/login", params = "login", method = RequestMethod.POST)
	public String postLogin(@RequestParam String cedula, 
			@RequestParam String password, Model model) {
		
		Usuario usuario = null;
		usuario = usuarioBO.getUsuarioByID(cedula); 
		if(usuario != null) {
			if(usuario.getContrasena().equals(password)) {
				//Login Success
				model.addAttribute("title", "Nuevo Usuario");
				return "redirect:usuario/new";
			} else {
				model.addAttribute("error", "Cedula o contraseña incorrecta");
				return "Usuario/login";
			}
		}else {
			//Si estamos aqui la cedula no existe
			model.addAttribute("error", "Este usuario no existe");
			return "Usuario/login";
		}
	}// END POST NEW

}
