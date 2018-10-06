package com.mev.web.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.mev.web.dao.AbstractDAO;
import com.mev.web.dao.CategoriaDAO;
import com.mev.web.model.Categoria;


@Repository
public class CategoriaDAOImpl extends AbstractDAO implements CategoriaDAO {

	@Override
	public void save(Categoria categoria) {
		persist(categoria);
	}

	@Override
	public void update(Categoria categoria) {
		getSession().update(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		getSession().delete(categoria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Categoria getCategoriaById(int categoriaId) {
       
        Criteria criteria = getSession().createCriteria(Categoria.class);

        //CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		//CriteriaQuery<Categoria> criteriaQuery = builder.createQuery(Categoria.class);
		//Root<Categoria> categoriaRoot = criteria.from(Categoria.class);
		//criteriaQuery.select(categoriaRoot);
		//criteriaQuery.where(builder.equal(categoriaRoot.get("categoriaId"),categoriaId));
        //criteria.
		List<Categoria> listaCategorias = (List<Categoria>)criteria.list();

		Categoria categoria = null;
		if (!listaCategorias.isEmpty()){
			categoria = listaCategorias.iterator().next();
		}
		return categoria;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Categoria> listCategorias() {
        Criteria criteria = getSession().createCriteria(Categoria.class);
        return (List<Categoria>)criteria.list();
        //Get Criteria Builder
        /*CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> categoriaRoot = criteria.from(Categoria.class);
		criteria.select(categoriaRoot);
        //Use criteria to query with session to fetch all contacts
        Collection<Categoria> listaCategorias = getSession().createQuery(criteria).getResultList();

        return listaCategorias;*/
	}
}