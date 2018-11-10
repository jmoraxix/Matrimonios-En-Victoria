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
import com.mev.web.dao.ComunidadDAO;
import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;
import com.mev.web.model.Comunidad;


@Repository
public class ComunidadDAOImpl extends AbstractDAO implements ComunidadDAO {

	@Override
	public void save(Comunidad Comunidad) {
		persist(Comunidad);
		getSession().flush();
	}

	@Override
	public void update(Comunidad Comunidad) {
		getSession().update(Comunidad);
	}

	@Override
	public void delete(Comunidad Comunidad) {
		getSession().delete(Comunidad);
	}

	@Override
	public Comunidad getComunidadByID(int ComunidadID) {
		Criteria criteria = getSession().createCriteria(Comunidad.class);
		criteria.add(Restrictions.eq("comunidadId", ComunidadID));
		List<Comunidad> listaComunidads = (List<Comunidad>)criteria.list();

		//Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaComunidads.isEmpty()){
			return null;
		}
		//Si hay match, retornamos el elemento, en este caso es la 
		//llave primaria asi que es seguro asumir que solo hay un resultado
		return listaComunidads.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Comunidad> listComunidades() {
		Criteria criteria = getSession().createCriteria(Comunidad.class);
        return (List<Comunidad>)criteria.list();
	}
	
}