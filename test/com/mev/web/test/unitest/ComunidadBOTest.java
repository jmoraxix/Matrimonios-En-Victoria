package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mev.web.model.Canton;
import com.mev.web.model.Comunidad;
import com.mev.web.model.Distrito;
import com.mev.web.model.Provincia;
import com.mev.web.service.CantonBO;
import com.mev.web.service.ComunidadBO;
import com.mev.web.service.DistritoBO;
import com.mev.web.service.ProvinciaBO;

public class ComunidadBOTest {

@Autowired
private ComunidadBO comunidadBO;
private ProvinciaBO provinciaBO;
private CantonBO cantonBO;
private DistritoBO distritoBO;


	/*@Test(expected = NullPointerException.class)
	public void ListaVacia() {
		Collection<Comunidad> listaComunidad = this.comunidadBO.listComunidades();
		assertNull("Retorno de Comunidades NULO", listaComunidad);	
	}*/

	@Test
	public void ListaNoVacia() {
		try {
			Provincia prov = new Provincia("San Jose");
			provinciaBO.save(prov);
			
			Canton cant = new Canton("Desamparados",prov);
			cantonBO.save(cant);
			
			Distrito dist = new Distrito("San Miguel",cant);
			distritoBO.save(dist);
			
			Comunidad comu = new Comunidad(dist,"Comunidad x","Es la comunidad central");
			comunidadBO.save(comu);
			
			Collection<Comunidad> listaComunidad = this.comunidadBO.listComunidades();
			assertNotNull("Retorno de Comunidades NO NULO", listaComunidad);	
		}catch(Exception e) {
			System.err.println("Excepcion durante Consulta de Cantones");
			fail(); 		
		}
	}
	
}