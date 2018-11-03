package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.CantonDAO;
import com.mev.web.model.Canton;
import com.mev.web.service.CantonBO;

@Transactional
@Service
public class CantonBOImpl implements CantonBO {

	@Autowired
	private CantonDAO CantonDAO;

	@Override
	public void save(Canton Canton) {
		this.CantonDAO.save(Canton);
	}

	@Override
	public void update(Canton Canton) {
		this.CantonDAO.update(Canton);
	}

	@Override
	public void delete(Canton Canton) {
		this.CantonDAO.delete(Canton);
	}

	@Override
	public Canton getCantonByID(int CantonId) {
		return this.CantonDAO.getCantonByID(CantonId);
	}

	@Override
	public Collection<Canton> listCantons() {
		return this.CantonDAO.listCantons();
	}

}
