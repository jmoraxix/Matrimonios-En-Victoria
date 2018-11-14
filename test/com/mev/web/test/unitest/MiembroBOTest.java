package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.mev.web.model.Miembro;
import com.mev.web.service.MiembroBO;

public class MiembroBOTest {

	@Autowired
	private MiembroBO miembroBO;
		
		@Test(expected = NullPointerException.class)
		public void ListaVacia() {
			Collection<Miembro> listaMiembro = this.miembroBO.listMiembros();
			assertNull("Retorno de Miembros Nulo",listaMiembro);
		}
		
		@Test
		public void ListaNoVacia() {
			Collection<Miembro> listaMiembro = this.miembroBO.listMiembros();
			assertNotNull("Retorno de Miembros NO Nulo",listaMiembro);
		}
}
