package com.mev.web.test.unitest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.mev.web.model.Miembro;
import com.mev.web.service.MiembroBO;

public class MiembroBOTest {

	@Autowired(required = true)
	private MiembroBO miembroBO;
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

		
		/*@Test(expected = NullPointerException.class)
		public void ListaVacia() {
			Collection<Miembro> listaMiembro = this.miembroBO.listMiembros();
			assertNull("Retorno de Miembros Nulo",listaMiembro);
		}*/
		
		@Test
		public void ListaNoVacia() throws ParseException {
			//try {
				 Date date1 = dateformat.parse("1995-05-01");
				Miembro miem = new Miembro("156464","Alfonso","Perez",date1,"Desamparados, San Jose","Masculino");
				miembroBO.save(miem);
				Collection<Miembro> listaMiembro = this.miembroBO.listMiembros();
				assertNotNull("Retorno de Miembros NO Nulo",listaMiembro);
			//}catch(Exception e) {
				//System.err.println("Excepcion durante Consulta de Cantones");
				//fail(); 		
			//}
		}
}
