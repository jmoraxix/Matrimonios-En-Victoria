package com.mev.web.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.mev.web.dao.AbstractDAO;
import com.mev.web.dao.CategoriaDAO;
import com.mev.web.dao.MiembroDAO;
import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;


@Repository
public class MiembroDAOImpl extends AbstractDAO implements MiembroDAO {

	@Override
	public void save(Miembro miembro) {
		persist(miembro);
	}

	@Override
	public void update(Miembro miembro) {
		getSession().update(miembro);
	}

	@Override
	public void delete(Miembro miembro) {
		getSession().delete(miembro);
	}

	@Override
	public Miembro getMiembroByID(String cedula) {
		Criteria criteria = getSession().createCriteria(Miembro.class);
		List<Miembro> listaMiembros = (List<Miembro>)criteria.list();

		if (!listaMiembros.isEmpty()){
			for(Miembro miembroItem : listaMiembros) {
				//Si el item titne la cedula que estamos buscando, devuelvala
				if(miembroItem.getCedula().equals(cedula)) {
					return miembroItem;
				}
			}
		}
		//Si no hay match, o no hay resultados, devuelve null
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Miembro> listMiembros() {
		Criteria criteria = getSession().createCriteria(Miembro.class);
        return (List<Miembro>)criteria.list();
	}

	
}