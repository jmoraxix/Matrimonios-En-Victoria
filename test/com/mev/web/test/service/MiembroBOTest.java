package com.mev.web.test.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mev.web.model.Miembro;
import com.mev.web.service.MiembroBO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:WebContent/WEB-INF/MatrimoniosEnVictoria-servlet.xml")
public class MiembroBOTest {

	@Autowired(required = true)
	private MiembroBO miembroBO;
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

	/*
	 * @Test(expected = NullPointerException.class) public void ListaVacia() {
	 * Collection<Miembro> listaMiembro = this.miembroBO.listMiembros();
	 * assertNull("Retorno de Miembros Nulo",listaMiembro); }
	 */

	@Test
	public void ListaNoVacia() throws ParseException {
		try {
			//Solo en caso de que no halla nada, tratamos de insertat uno nuevo
			try {
				Date date1 = dateformat.parse("1995-05-01");
				Miembro miem = new Miembro("156464", "Alfonso", "Perez", date1, "Desamparados, San Jose", "Masculino");
				miembroBO.save(miem);
			}catch(Exception e) {
				//Do nothing
			}
			Collection<Miembro> listaMiembro = this.miembroBO.listMiembros();
			assertNotNull("Retorno de Miembros NO Nulo", listaMiembro);
		} catch (Exception e) {
			// System.err.println("Excepcion durante Consulta de Cantones");
			System.err.println(e);
			fail();
		}
	}
}
