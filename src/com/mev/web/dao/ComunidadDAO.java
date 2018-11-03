package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Comunidad;

public interface ComunidadDAO {
	
	public void save(Comunidad Comunidad);
	
	public void update(Comunidad Comunidad);
	
	public void delete(Comunidad Comunidad);
	
	public Comunidad getComunidadByID(int ComunidadID);
	
	public Collection<Comunidad> listComunidades();
	
}
