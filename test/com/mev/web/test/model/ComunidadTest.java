package com.mev.web.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
public class ComunidadTest {

	// si el nombre de la comunidad no contiene numeros aprueba
	@Test
	public void test() {
		String expected = "Comunidad X";
		String nombre = this.validateComunidadFormName(expected);
		assertEquals(expected, nombre);

	}

	// si el ID de la comunidad contiene numeros aprueba
	@Test
	public void test1() {
		String expected = "1";
		String ID = validateComunidadFormID(expected);
		assertEquals(expected, ID);

	}

	@Test
	public void test2() {
		String expected = "s";
		String detalle = validateComunidadFormDetalle(expected);
		assertEquals(expected, detalle);

	}

	private String validateComunidadFormName(String nombre) {
		if (nombre.matches(".*\\d+.*")) {
			nombre = null;
		}
		return nombre;
	}

	private String validateComunidadFormID(String ID) {
		if (!ID.matches("[0-9]+")) {
			ID = null;
		}
		return ID;
	}

	private String validateComunidadFormDetalle(String detalle) {
		if (detalle == null || detalle == "") {
			detalle = "false";
		}
		return detalle;
	}
}
