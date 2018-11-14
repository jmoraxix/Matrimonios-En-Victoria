package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mev.web.model.Usuario;
import com.mev.web.service.UsuarioBO;

public class UsuarioBOTest {

	@Autowired
	private UsuarioBO usuarioBO;
		
		@Test(expected = NullPointerException.class)
		public void ListaVacia() {
			Collection<Usuario> listaUsuario = this.usuarioBO.listUsuarios();
			assertNull("Retorno de Usuarios Nulo",listaUsuario);
		}
		
		@Test
		public void ListaNoVacia() {
			Collection<Usuario> listaUsuario = this.usuarioBO.listUsuarios();
			assertNotNull("Retorno de Usuarios NO Nulo",listaUsuario);
		}
}
