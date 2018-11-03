package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.DistritoDAO;
import com.mev.web.model.Distrito;
import com.mev.web.service.DistritoBO;

@Transactional
@Service
public class DistritoBOImpl implements DistritoBO {

	@Autowired
	private DistritoDAO DistritoDAO;

	@Override
	public void save(Distrito Distrito) {
		this.DistritoDAO.save(Distrito);
	}

	@Override
	public void update(Distrito Distrito) {
		this.DistritoDAO.update(Distrito);
	}

	@Override
	public void delete(Distrito Distrito) {
		this.DistritoDAO.delete(Distrito);
	}

	@Override
	public Distrito getDistritoByID(int DistritoId) {
		return this.DistritoDAO.getDistritoByID(DistritoId);
	}

	@Override
	public Collection<Distrito> listDistritos() {
		return this.DistritoDAO.listDistritos();
	}

}
