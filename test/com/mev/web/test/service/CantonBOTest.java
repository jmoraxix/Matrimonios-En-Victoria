package com.mev.web.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mev.web.model.Canton;
import com.mev.web.model.Provincia;
import com.mev.web.service.CantonBO;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.ProvinciaBO;

public class CantonBOTest {

	@Autowired(required = true)
	private CantonBO cantonBO;

	@Autowired(required = true)
	private ProvinciaBO provinciaBO;

	@Autowired(required = true)
	private DistritoBO distritoBO;

	/*
	 * @Test(expected = NullPointerException.class) public void ListaVacia() {
	 * Collection<Canton> listaCanton = this.cantonBO.listCantones();
	 * assertNull("Retorno de Cantones NULO", listaCanton); }
	 */
	/*
	 * public void saveCanton() { Provincia prov = new Provincia("San Jose");
	 * //provinciaBO.save(prov); provinciaBO.update(prov); Canton cant = new
	 * Canton("Desamparados",prov); //cantonBO.save(cant); cantonBO.update(cant); }
	 */

	@Test
	public void ListaNoVacia() {
		try {
			Provincia prov = new Provincia("San Jose");
			provinciaBO.save(prov);
			Canton cant = new Canton("Desamparados", prov);
			cantonBO.save(cant);
			Collection<Canton> listaCanton = this.cantonBO.listCantones();
			assertNotNull("Retorno de Cantones NO NULO", listaCanton);
		} catch (Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			System.err.println(e);
			fail();
		}
	}

}
