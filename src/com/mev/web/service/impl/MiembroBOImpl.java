package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.MiembroDAO;
import com.mev.web.model.Miembro;
import com.mev.web.service.MiembroBO;

@Transactional
@Service
public class MiembroBOImpl implements MiembroBO {

	@Autowired
	private MiembroDAO MiembroDAO;
	
	@Override
	public void save(Miembro Miembro) {
		this.MiembroDAO.save(Miembro);
	}

	@Override
	public void update(Miembro Miembro) {
		this.MiembroDAO.update(Miembro);
	}

	@Override
	public void delete(Miembro Miembro) {
		this.MiembroDAO.delete(Miembro);
	}

	@Override
	public Miembro getMiembroByID(String cedula) {
		return this.MiembroDAO.getMiembroByID(cedula);
	}

	@Override
	public Collection<Miembro> listMiembros() {
		return this.MiembroDAO.listMiembros();
	}
	
	@Override
	public Collection<Miembro> searchMiembros(String cedula, String nombre, String apellido) {
		return this.MiembroDAO.searchMiembros(cedula, nombre, apellido);
	}
	
	@Override
	public Collection<Miembro> searchMiembros(String termino) {
		return this.MiembroDAO.searchMiembros(termino);
	}
}
