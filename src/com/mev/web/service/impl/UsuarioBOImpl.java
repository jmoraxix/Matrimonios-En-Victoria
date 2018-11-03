package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.UsuarioDAO;
import com.mev.web.model.Usuario;
import com.mev.web.service.UsuarioBO;

@Transactional
@Service
public class UsuarioBOImpl implements UsuarioBO {

	@Autowired
	private UsuarioDAO UsuarioDAO;
	
	@Override
	public void save(Usuario Usuario) {
		this.UsuarioDAO.save(Usuario);
	}

	@Override
	public void update(Usuario Usuario) {
		this.UsuarioDAO.update(Usuario);
	}

	@Override
	public void delete(Usuario Usuario) {
		this.UsuarioDAO.delete(Usuario);
	}

	@Override
	public Usuario getUsuarioByID(String cedula) {
		return this.UsuarioDAO.getUsuarioByID(cedula);
	}

	@Override
	public Collection<Usuario> listUsuarios() {
		return this.UsuarioDAO.listUsuarios();
	}

	@Override
	public Collection<Usuario> searchUsuarios(String termino) {
		// TODO Auto-generated method stub
		return this.UsuarioDAO.searchUsuarios(termino);
	}
}
