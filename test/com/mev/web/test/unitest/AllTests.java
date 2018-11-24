package com.mev.web.test.unitest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BasicTest.class, CantonBOTest.class, CantonFormTest.class, CategoriaBOTest.class, ComunidadBOTest.class,
		ComunidadFormTest.class, DistritoBOTest.class, DistritoFormTest.class, GrupoBOTest.class, MiembroBOTest.class,
		ProvinciaBOTest.class, UsuarioBOTest.class, UsuarioFormTest.class })
public class AllTests {

}
