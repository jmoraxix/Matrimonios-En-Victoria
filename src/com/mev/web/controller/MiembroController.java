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
public class MiembroController {

	 @Autowired
	 private MiembroBO miembroBO;

	final static Logger log = Logger.getLogger(MiembroController.class);

	@RequestMapping(value = "/miembro/new", method = RequestMethod.GET)
	public String getNew(Model model) {
		model.addAttribute(
				"title", "Nuevo Miembro");
		return "Miembro/new";
	}// END GET NEW

	@RequestMapping(value = "/miembro/new", params = "new", method = RequestMethod.POST)
	public String postNew(@RequestParam String cedula, 
			@RequestParam String nombre, @RequestParam String apellido
			, @RequestParam String fechaNacimientoString,
			@RequestParam String detalleDireccion, @RequestParam String sexo, Model model) {
		
		Date fechaNacimiento;
		//Convert parameter date to actual date object
		try {
			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoString);
		} catch (ParseException e) {
			e.printStackTrace();
			model.addAttribute("error", e.toString());
			return "Miembro/new";
		}  

		
		//Check if member already exists
		if(miembroBO.getMiembroByID(cedula) != null) {
			model.addAttribute("error", "La cedula ya esta registrada");
			return "Miembro/new";
		}
		
		//Create user object
		Miembro miembro = new Miembro(cedula, nombre, apellido, fechaNacimiento, detalleDireccion, sexo);
		miembroBO.save(miembro);
		model.addAttribute("success", "Guardado con exito!");
		return("Miembro/new");
	}// END POST NEW

	

}
