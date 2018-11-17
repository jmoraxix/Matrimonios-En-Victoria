package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Reunion;

public interface ReunionDAO {
	
	public void save(Reunion Reunion);
	
	public void update(Reunion Reunion);
	
	public void delete(Reunion Reunion);
	
	public Reunion getReunionByID(int reunionId);
	
	public Collection<Reunion> listReuniones();
	
}
