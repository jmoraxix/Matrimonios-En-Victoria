package com.mev.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class UsuarioController {

	 @Autowired
	 private UsuarioBO usuarioBO;

	final static Logger log = Logger.getLogger(UsuarioController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
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

	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public String getLogin(Model model) {
		return "Usuario/login";
	}// END GET NEW

	@RequestMapping(value = {"/login", "/"}, params = "login", method = RequestMethod.POST)
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
				model.addAttribute("error", "Cedula o contrase�a incorrecta");
				return "Usuario/login";
			}
		}else {
			//Si estamos aqui la cedula no existe
			model.addAttribute("error", "Este usuario no existe");
			return "Usuario/login";
		}
	}// END POST LOGIN
	
	////LIST
	
	@RequestMapping(value = "/usuario/list",method = RequestMethod.GET)
	public String getList(@RequestParam(required = false, defaultValue = "null", value = "error") String error, 
			@RequestParam(required = false, defaultValue = "null", value = "search") String search, 
			Model model) {
		//Por si alguna pagina necesita decir que la cedula esta mal u otro error
		if(!error.equals("null")) {
			model.addAttribute("error", error);
		}
		
		//El cliente est� buscando o quiere ver todo?
		if(!(search.equals("null") || search.equals(""))) {
			//Para que la barra se llene con lo que se busco
			model.addAttribute("search", search);
			//Buscamos los que cumplan con el termino de busqueda
			model.addAttribute("usuarios", usuarioBO.searchUsuarios(search));
		} else {
			model.addAttribute("usuarios", usuarioBO.listUsuarios());
		}
		
		return "Usuario/list";
	}// END GET LIST
	
	@RequestMapping(value = "usuario/list",method = RequestMethod.POST)
	public String postList(@RequestParam(required = false, defaultValue = "null", value = "search") String search, 
			Model model) {
		//Por si alguna pagina necesita decir que la cedula esta mal u otro error
		if(!(search.equals("null") || search.equals(""))) {
			model.addAttribute("search", search);
		}
		
		return "redirect:/usuario/list";
	}// END GET LIST
	
////EDIT
	@RequestMapping(value = "/usuario/edit/{cedula}", method = RequestMethod.GET)
	public String getEdit(@PathVariable(required = true) String cedula, 
			Model model) {
		Usuario usuario = usuarioBO.getUsuarioByID(cedula);

		// Check if member is registered
		if (usuario == null) {
			model.addAttribute("error", "Cedula no encontrada");
			return "redirect:/usuario/list";
		}

		model.addAttribute("usuario", usuario);

		return "Usuario/edit";
	}// END GET EDIT

	@RequestMapping(value = "/usuario/edit", params = "edit", method = RequestMethod.POST)
	public String postEdit(@ModelAttribute("usuario") Usuario usuario, Model model) {
		
		Usuario usuarioOriginal = usuarioBO.getUsuarioByID(usuario.getCedula());
		
		if (usuarioOriginal == null) {
			model.addAttribute("error", "Cedula no encntrada");
			return "redirect:/usuario/list";
		}
		
		//usuarioOriginal.setNombre(usuario.getNombre());
		
		usuarioBO.update(usuario);
		model.addAttribute("success", "Guardado con exito!");
		return ("usuario/edit");
	}// END GET EDIT

}
