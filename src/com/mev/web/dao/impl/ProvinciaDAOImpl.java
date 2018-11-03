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
import com.mev.web.dao.ProvinciaDAO;
import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;
import com.mev.web.model.Provincia;


@Repository
public class ProvinciaDAOImpl extends AbstractDAO implements ProvinciaDAO {

	@Override
	public void save(Provincia Provincia) {
		persist(Provincia);
	}

	@Override
	public void update(Provincia Provincia) {
		getSession().update(Provincia);
	}

	@Override
	public void delete(Provincia Provincia) {
		getSession().delete(Provincia);
	}

	@Override
	public Provincia getProvinciaByID(int provinciaID) {
		Criteria criteria = getSession().createCriteria(Provincia.class);
		criteria.add(Restrictions.eq("provinciaId", provinciaID));
		List<Provincia> listaProvincias = (List<Provincia>)criteria.list();

		//Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaProvincias.isEmpty()){
			return null;
		}
		//Si hay match, retornamos el elemento, en este caso es la 
		//llave primaria asi que es seguro asumir que solo hay un resultado
		return listaProvincias.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Provincia> listProvincias() {
		Criteria criteria = getSession().createCriteria(Provincia.class);
        return (List<Provincia>)criteria.list();
	}
	
}