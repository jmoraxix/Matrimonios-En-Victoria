package com.mev.web.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
		criteria.add(Restrictions.eq("cedula", cedula));
		List<Miembro> listaMiembros = (List<Miembro>)criteria.list();

		//Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaMiembros.isEmpty()){
			return null;
		}
		//Si hay match, retornamos el elemento, en este caso es la 
		//llave primaria asi que es seguro asumir que solo hay un resultado
		return listaMiembros.get(0);
	}
	@Override
	public Collection<Miembro> searchMiembros(String cedula, String nombre, String apellido){
		//Vamos a hacer un like, y no importa si unimos nombre y apellidos (palabras del cliente)
		//asi que los concatenamos y anadimos el wildcard
		String cedulaLike = "%" + cedula + "%";
		String nombreLike = "%" + nombre + "%";
		String apellidoLike = "%" + apellido + "%";
		
		Criteria criteria = getSession().createCriteria(Miembro.class);
		//Cada Criterion representa una operacion booleana, y se pueden meter dentro de otros Criterions (son recursivos)
		Criterion nombreMatch = Restrictions.like("nombre", nombreLike);
		Criterion apellidoMatch = Restrictions.like("apellido", apellidoLike);
		Criterion cedulaMatch = Restrictions.like("cedula", cedulaLike);
		
		//Usamos el metodo OR para retornar lo que cumpla con al menos una
		Criterion matchTotal = Restrictions.or(nombreMatch, apellidoMatch, cedulaMatch);
		//Anadimos la condicion al query
		criteria.add(matchTotal);
		//Retorno de resultados
        return (List<Miembro>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Miembro> listMiembros() {
		Criteria criteria = getSession().createCriteria(Miembro.class);
        return (List<Miembro>)criteria.list();
	}

	
}