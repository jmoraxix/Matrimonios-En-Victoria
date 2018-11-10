package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Grupo;

public interface GrupoDAO {
	
	public void save(Grupo Grupo);
	
	public void update(Grupo Grupo);
	
	public void delete(Grupo Grupo);
	
	public Grupo getGrupoByID(int GrupoID);
	
	public Collection<Grupo> listGrupos();
	
}
