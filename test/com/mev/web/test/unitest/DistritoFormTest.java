package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import org.junit.Test;

import testing.CantonFormTesting;
import testing.DistritoFormTesting;

public class DistritoFormTest {

	//si los nombres de distritos NO contienen numeros = aprueba
	@Test
	public void test() {
		DistritoFormTesting test = new DistritoFormTesting();
		String expected="San Miguel";
		String nombre = test.DistritoFormName(expected);
		assertEquals(expected,nombre);
	}
	
	//si el id del distrito contiene unicamente numeros = aprueba
	@Test
	public void test1() {
		DistritoFormTesting test = new DistritoFormTesting();
		String expected="1";
		String ID = test.DistritoFormID(expected);
		assertEquals(expected,ID);
	}

}
