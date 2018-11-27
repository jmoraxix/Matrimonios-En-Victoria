package com.mev.web.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mev.web.model.Canton;
import com.mev.web.model.Provincia;

public class CantonTest {

	public Canton canton;

	public CantonTest() {
		this.canton = new Canton(4, "Test Canton", new Provincia(3, "Test Provincia"));
	}

	// si los nombres de canton NO contienen numeros = aprueba
	@Test
	public void testNombre() {
		String expected = "Desamparados";
		String nombre = validateCantonFormName(expected);
		assertEquals(expected, nombre);
	}

	// si el id del canton contiene unicamente numeros = aprueba
	@Test
	public void testCantonId() {
		String expected = "1";
		String ID = validateCantonFormID(expected);
		assertEquals(expected, ID);
	}

	private String validateCantonFormName(String nombre) {
		if (nombre.matches(".*\\d+.*")) {
			nombre = null;
		}
		return nombre;
	}

	private String validateCantonFormID(String ID) {
		if (!ID.matches("[0-9]+")) {
			ID = null;
		}
		return ID;
	}

}
