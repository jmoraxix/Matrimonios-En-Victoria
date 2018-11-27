package com.mev.web.service;

import java.util.Collection;

import com.mev.web.model.Provincia;

public interface ProvinciaBO {

	public void save(Provincia Provincia);

	public void update(Provincia Provincia);

	public void delete(Provincia Provincia);

	public Provincia getProvinciaByID(int provinciaId);

	public Collection<Provincia> listProvincias();

}
