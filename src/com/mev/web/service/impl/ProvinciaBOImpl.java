package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.ProvinciaDAO;
import com.mev.web.model.Provincia;
import com.mev.web.service.ProvinciaBO;

@Transactional
@Service
public class ProvinciaBOImpl implements ProvinciaBO {

	@Autowired
	private ProvinciaDAO ProvinciaDAO;

	@Override
	public void save(Provincia Provincia) {
		this.ProvinciaDAO.save(Provincia);
	}

	@Override
	public void update(Provincia Provincia) {
		this.ProvinciaDAO.update(Provincia);
	}

	@Override
	public void delete(Provincia Provincia) {
		this.ProvinciaDAO.delete(Provincia);
	}

	@Override
	public Provincia getProvinciaByID(int provinciaId) {
		return this.ProvinciaDAO.getProvinciaByID(provinciaId);
	}

	@Override
	public Collection<Provincia> listProvincias() {
		return this.ProvinciaDAO.listProvincias();
	}

}
