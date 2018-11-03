package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.ComunidadDAO;
import com.mev.web.model.Comunidad;
import com.mev.web.service.ComunidadBO;

@Transactional
@Service
public class ComunidadBOImpl implements ComunidadBO {

	@Autowired
	private ComunidadDAO ComunidadDAO;

	@Override
	public void save(Comunidad Comunidad) {
		this.ComunidadDAO.save(Comunidad);
	}

	@Override
	public void update(Comunidad Comunidad) {
		this.ComunidadDAO.update(Comunidad);
	}

	@Override
	public void delete(Comunidad Comunidad) {
		this.ComunidadDAO.delete(Comunidad);
	}

	@Override
	public Comunidad getComunidadByID(int ComunidadId) {
		return this.ComunidadDAO.getComunidadByID(ComunidadId);
	}

	@Override
	public Collection<Comunidad> listComunidades() {
		return this.ComunidadDAO.listComunidades();
	}

}
