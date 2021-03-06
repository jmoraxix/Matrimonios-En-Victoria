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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mev.web.model.Comunidad;
import com.mev.web.model.Grupo;
import com.mev.web.model.Miembro;
import com.mev.web.model.Reunion;
import com.mev.web.service.ComunidadBO;
import com.mev.web.service.GrupoBO;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.ReunionBO;
import com.mev.web.session.Session;

import forms.newReunionForm;

@Controller
public class ReunionController {

	@Autowired
	private ReunionBO reunionBO;
	@Autowired
	private MiembroBO miembroBO;
	@Autowired
	private GrupoBO grupoBO;
	@Autowired
	private ComunidadBO comunidadBO;
	@Autowired
	private Session session;

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
			@CookieValue(value = "mevUserId", defaultValue = "null") String mevUserId, Model model) {
		// Esta Logueado el usuario?
		if (mevUserId.equals("null") || (!session.exists(mevUserId))) {
			return Session.LOGIN_REDIRECT;
		}

		if (!error.equals("null")) {
			model.addAttribute("error", error);
		}
		if (!success.equals("null")) {
			model.addAttribute("success", success);
		}

		model.addAttribute("reuniones", reunionBO.listReuniones());
		model.addAttribute("comunidades", comunidadBO.listComunidades());
		model.addAttribute("grupos", grupoBO.listGrupos());
		model.addAttribute("reunionForm", new newReunionForm());
		return "Reunion/new";
	}// END GET NEW

	@RequestMapping(value = "/reunion/new", method = RequestMethod.POST)
	public String postNew(@ModelAttribute("reunionForm") newReunionForm reunionForm, Model model) {
		try {
			// Conseguir el objeto de comunidade seleccionado
			Comunidad comunidad = comunidadBO.getComunidadByID(Integer.parseInt(reunionForm.getComunidadId()));

			// Conseguir el objeto de grupo seleccionado
			Grupo grupo = grupoBO.getGrupoByID(Integer.parseInt(reunionForm.getGrupoId()));

			// Crear el objeto reunion
			Reunion reunion = new Reunion();
			reunion.setComunidad(comunidad);
			reunion.setGrupo(grupo);
			reunion.setFecha(reunionForm.parseFecha());

			// Intentar insertar
			reunionBO.save(reunion);
			model.addAttribute("success", "Ingresado con éxito!");
		} catch (Exception e) {
			model.addAttribute("error", "Ocurrió un error al insertar");
		}
		return ("redirect:/reunion/new");
	}// END POST NEW

	//// ASISTENCIA
	@RequestMapping(value = "/reunion/asistencia/{reunionId}", method = RequestMethod.GET)
	public String getAsistencia(@PathVariable(required = true) int reunionId,
			@RequestParam(required = false, defaultValue = "null", value = "search") String search,
			@RequestParam(required = false, defaultValue = "null", value = "add") String add, Model model,
			@CookieValue(value = "mevUserId", defaultValue = "null") String mevUserId) {
		// Esta Logueado el usuario?
		if (mevUserId.equals("null") || (!session.exists(mevUserId))) {
			return Session.LOGIN_REDIRECT;
		}

		// Instanciar la reunion que se quiere pasar la lista
		Reunion reunion = reunionBO.getReunionByID(reunionId);

		// Revisar si no existe, error
		if (reunion == null) {
			model.addAttribute("error", "Reunión no encontrada");
			return "redirect:/reunion/new";
		}

		// Revisar si tenemos que anadir algo
		if (!(add.equals("null") || add.equals(""))) {

			Miembro miembroAdd = miembroBO.getMiembroByID(add);

			if (reunion.getAsistentes().contains(miembroAdd)) {
				model.addAttribute("error", "Este usuario ya ha sido añadido a esta reunión");
			} else {
				reunion.getAsistentes().add(miembroAdd);
				reunionBO.update(reunion);
				model.addAttribute("success", "Añadido con éxito");
			}
		}

		// El cliente esta buscando algo o quiere ver todo
		if (!(search.equals("null") || search.equals(""))) {
			// Para que la barra se llene con lo que se busco
			model.addAttribute("search", search);
			// Buscamos los que cumplan con el termino de busqueda
			model.addAttribute("miembros", miembroBO.searchMiembros(search));
		} else {
			model.addAttribute("miembros", miembroBO.listMiembros());
		}

		// Si la reunion está bien, mostrar los datos y cargar el formulario
		// model.addAttribute("miembros", miembroBO.listMiembrosByReunion(reunion));
		model.addAttribute("reunion", reunion);
		return "Reunion/asistencia";
	}

	@RequestMapping(value = "/reunion/asistencia/search", method = RequestMethod.POST)
	public String postAsistencia(
			@RequestParam(required = false, defaultValue = "null", value = "reunionId") String reunionId,
			@RequestParam(required = false, defaultValue = "null", value = "search") String search, Model model) {
		// Por si alguna pagina necesita decir que la cedula esta mal u otro error
		if (!(search.equals("null") || search.equals(""))) {
			model.addAttribute("search", search);
		}

		return "redirect:/reunion/asistencia/" + reunionId;
	}// END GET LIST
}
