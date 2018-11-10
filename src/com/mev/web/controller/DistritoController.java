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
import com.mev.web.model.Canton;
import com.mev.web.model.Distrito;
import com.mev.web.model.Usuario;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.CantonBO;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.ProvinciaBO;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.UsuarioBO;

import forms.newDistritoForm;

@Controller
public class DistritoController {

	@Autowired
	private DistritoBO distritoBO;
	@Autowired
	private CantonBO cantonBO;

	final static Logger log = Logger.getLogger(DistritoController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/distrito/new", method = RequestMethod.GET)
	public String getNew(Model model) {
		model.addAttribute("distritos", distritoBO.listDistritos());
		model.addAttribute("cantones", cantonBO.listCantones());
		model.addAttribute("distritoForm", new newDistritoForm());
		return "Distrito/new";
	}// END GET NEW

	@RequestMapping(value = "/distrito/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("distritoForm") newDistritoForm distritoForm, Model model) {
		model.addAttribute("distritos", distritoBO.listDistritos());
		model.addAttribute("cantones", cantonBO.listCantones());
		
		//Conseguir el objeto de canton seleccionado
		Canton canton = cantonBO.getCantonByID(Integer.parseInt(distritoForm.getCantonId()));
		//Crear el objeto canton
		Distrito distrito = new Distrito();
		distrito.setNombre(distritoForm.getNombre());
		distrito.setCanton(canton);
		
		distritoBO.save(distrito);
		model.addAttribute("success", "Ingresado con exito!");
		return ("Distrito/new");
	}// END POST NEW

	

}
