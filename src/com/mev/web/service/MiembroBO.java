package com.mev.web.service;

import java.util.Collection;

import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;
import com.mev.web.model.Reunion;

public interface MiembroBO {
	
	public void save(Miembro miembro);
	
	public void update(Miembro miembro);
	
	public void delete(Miembro miembro);
	
	public Miembro getMiembroByID(String cedula);
	
	public Collection<Miembro> listMiembros();
	
	public Collection<Miembro> searchMiembros(String cedula, String nombre, String apellido);
	
	public Collection<Miembro> searchMiembros(String termino);
	
	public Collection<Miembro> searchMiembrosByReunion(String termino, Reunion reunion);
	
	public Collection<Miembro> listMiembrosByReunion(Reunion reunion);
}
