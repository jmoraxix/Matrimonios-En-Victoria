package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Distrito;

public interface DistritoDAO {
	
	public void save(Distrito Distrito);
	
	public void update(Distrito Distrito);
	
	public void delete(Distrito Distrito);
	
	public Distrito getDistritoByID(int DistritoID);
	
	public Collection<Distrito> listDistritos();
	
}
