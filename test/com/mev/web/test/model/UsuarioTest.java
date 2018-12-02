package com.mev.web.test.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import forms.newUsuarioForm;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
public class UsuarioTest {

	// @Autowired
	private newUsuarioForm usuarioForm;

	// confirmar que las contrasenas sean iguales
	@Test
	public void test() {
		newUsuarioForm usuarioForm = new newUsuarioForm();
		usuarioForm.setContrasena("1");
		usuarioForm.setConfirmarContrasena("1");
		final String contrasena = usuarioForm.getContrasena();
		final String confContrasena = usuarioForm.getConfirmarContrasena();
		Assert.assertEquals(contrasena, confContrasena);
		Assert.assertNotNull(contrasena, confContrasena);
	}

}
