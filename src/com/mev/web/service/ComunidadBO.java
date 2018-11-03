package com.mev.web.service;

import java.util.Collection;

import com.mev.web.model.Comunidad;

public interface ComunidadBO {
	
	public void save(Comunidad Comunidad);
	
	public void update(Comunidad Comunidad);
	
	public void delete(Comunidad Comunidad);
	
	public Comunidad getComunidadByID(int ComunidadId);
	
	public Collection<Comunidad> listComunidades();
	
}
