package com.mev.web.service;

import java.util.Collection;

import com.mev.web.model.Grupo;

public interface GrupoBO {
	
	public void save(Grupo Grupo);
	
	public void update(Grupo Grupo);
	
	public void delete(Grupo Grupo);
	
	public Grupo getGrupoByID(int GrupoId);
	
	public Collection<Grupo> listGrupos();
	
}
