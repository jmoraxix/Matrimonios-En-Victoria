package com.mev.web.test.unitest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.junit.Test;

import com.mev.web.model.Canton;
import com.mev.web.service.CantonBO;

public class CantonBOTest {
private CantonBO cantonBO;



	@Test(expected = NullPointerException.class)
	public void ListaVacia() {
		Collection<Canton> listaCanton = this.cantonBO.listCantones();
		assertNull("Retorno de Cantones NULO", listaCanton);	
	}
	
	@Test
	public void ListaNoVacia() {
		Collection<Canton> listaCanton = this.cantonBO.listCantones();
		assertNotNull("Retorno de Cantones NO NULO", listaCanton);	
	}
	
	
	
	
}
