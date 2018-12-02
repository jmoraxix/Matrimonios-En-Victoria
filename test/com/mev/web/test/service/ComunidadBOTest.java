package com.mev.web.test.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mev.web.model.Canton;
import com.mev.web.model.Comunidad;
import com.mev.web.model.Distrito;
import com.mev.web.model.Provincia;
import com.mev.web.service.CantonBO;
import com.mev.web.service.ComunidadBO;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.ProvinciaBO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
public class ComunidadBOTest {

	@Autowired(required = true)
	private ComunidadBO comunidadBO;
	@Autowired(required = true)
	private ProvinciaBO provinciaBO;
	@Autowired(required = true)
	private CantonBO cantonBO;
	@Autowired(required = true)
	private DistritoBO distritoBO;

	/*
	 * @Test(expected = NullPointerException.class) public void ListaVacia() {
	 * Collection<Comunidad> listaComunidad = this.comunidadBO.listComunidades();
	 * assertNull("Retorno de Comunidades NULO", listaComunidad); }
	 */

	@Test
	public void ListaNoVacia() {
		try {
			Provincia prov = new Provincia("San Jose");
			provinciaBO.save(prov);

			Canton cant = new Canton("Desamparados", prov);
			cantonBO.save(cant);

			Distrito dist = new Distrito("San Miguel", cant);
			distritoBO.save(dist);

			Comunidad comu = new Comunidad(dist, "Comunidad x", "Es la comunidad central");
			comunidadBO.save(comu);

			Collection<Comunidad> listaComunidad = this.comunidadBO.listComunidades();
			assertNotNull("Retorno de Comunidades NO NULO", listaComunidad);
		} catch (Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			fail();
		}
	}

}
