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
import com.mev.web.model.Usuario;
import com.mev.web.service.CategoriaBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.UsuarioBO;

@Controller
public class MiembroController {

	@Autowired
	private MiembroBO miembroBO;

	final static Logger log = Logger.getLogger(MiembroController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/miembro/new", method = RequestMethod.GET)
	public String getNew(Model model) {
		model.addAttribute("title", "Nuevo Miembro");
		return "Miembro/new";
	}// END GET NEW

	@RequestMapping(value = "/miembro/new", params = "new", method = RequestMethod.POST)
	public String postNew(@RequestParam String cedula, @RequestParam String nombre, @RequestParam String apellido,
			@RequestParam String fechaNacimientoString, @RequestParam String detalleDireccion,
			@RequestParam String sexo, Model model) {

		Date fechaNacimiento;
		// Convert parameter date to actual date object
		try {
			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimientoString);
		} catch (ParseException e) {
			e.printStackTrace();
			model.addAttribute("error", e.toString());
			return "Miembro/new";
		}

		// Check if member already exists
		if (miembroBO.getMiembroByID(cedula) != null) {
			model.addAttribute("error", "La cedula ya esta registrada");
			return "Miembro/new";
		}

		// Create user object
		Miembro miembro = new Miembro(cedula, nombre, apellido, fechaNacimiento, detalleDireccion, sexo);
		miembroBO.save(miembro);
		model.addAttribute("success", "Guardado con exito!");
		return ("Miembro/new");
	}// END POST NEW

	//// LIST

	@RequestMapping(value = "/miembro/list",method = RequestMethod.GET)
	public String getList(@RequestParam(required = false, defaultValue = "null", value = "error") String error, 
			@RequestParam(required = false, defaultValue = "null", value = "search") String search,
			Model model) {
		//Por si alguna pagina necesita decir que la cedula esta mal u otro error
		if(!error.equals("null")) {
			model.addAttribute("error", error);
		}
		
		//El cliente esta buscando algo o quiere ver todo
		if(!(search.equals("null") || search.equals(""))) {
			//Para que la barra se llene con lo que se busco
			model.addAttribute("search", search);
			//Buscamos los que cumplan con el termino de busqueda
			model.addAttribute("miembros", miembroBO.searchMiembros(search));
		} else {
			model.addAttribute("miembros", miembroBO.listMiembros());
		}
		
		return "Miembro/list";
	}// END GET LIST
	
	@RequestMapping(value = "miembro/list",method = RequestMethod.POST)
	public String postList(@RequestParam(required = false, defaultValue = "null", value = "search") String search, Model model) {
		//Por si alguna pagina necesita decir que la cedula esta mal u otro error
		if(!(search.equals("null") || search.equals(""))) {
			model.addAttribute("search", search);
		}
		
		return "redirect:/miembro/list";
	}// END GET LIST

	//// EDIT
	@RequestMapping(value = "/miembro/edit/{cedula}", method = RequestMethod.GET)
	public String getEdit(@PathVariable(required = true) String cedula, 
			Model model) {
		Miembro miembro = miembroBO.getMiembroByID(cedula);

		// Check if member is registered
		if (miembro == null) {
			model.addAttribute("error", "Cedula no encontrada");
			return "redirect:/miembro/list";
		}

		//model.addAttribute("sexo", miembro.getSexo());
		model.addAttribute("miembro", miembro);

		return "Miembro/edit";
	}// END GET EDIT

	@RequestMapping(value = "/miembro/edit", params = "edit", method = RequestMethod.POST)
	public String postEdit(@ModelAttribute("miembro") Miembro miembro, Model model) {
		
		Miembro miembroOriginal = miembroBO.getMiembroByID(miembro.getCedula());
		
		if (miembroOriginal == null) {
			model.addAttribute("error", "Cedula no encontrada");
			return "redirect:/miembro/list";
		}
		
		//miembroOriginal.setNombre(miembro.getNombre());
		
		miembroBO.update(miembro);
		model.addAttribute("success", "Guardado con exito!");
		return ("Miembro/edit");
	}// END GET EDIT

}
