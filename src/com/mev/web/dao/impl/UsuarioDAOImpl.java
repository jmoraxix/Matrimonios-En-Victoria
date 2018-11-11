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
import com.mev.web.dao.UsuarioDAO;
import com.mev.web.model.Categoria;
import com.mev.web.model.Miembro;
import com.mev.web.model.Usuario;


@Repository
public class UsuarioDAOImpl extends AbstractDAO implements UsuarioDAO {

	@Override
	public void save(Usuario Usuario) {
		persist(Usuario);
	}
	
	@Override
	public void saveOrUpdate(Usuario Usuario) {
		getSession().saveOrUpdate(Usuario);
	}

	@Override
	public void update(Usuario Usuario) {
		getSession().update(Usuario);
	}

	@Override
	public void delete(Usuario Usuario) {
		getSession().delete(Usuario);
	}

	@Override
	public Usuario getUsuarioByID(String cedula) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("cedula", cedula));
		List<Usuario> listaUsuarios = (List<Usuario>)criteria.list();

		//Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaUsuarios.isEmpty()){
			return null;
		}
		//Si hay match, retornamos el elemento, en este caso es la 
		//llave primaria asi que es seguro asumir que solo hay un resultado
		return listaUsuarios.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Usuario> listUsuarios() {
		Criteria criteria = getSession().createCriteria(Usuario.class);
        return (List<Usuario>)criteria.list();
	}

	@Override
	public Collection<Usuario> searchUsuarios(String termino){
		//Vamos a hacer un like
		//asi que los concatenamos y anadimos el wildcard
		String terminoLike = termino;
		
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.createAlias("miembro", "m");
		//Cada Criterion representa una operacion booleana, y se pueden meter dentro de otros Criterions (son recursivos)
		Criterion nombreMatch = Restrictions.ilike("m.nombre", termino, MatchMode.ANYWHERE);
		Criterion apellidoMatch = Restrictions.ilike("m.apellido", termino, MatchMode.ANYWHERE);
		Criterion cedulaMatch = Restrictions.ilike("m.cedula", termino, MatchMode.ANYWHERE);
		
		//Usamos el metodo OR para retornar lo que cumpla con al menos una
		Criterion matchTotal = Restrictions.or(nombreMatch, apellidoMatch, cedulaMatch);
		//Anadimos la condicion al query
		criteria.add(matchTotal);
		//Retorno de resultados
        return (List<Usuario>)criteria.list();
	}
	
}