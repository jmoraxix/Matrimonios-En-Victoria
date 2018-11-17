package com.mev.web.test.unitest;

import org.junit.Assert;
import org.junit.Test;

import forms.newUsuarioForm;

public class UsuarioFormTest {

	//@Autowired
	private newUsuarioForm usuarioForm;
	
	//confirmar que las contrasenas sean iguales
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
