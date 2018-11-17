package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.ReunionDAO;
import com.mev.web.model.Reunion;
import com.mev.web.service.ReunionBO;

@Transactional
@Service
public class ReunionBOImpl implements ReunionBO {

	@Autowired
	private ReunionDAO ReunionDAO;

	@Override
	public void save(Reunion Reunion) {
		this.ReunionDAO.save(Reunion);
	}

	@Override
	public void update(Reunion Reunion) {
		this.ReunionDAO.update(Reunion);
	}

	@Override
	public void delete(Reunion Reunion) {
		this.ReunionDAO.delete(Reunion);
	}

	@Override
	public Reunion getReunionByID(int reunionId) {
		return this.ReunionDAO.getReunionByID(reunionId);
	}

	@Override
	public Collection<Reunion> listReuniones() {
		return this.ReunionDAO.listReuniones();
	}

}
