package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Canton;

public interface CantonDAO {
	
	public void save(Canton Canton);
	
	public void update(Canton Canton);
	
	public void delete(Canton Canton);
	
	public Canton getCantonByID(int CantonID);
	
	public Collection<Canton> listCantons();
	
}
