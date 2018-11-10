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
import com.mev.web.model.Grupo;
import com.mev.web.model.Usuario;
import com.mev.web.service.GrupoBO;
import com.mev.web.service.CantonBO;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.ProvinciaBO;
import com.mev.web.service.GrupoBO;
import com.mev.web.service.UsuarioBO;

import forms.newGrupoForm;

@Controller
public class GrupoController {

	@Autowired
	private GrupoBO grupoBO;
	@Autowired
	private CantonBO cantonBO;

	final static Logger log = Logger.getLogger(GrupoController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/grupo/new", method = RequestMethod.GET)
	public String getNew(@RequestParam(required = false, defaultValue = "null", value = "error") String error,
			@RequestParam(required = false, defaultValue = "null", value = "success") String success, 
			@RequestParam(required = false, defaultValue = "null", value = "delete") String delete, 
			Model model) {
		if(!error.equals("null")) {
			model.addAttribute("error", error);
		}
		if(!success.equals("null")) {
			model.addAttribute("success", success);
		}
		if(!delete.equals("null")) {
			try 
			{
				Grupo grupo = grupoBO.getGrupoByID(Integer.parseInt(delete));
				grupoBO.delete(grupo);
				model.addAttribute("success", "Eliminado");
			} 
			catch(Exception e)
			{
				model.addAttribute("error", "No se pudo eliminar, reintente" + e.toString());
			}
		}
		
		model.addAttribute("grupos", grupoBO.listGrupos());
		model.addAttribute("cantones", cantonBO.listCantones());
		model.addAttribute("grupoForm", new newGrupoForm());
		return "Grupo/new";
	}// END GET NEW

	@RequestMapping(value = "/grupo/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("grupoForm") newGrupoForm grupoForm, Model model) {
		model.addAttribute("grupos", grupoBO.listGrupos());

		//Crear el objeto grupo
		Grupo grupo = new Grupo();
		grupo.setNombre(grupoForm.getNombre());
		
		grupoBO.save(grupo);
		model.addAttribute("success", "Ingresado con exito!");
		return ("redirect:/grupo/new");
	}// END POST NEW

	

}
