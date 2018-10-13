package com.mev.web.dao;

import java.util.Collection;

import com.mev.web.model.Usuario;

public interface UsuarioDAO {
	
	public void save(Usuario Usuario);
	
	public void update(Usuario Usuario);
	
	public void delete(Usuario Usuario);
	
	public Usuario getUsuarioByID(String cedula);
	
	public Collection<Usuario> listUsuarios();
}
