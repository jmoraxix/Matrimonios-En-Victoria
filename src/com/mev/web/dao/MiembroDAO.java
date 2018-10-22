package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;

public interface MiembroDAO {
	
	public void save(Miembro miembro);
	
	public void update(Miembro miembro);
	
	public void delete(Miembro miembro);
	
	public Miembro getMiembroByID(String cedula);
	
	public Collection<Miembro> listMiembros();
	
	public Collection<Miembro> searchMiembros(String cedula, String nombre, String apellido);
	
	public Collection<Miembro> searchMiembros(String termino);
}
