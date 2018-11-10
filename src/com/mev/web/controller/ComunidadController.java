package com.mev.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mev.web.model.Miembro;
import com.mev.web.model.Provincia;
import com.mev.web.model.Distrito;
import com.mev.web.model.Comunidad;
import com.mev.web.model.Usuario;
import com.mev.web.service.ComunidadBO;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.ProvinciaBO;
import com.mev.web.service.ComunidadBO;
import com.mev.web.service.UsuarioBO;

import forms.newComunidadForm;

@Controller
public class ComunidadController {

	@Autowired
	private ComunidadBO comunidadBO;
	@Autowired
	private DistritoBO distritoBO;

	final static Logger log = Logger.getLogger(ComunidadController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/comunidad/new", method = RequestMethod.GET)
	public String getNew(Model model) {
		model.addAttribute("comunidades", comunidadBO.listComunidades());
		model.addAttribute("distritos", distritoBO.listDistritos());
		model.addAttribute("comunidadForm", new newComunidadForm());
		return "Comunidad/new";
	}// END GET NEW

	@RequestMapping(value = "/comunidad/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("comunidadForm") newComunidadForm comunidadForm, Model model) {
		model.addAttribute("comunidades", comunidadBO.listComunidades());
		model.addAttribute("distritos", distritoBO.listDistritos());
		
		//Conseguir el objeto de distrito seleccionado
		Distrito distrito = distritoBO.getDistritoByID(Integer.parseInt(comunidadForm.getDistritoId()));
		//Crear el objeto distrito
		Comunidad comunidad = new Comunidad();
		comunidad.setNombre(comunidadForm.getNombre());
		comunidad.setDistrito(distrito);
		
		comunidadBO.save(comunidad);
		model.addAttribute("success", "Ingresado con exito!");
		return ("Comunidad/new");
	}// END POST NEW

	

}
