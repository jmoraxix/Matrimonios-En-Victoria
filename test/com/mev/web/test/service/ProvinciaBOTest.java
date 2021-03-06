package com.mev.web.test.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mev.web.model.Provincia;
import com.mev.web.service.ProvinciaBO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
public class ProvinciaBOTest {

	@Autowired(required = true)
	private ProvinciaBO provinciaBO;

	/*
	 * @Test(expected = NullPointerException.class) public void ListaVacia() {
	 * Collection<Provincia> listaProvincia = this.provinciaBO.listProvincias();
	 * assertNull("Retorno de Provincias Nulo",listaProvincia); }
	 */

	@Test
	public void ListaNoVaciaTest() {
		Provincia prov = new Provincia("San Jose");
		provinciaBO.save(prov);
		try {

			Collection<Provincia> listaProvincia = this.provinciaBO.listProvincias();
			assertNotNull("Retorno de Provincias NO Nulo", listaProvincia);
		} catch (Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			fail();
		}
	}
}
