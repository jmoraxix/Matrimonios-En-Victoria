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
import com.mev.web.dao.DistritoDAO;
import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;
import com.mev.web.model.Distrito;


@Repository
public class DistritoDAOImpl extends AbstractDAO implements DistritoDAO {

	@Override
	public void save(Distrito Distrito) {
		persist(Distrito);
		getSession().flush();
	}

	@Override
	public void update(Distrito Distrito) {
		getSession().update(Distrito);
	}

	@Override
	public void delete(Distrito Distrito) {
		getSession().delete(Distrito);
	}

	@Override
	public Distrito getDistritoByID(int DistritoID) {
		Criteria criteria = getSession().createCriteria(Distrito.class);
		criteria.add(Restrictions.eq("distritoId", DistritoID));
		List<Distrito> listaDistritos = (List<Distrito>)criteria.list();

		//Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaDistritos.isEmpty()){
			return null;
		}
		//Si hay match, retornamos el elemento, en este caso es la 
		//llave primaria asi que es seguro asumir que solo hay un resultado
		return listaDistritos.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Distrito> listDistritos() {
		Criteria criteria = getSession().createCriteria(Distrito.class);
        return (List<Distrito>)criteria.list();
	}
	
}