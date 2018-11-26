package com.mev.web.session;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mev.web.model.Miembro;
import com.mev.web.model.Usuario;
import com.mev.web.service.MiembroBO;
import com.mev.web.service.UsuarioBO;

@Component
public class Session {

	@Autowired(required = true)
	private UsuarioBO usuarioBO;
	@Autowired(required = true)
	private MiembroBO miembroBO;
	
	public static final String DEFAULT_LANDING = "redirect:reunion/new";
	public static final String LOGIN_REDIRECT = "redirect:/login";
	public static final String DEFAULT_USER_ID = "123456789";
	
	public boolean exists(String cedulaUsuario) {
		return (usuarioBO.getUsuarioByID(cedulaUsuario) != null);
	}
	
	public Usuario returnOrGenerateDefaultUser() {
		if(!this.exists(Session.DEFAULT_USER_ID)) {
			Miembro miembro = new Miembro();
			Usuario usuarioUpgrade = new Usuario();
			
			miembro.setCedula(Session.DEFAULT_USER_ID);
			miembro.setNombre("Administrador");
			miembro.setApellido("Por Defecto");
			miembro.setFechaNacimiento(new Date());
			miembro.setSexo("m");
			miembro.setDetalleDireccion("Detalle default");
			usuarioUpgrade.setMiembro(miembro);
			usuarioUpgrade.setContrasena("admin");
			
			usuarioBO.saveOrUpdate(usuarioUpgrade);
			return usuarioUpgrade;
		}else {
			return usuarioBO.getUsuarioByID(Session.DEFAULT_USER_ID);
		}
	}//END GENERATE DEFAULT USER
}
