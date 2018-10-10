package com.mev.web.service;

import java.util.Collection;

import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;

public interface MiembroBO {
	
	public void save(Miembro miembro);
	
	public void update(Miembro miembro);
	
	public void delete(Miembro miembro);
	
	public Miembro getMiembroByID(String cedula);
	
	public Collection<Miembro> listMiembros();
}