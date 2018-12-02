package com.mev.web.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mev.web.model.Canton;
import com.mev.web.model.Provincia;
import com.mev.web.service.CantonBO;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.ProvinciaBO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
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
			//En caso de que no halla nada, intentar crear
			try {
				Provincia prov = new Provincia("San Jose");
				provinciaBO.save(prov);
				Canton cant = new Canton("Desamparados", prov);
				cantonBO.save(cant);
			}catch(Exception e) {
				
			}
			Collection<Canton> listaCanton = this.cantonBO.listCantones();
			assertNotNull("Retorno de Cantones NO NULO", listaCanton);
		} catch (Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			System.err.println(e);
			fail();
		}
	}

}
