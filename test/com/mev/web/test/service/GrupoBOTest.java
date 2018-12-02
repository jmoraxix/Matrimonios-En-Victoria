package com.mev.web.test.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mev.web.model.Grupo;
import com.mev.web.service.GrupoBO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
public class GrupoBOTest {

	@Autowired(required = true)
	private GrupoBO grupoBO;

	/*
	 * @Test(expected = NullPointerException.class) public void ListaVacia() {
	 * Collection<Grupo> listaGrupo = this.grupoBO.listGrupos();
	 * assertNull("Retorno de Grupos Nulo",listaGrupo); }
	 */

	@Test
	public void ListaNoVacia() {
		try {
			Collection<Grupo> listaGrupo = this.grupoBO.listGrupos();
			assertNotNull("Retorno de Grupos NO Nulo", listaGrupo);
		} catch (Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			fail();
		}

	}
}
