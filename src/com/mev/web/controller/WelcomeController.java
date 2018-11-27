package com.mev.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mev.web.service.CategoriaBO;

@Controller
public class WelcomeController {

	@Autowired
	private CategoriaBO categoriaBO;

	final static Logger log = Logger.getLogger(WelcomeController.class);

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		try {
			this.categoriaBO.listCategorias();
		} catch (Exception e) {
			log.error("Error al obtener categorías", e);
		}

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

}
