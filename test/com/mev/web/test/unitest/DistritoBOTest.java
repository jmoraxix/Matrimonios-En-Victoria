package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mev.web.model.Distrito;
import com.mev.web.service.DistritoBO;

public class DistritoBOTest {

	@Autowired
	private DistritoBO distritoBO;

		@Test(expected = NullPointerException.class)
		public void ListaVacia() {
			Collection<Distrito> listaDistrito = this.distritoBO.listDistritos();
			assertNull("Retorno de Distritos NULO", listaDistrito);	
		}

		@Test
		public void ListaNoVacia() {
			Collection<Distrito> listaDistrito = this.distritoBO.listDistritos();
			assertNotNull("Retorno de Distritos NO NULO", listaDistrito);		
		}
}
