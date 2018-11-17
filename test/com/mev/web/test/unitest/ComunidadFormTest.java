package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import org.junit.Test;

import testing.ComunidadFormTesting;

public class ComunidadFormTest {

	//si el nombre de la comunidad no contiene numeros aprueba
	@Test
	public void test() {
		ComunidadFormTesting test = new ComunidadFormTesting();
		String expected = "Comunidad X";
		String nombre = test.ComunidadFormName(expected);
		assertEquals(expected,nombre);
		
	}
	
	//si el ID de la comunidad  contiene numeros aprueba
	@Test
	public void test1() {
		ComunidadFormTesting test = new ComunidadFormTesting();
		String expected = "1";
		String ID = test.ComunidadFormID(expected);
		assertEquals(expected,ID);
		
	}
	
	@Test
	public void test2() {
		ComunidadFormTesting test = new ComunidadFormTesting();
		String expected = "s";
		String detalle = test.ComunidadFormDetalle(expected);
		assertEquals(expected,detalle);
		
	}

}
