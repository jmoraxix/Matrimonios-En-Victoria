package com.mev.web.test.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mev.web.model.Usuario;
import com.mev.web.service.UsuarioBO;

import forms.newUsuarioForm;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
public class UsuarioBOTest {

	@Autowired(required = true)
	private UsuarioBO usuarioBO;

	/*
	 * @Test(expected = NullPointerException.class) public void ListaVacia() {
	 * Collection<Usuario> listaUsuario = this.usuarioBO.listUsuarios();
	 * assertNull("Retorno de Usuarios Nulo",listaUsuario); }
	 */

	@Test
	public void ListaNoVacia() {
		try {
			try {
				//Solo en caso de que no exista, tratamos de insertar
				Usuario usua = new Usuario("test");
				usuarioBO.save(usua);	
			}catch(Exception e){
				//Do nothing
			}
			Collection<Usuario> listaUsuario = this.usuarioBO.listUsuarios();
			assertNotNull("Retorno de Usuarios NO Nulo", listaUsuario);
		} catch (Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			fail();
		}
	}
}
