package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.mev.web.model.Comunidad;
import com.mev.web.service.ComunidadBO;

public class ComunidadBOTest {

@Autowired
private ComunidadBO comunidadBO;

	@Test(expected = NullPointerException.class)
	public void ListaVacia() {
		Collection<Comunidad> listaComunidad = this.comunidadBO.listComunidades();
		assertNull("Retorno de Comunidades NULO", listaComunidad);	
	}

	@Test
	public void ListaNoVacia() {
		Collection<Comunidad> listaComunidad = this.comunidadBO.listComunidades();
		assertNotNull("Retorno de Comunidades NO NULO", listaComunidad);	
	}
	
}
