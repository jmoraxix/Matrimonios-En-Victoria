package com.mev.web.service;

import java.util.Collection;

import com.mev.web.model.Distrito;

public interface DistritoBO {
	
	public void save(Distrito Distrito);
	
	public void update(Distrito Distrito);
	
	public void delete(Distrito Distrito);
	
	public Distrito getDistritoByID(int DistritoId);
	
	public Collection<Distrito> listDistritos();
	
}
