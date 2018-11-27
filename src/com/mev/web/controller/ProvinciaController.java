package com.mev.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mev.web.model.Provincia;
import com.mev.web.service.ProvinciaBO;
import com.mev.web.session.Session;

@Controller
public class ProvinciaController {

	@Autowired
	private ProvinciaBO provinciaBO;
	@Autowired
	private Session session;

	final static Logger log = Logger.getLogger(ProvinciaController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/provincia/new", method = RequestMethod.GET)
	public String getNew(Model model, @CookieValue(value = "mevUserId", defaultValue = "null") String mevUserId) {
		// Esta Logueado el usuario?
		if (mevUserId.equals("null") || (!session.exists(mevUserId))) {
			return Session.LOGIN_REDIRECT;
		}
		model.addAttribute("provincias", provinciaBO.listProvincias());
		model.addAttribute("provincia", new Provincia());
		return "Provincia/new";
	}// END GET NEW

	@RequestMapping(value = "/provincia/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("provincia") Provincia provincia, Model model) {
		model.addAttribute("provincias", provinciaBO.listProvincias());
		provinciaBO.save(provincia);
		model.addAttribute("success", "Ingresado con exito!");
		return ("Provincia/new");
	}// END POST NEW

}
