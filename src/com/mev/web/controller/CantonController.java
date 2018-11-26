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
import org.springframework.web.bind.annotation.CookieValue;
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
import com.mev.web.model.Usuario;
import com.mev.web.service.CantonBO;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.ProvinciaBO;
import com.mev.web.service.CantonBO;
import com.mev.web.service.UsuarioBO;
import com.mev.web.session.Session;

import forms.newCantonForm;

@Controller
public class CantonController {

	@Autowired
	private CantonBO cantonBO;
	@Autowired
	private ProvinciaBO provinciaBO;
	@Autowired
	private Session session;

	final static Logger log = Logger.getLogger(CantonController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/canton/new", method = RequestMethod.GET)
	public String getNew(Model model, @CookieValue(value = "mevUserId", defaultValue = "null") String mevUserId) {
		//Esta Logueado el usuario?
		if(mevUserId.equals("null") || (!session.exists(mevUserId))) {
			return Session.LOGIN_REDIRECT;
		}
		model.addAttribute("cantones", cantonBO.listCantones());
		model.addAttribute("provincias", provinciaBO.listProvincias());
		model.addAttribute("cantonForm", new newCantonForm());
		return "Canton/new";
	}// END GET NEW

	@RequestMapping(value = "/canton/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("cantonForm") newCantonForm cantonForm, Model model) {
		model.addAttribute("cantones", cantonBO.listCantones());
		model.addAttribute("provincias", provinciaBO.listProvincias());
		
		//Conseguir el objeto de provincia seleccionado
		Provincia provincia = provinciaBO.getProvinciaByID(Integer.parseInt(cantonForm.getProvinciaId()));
		//Crear el objeto canton
		Canton canton = new Canton();
		canton.setNombre(cantonForm.getNombre());
		canton.setProvincia(provincia);
		
		cantonBO.save(canton);
		model.addAttribute("success", "Ingresado con exito!");
		return ("Canton/new");
	}// END POST NEW

	

}
