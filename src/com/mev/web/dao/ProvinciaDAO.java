package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Provincia;

public interface ProvinciaDAO {
	
	public void save(Provincia Provincia);
	
	public void update(Provincia Provincia);
	
	public void delete(Provincia Provincia);
	
	public Provincia getProvinciaByID(int provinciaID);
	
	public Collection<Provincia> listProvincias();
	
}
