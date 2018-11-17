package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import org.junit.Test;

import testing.CantonFormTesting;

public class CantonFormTest {

	//si los nombres de canton NO contienen numeros = aprueba
	@Test
	public void test() {
		CantonFormTesting test = new CantonFormTesting();
		String expected="Desamparados";
		String nombre = test.CantonFormName(expected);
		assertEquals(expected,nombre);
	}
	
	//si el id del canton contiene unicamente numeros = aprueba
	@Test
	public void test1() {
		CantonFormTesting test = new CantonFormTesting();
		String expected="1";
		String ID = test.CantonFormID(expected);
		assertEquals(expected,ID);
	}

}
