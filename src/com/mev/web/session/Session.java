package com.mev.web.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mev.web.service.UsuarioBO;

@Component
public class Session {

	@Autowired(required = true)
	private UsuarioBO usuarioBO;
	
	public static final String DEFAULT_LANDING = "redirect:reunion/new";
	public static final String LOGIN_REDIRECT = "redirect:/login";
	
	public boolean exists(String cedulaUsuario) {
		return (usuarioBO.getUsuarioByID(cedulaUsuario) != null);
	}
}
