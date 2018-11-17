package com.mev.web.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mev.web.dao.AbstractDAO;
import com.mev.web.dao.ReunionDAO;
import com.mev.web.model.Reunion;


@Repository
public class ReunionDAOImpl extends AbstractDAO implements ReunionDAO {

	@Override
	public void save(Reunion Reunion) {
		persist(Reunion);
		getSession().flush();
	}

	@Override
	public void update(Reunion Reunion) {
		getSession().update(Reunion);
	}

	@Override
	public void delete(Reunion Reunion) {
		getSession().delete(Reunion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Reunion getReunionByID(int reunionId) {
		Criteria criteria = getSession().createCriteria(Reunion.class);
		criteria.add(Restrictions.eq("reunionId", reunionId));
		List<Reunion> listaReuniones = (List<Reunion>)criteria.list();

		//Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaReuniones.isEmpty()){
			return null;
		}
		//Si hay match, retornamos el elemento, en este caso es la 
		//llave primaria asi que es seguro asumir que solo hay un resultado
		return listaReuniones.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Reunion> listReuniones() {
		Criteria criteria = getSession().createCriteria(Reunion.class);
        return (List<Reunion>)criteria.addOrder(Order.desc("fecha")).list();
	}
	
}