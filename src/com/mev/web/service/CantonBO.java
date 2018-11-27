package com.mev.web.service;

import java.util.Collection;

import com.mev.web.model.Canton;

public interface CantonBO {

	public void save(Canton Canton);

	public void update(Canton Canton);

	public void delete(Canton Canton);

	public Canton getCantonByID(int CantonId);

	public Collection<Canton> listCantones();

}
