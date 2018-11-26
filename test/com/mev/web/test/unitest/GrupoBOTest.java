package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mev.web.model.Grupo;
import com.mev.web.service.GrupoBO;

public class GrupoBOTest {

	@Autowired(required = true)
private GrupoBO grupoBO;
	
	/*@Test(expected = NullPointerException.class)
	public void ListaVacia() {
		Collection<Grupo> listaGrupo = this.grupoBO.listGrupos();
		assertNull("Retorno de Grupos Nulo",listaGrupo);
	}*/
	
	@Test
	public void ListaNoVacia() {
		try {
		Collection<Grupo> listaGrupo = this.grupoBO.listGrupos();
		assertNotNull("Retorno de Grupos NO Nulo",listaGrupo);
	}catch(Exception e) {
		System.err.println("Excepcion durante Consulta de Cantones");
		fail(); 		
	}

}
}
