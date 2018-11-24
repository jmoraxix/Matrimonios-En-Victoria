package com.mev.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
import com.mev.web.session.Session;

import forms.newUsuarioForm;

@Controller
public class UsuarioController {

	 @Autowired
	 private UsuarioBO usuarioBO;
	 @Autowired
	 private MiembroBO miembroBO;

	final static Logger log = Logger.getLogger(UsuarioController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value = "/usuario/new", method = RequestMethod.GET)
	public String getNew(@RequestParam(required = false, defaultValue = "null", value = "upgrade") String upgrade,
			Model model) {
		model.addAttribute("title", "Nuevo Usuario");
		
		newUsuarioForm usuario = new newUsuarioForm();
		if(!upgrade.equals("null")) {
			Miembro miembro = miembroBO.getMiembroByID(upgrade);
			usuario.setCedula(miembro.getCedula());
			usuario.setNombre(miembro.getNombre());
			usuario.setApellido(miembro.getApellido());
			usuario.setSexo(miembro.getSexo());
			usuario.setFechaNacimiento(miembro.getFechaNacimiento());
			usuario.setDetalleDireccion(miembro.getDetalleDireccion());
			usuario.setUpgrade(true);
		}else 
		{
			usuario.setUpgrade(false);
		}

		model.addAttribute("usuario", usuario);
		
		return "Usuario/new";
	}// END GET NEW

	@RequestMapping(value = "/usuario/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("usuario") newUsuarioForm usuarioForm, Model model) {
		
		Usuario usuarioOriginal = usuarioBO.getUsuarioByID(usuarioForm.getCedula());
		
		//validar que no exista
		if (usuarioOriginal != null) {
			model.addAttribute("error", "Usuario ya existe");
			return "Usuario/new";
		}
		
		//Validar las contrasenas
		if(!usuarioForm.getContrasena().equals(usuarioForm.getConfirmarContrasena())) 
		{
			model.addAttribute("error", "Las contrasenas no coinciden");
			return "Usuario/new";
		}
		
				
		if(usuarioForm.getUpgrade()) 
		{
			Miembro miembro = miembroBO.getMiembroByID(usuarioForm.getCedula());
			Usuario usuarioUpgrade = new Usuario();
			
			miembro.setNombre(usuarioForm.getNombre());
			miembro.setApellido(usuarioForm.getApellido());
			miembro.setFechaNacimiento(usuarioForm.getFechaNacimiento());
			miembro.setSexo((usuarioForm.getSexo()));
			miembro.setDetalleDireccion(usuarioForm.getDetalleDireccion());
			usuarioUpgrade.setMiembro(miembro);
			usuarioUpgrade.setContrasena(usuarioForm.getContrasena());
			
			usuarioBO.saveOrUpdate(usuarioUpgrade);
			//miembroBO.update(miembro);
		}
		else
		{
			Miembro miembro = new Miembro();
			Usuario usuarioInsert = new Usuario();
			miembro.setCedula(usuarioForm.getCedula());
			miembro.setNombre(usuarioForm.getNombre());
			miembro.setApellido(usuarioForm.getApellido());
			miembro.setFechaNacimiento(usuarioForm.getFechaNacimiento());
			miembro.setSexo((usuarioForm.getSexo()));
			miembro.setDetalleDireccion(usuarioForm.getDetalleDireccion());
			usuarioInsert.setMiembro(miembro);
			usuarioInsert.setContrasena(usuarioForm.getContrasena());
			usuarioInsert.setCedula(usuarioForm.getCedula());
			
			usuarioBO.save(usuarioInsert);
		}
		model.addAttribute("success", "Guardado con exito!");
		return ("Usuario/new");
	}// END POST NEW

	/// LOGIN

	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public String getLogin(Model model) {
		return "Usuario/login";
	}// END GET NEW

	@RequestMapping(value = {"/login", "/"}, params = "login", method = RequestMethod.POST)
	public String postLogin(@RequestParam String cedula, 
			@RequestParam String password, HttpServletResponse response, Model model) {
		
		Usuario usuario = null;
		usuario = usuarioBO.getUsuarioByID(cedula); 
		if(usuario != null) {
			if(usuario.getContrasena().equals(password)) {
				//Login Success
				//model.addAttribute("title", "Nuevo Usuario");
				//Store Cookie
				Cookie cookieUsuario = new Cookie("mevUserId", cedula);
				cookieUsuario.setPath("/");
				response.addCookie(cookieUsuario);
				//Redirect
				return Session.DEFAULT_LANDING;
			} else {
				model.addAttribute("error", "Cedula o contraseña incorrecta");
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
		newUsuarioForm usuarioForm = new newUsuarioForm(usuario);
		model.addAttribute("usuario", usuarioForm);

		return "Usuario/edit";
	}// END GET EDIT

	@RequestMapping(value = "/usuario/edit", params = "edit", method = RequestMethod.POST)
	public String postEdit(@ModelAttribute("usuario") newUsuarioForm usuarioForm, Model model) {
		
		Usuario usuarioOriginal = usuarioBO.getUsuarioByID(usuarioForm.getCedula());
		
		if (usuarioOriginal == null) {
			model.addAttribute("error", "Cedula no encntrada");
			return "redirect:/usuario/list";
		}
		
		Miembro miembro = usuarioOriginal.getMiembro();
		miembro.setNombre(usuarioForm.getNombre());
		miembro.setApellido(usuarioForm.getApellido());
		miembro.setFechaNacimiento(usuarioForm.getFechaNacimiento());
		miembro.setSexo((usuarioForm.getSexo()));
		miembro.setDetalleDireccion(usuarioForm.getDetalleDireccion());
		usuarioOriginal.setMiembro(miembro);
		
		usuarioBO.update(usuarioOriginal);
		model.addAttribute("success", "Guardado con exito!");
		return ("Usuario/edit");
	}// END GET EDIT

}
