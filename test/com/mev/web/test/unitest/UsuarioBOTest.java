package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mev.web.model.Usuario;
import com.mev.web.service.UsuarioBO;

import forms.newUsuarioForm;

public class UsuarioBOTest {

	@Autowired(required = true)
	private UsuarioBO usuarioBO;
		
		/*@Test(expected = NullPointerException.class)
		public void ListaVacia() {
			Collection<Usuario> listaUsuario = this.usuarioBO.listUsuarios();
			assertNull("Retorno de Usuarios Nulo",listaUsuario);
		}*/
		
		@Test
		public void ListaNoVacia() {
			try {
				Usuario usua = new Usuario("test");
				usuarioBO.save(usua);
			Collection<Usuario> listaUsuario = this.usuarioBO.listUsuarios();
			assertNotNull("Retorno de Usuarios NO Nulo",listaUsuario);
			}catch(Exception e) {
				System.err.println("Excepcion durante Consulta de Cantones");
				fail(); 		
			}
		}
}
