package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import forms.newUsuarioForm;

public class UsuarioFormTest {

	//@Autowired
	private newUsuarioForm usuarioForm;
	
	//confirmar que las contraseñas sean iguales
	@Test
	public void test() {
		newUsuarioForm usuarioForm = new newUsuarioForm();
		usuarioForm.setContrasena("1");
		usuarioForm.setConfirmarContrasena("1");
		final String contrasena = usuarioForm.getContrasena();
		final String confContrasena = usuarioForm.getConfirmarContrasena();
		Assert.assertEquals( contrasena,confContrasena);
		Assert.assertNotNull(contrasena,confContrasena);
	}

}
