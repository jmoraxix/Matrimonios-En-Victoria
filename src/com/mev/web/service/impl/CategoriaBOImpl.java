package com.mev.web.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mev.web.dao.CategoriaDAO;
import com.mev.web.model.Categoria;
import com.mev.web.service.CategoriaBO;

@Transactional
@Service
public class CategoriaBOImpl implements CategoriaBO {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public void save(Categoria categoria) {
		this.categoriaDAO.save(categoria);
	}

	@Override
	public void update(Categoria categoria) {
		this.categoriaDAO.update(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		this.categoriaDAO.delete(categoria);
	}

	@Override
	public Categoria getCategoriaById(int categoriaId) {
		return this.categoriaDAO.getCategoriaById(categoriaId);
	}

	@Override
	public Collection<Categoria> listCategorias() {
		return this.categoriaDAO.listCategorias();
	}
}
