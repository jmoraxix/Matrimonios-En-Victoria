package com.mev.web.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mev.web.dao.AbstractDAO;
import com.mev.web.dao.CategoriaDAO;
import com.mev.web.dao.CantonDAO;
import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;
import com.mev.web.model.Canton;


@Repository
public class CantonDAOImpl extends AbstractDAO implements CantonDAO {

	@Override
	public void save(Canton Canton) {
		persist(Canton);
	}

	@Override
	public void update(Canton Canton) {
		getSession().update(Canton);
	}

	@Override
	public void delete(Canton Canton) {
		getSession().delete(Canton);
	}

	@Override
	public Canton getCantonByID(int CantonID) {
		Criteria criteria = getSession().createCriteria(Canton.class);
		criteria.add(Restrictions.eq("cantonId", CantonID));
		List<Canton> listaCantons = (List<Canton>)criteria.list();

		//Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaCantons.isEmpty()){
			return null;
		}
		//Si hay match, retornamos el elemento, en este caso es la 
		//llave primaria asi que es seguro asumir que solo hay un resultado
		return listaCantons.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Canton> listCantones() {
		Criteria criteria = getSession().createCriteria(Canton.class);
        return (List<Canton>)criteria.list();
	}
	
}