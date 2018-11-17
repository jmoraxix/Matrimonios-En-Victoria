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
import com.mev.web.model.Reunion;
import com.mev.web.model.Distrito;
import com.mev.web.model.Grupo;
import com.mev.web.model.Comunidad;
import com.mev.web.model.Usuario;
import com.mev.web.service.ComunidadBO;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.GrupoBO;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.ProvinciaBO;
import com.mev.web.service.ReunionBO;
import com.mev.web.service.ComunidadBO;
import com.mev.web.service.UsuarioBO;

import forms.newComunidadForm;
import forms.newReunionForm;

@Controller
public class ReunionController {

	@Autowired
	private ReunionBO reunionBO;
	@Autowired
	private ComunidadBO comunidadBO;
	@Autowired
	private GrupoBO grupoBO;

	final static Logger log = Logger.getLogger(ReunionController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/reunion/new", method = RequestMethod.GET)
	public String getNew(@RequestParam(required = false, defaultValue = "null", value = "error") String error,
			@RequestParam(required = false, defaultValue = "null", value = "success") String success,
			Model model) {
		model.addAttribute("reuniones", reunionBO.listReuniones());
		model.addAttribute("comunidades", comunidadBO.listComunidades());
		model.addAttribute("grupos", grupoBO.listGrupos());
		model.addAttribute("reunionForm", new newReunionForm());
		return "Reunion/new";
	}// END GET NEW

	@RequestMapping(value = "/reunion/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("reunionForm") newReunionForm reunionForm, Model model) {
		try {
			//Conseguir el objeto de comunidade seleccionado
			Comunidad comunidad = comunidadBO.getComunidadByID(Integer.parseInt(reunionForm.getComunidadId()));
			
			//Conseguir el objeto de grupo seleccionado
			Grupo grupo = grupoBO.getGrupoByID(Integer.parseInt(reunionForm.getGrupoId()));
			
			//Crear el objeto reunion
			Reunion reunion = new Reunion();
			reunion.setComunidad(comunidad);
			reunion.setGrupo(grupo);
			reunion.setFecha(reunionForm.parseFecha());
			
			//Intentar insertar
			reunionBO.save(reunion);
			model.addAttribute("success", "Ingresado con éxito!");
		}catch(Exception e) {
			model.addAttribute("error", "Ocurrió un error al insertar");
		}
		return ("redirect:reunion/new");
	}// END POST NEW

	

}
