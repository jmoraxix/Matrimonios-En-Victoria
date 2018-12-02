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
public class DistritoTest {

	// si los nombres de distritos NO contienen numeros = aprueba
	@Test
	public void test() {
		String expected = "San Miguel";
		String nombre = validateDistritoFormName(expected);
		assertEquals(expected, nombre);
	}

	// si el id del distrito contiene unicamente numeros = aprueba
	@Test
	public void test1() {
		String expected = "1";
		String ID = validateDistritoFormID(expected);
		assertEquals(expected, ID);
	}

	public String validateDistritoFormName(String nombre) {
		if (nombre.matches(".*\\d+.*")) {
			nombre = null;
		}
		return nombre;
	}

	public String validateDistritoFormID(String ID) {
		if (!ID.matches("[0-9]+")) {
			ID = null;
		}
		return ID;
	}

}
