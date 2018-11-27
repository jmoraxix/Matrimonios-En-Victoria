package com.mev.web.test.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mev.web.model.Categoria;
import com.mev.web.service.CategoriaBO;

public class CategoriaBOTest {

	@Autowired(required = true)
	private CategoriaBO categoriaBO;

	/*
	 * @Test(expected = NullPointerException.class) public void ListaVacia() {
	 * Collection<Categoria> listaCategoria = this.categoriaBO.listCategorias();
	 * assertNull("Retorno de Categoria NULO", listaCategoria); }
	 */

	@Test
	public void ListaNoVacia() {
		try {
			// Categoria cate = new Categoria();
			Collection<Categoria> listaCategoria = this.categoriaBO.listCategorias();
			assertNotNull("Retorno de Categoria NO NULO", listaCategoria);
		} catch (Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			fail();
		}
	}
}
