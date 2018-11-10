package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.GrupoDAO;
import com.mev.web.model.Grupo;
import com.mev.web.service.GrupoBO;

@Transactional
@Service
public class GrupoBOImpl implements GrupoBO {

	@Autowired
	private GrupoDAO GrupoDAO;

	@Override
	public void save(Grupo Grupo) {
		this.GrupoDAO.save(Grupo);
	}

	@Override
	public void update(Grupo Grupo) {
		this.GrupoDAO.update(Grupo);
	}

	@Override
	public void delete(Grupo Grupo) {
		this.GrupoDAO.delete(Grupo);
	}

	@Override
	public Grupo getGrupoByID(int GrupoId) {
		return this.GrupoDAO.getGrupoByID(GrupoId);
	}

	@Override
	public Collection<Grupo> listGrupos() {
		return this.GrupoDAO.listGrupos();
	}

}
