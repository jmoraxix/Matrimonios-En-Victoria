package com.mev.web.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mev.web.dao.AbstractDAO;
import com.mev.web.dao.GrupoDAO;
import com.mev.web.model.Grupo;

@Repository
public class GrupoDAOImpl extends AbstractDAO implements GrupoDAO {

	@Override
	public void save(Grupo Grupo) {
		persist(Grupo);
		getSession().flush();
	}

	@Override
	public void update(Grupo Grupo) {
		getSession().update(Grupo);
	}

	@Override
	public void delete(Grupo Grupo) {
		getSession().delete(Grupo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Grupo getGrupoByID(int GrupoID) {
		Criteria criteria = getSession().createCriteria(Grupo.class);
		criteria.add(Restrictions.eq("grupoId", GrupoID));
		List<Grupo> listaGrupos = (List<Grupo>) criteria.list();

		// Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaGrupos.isEmpty()) {
			return null;
		}
		// Si hay match, retornamos el elemento, en este caso es la
		// llave primaria asi que es seguro asumir que solo hay un resultado
		return listaGrupos.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Grupo> listGrupos() {
		Criteria criteria = getSession().createCriteria(Grupo.class);
		return (List<Grupo>) criteria.list();
	}

}