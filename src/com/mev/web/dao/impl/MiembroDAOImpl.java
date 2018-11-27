package com.mev.web.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mev.web.dao.AbstractDAO;
import com.mev.web.dao.MiembroDAO;
import com.mev.web.model.Miembro;
import com.mev.web.model.Reunion;

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

	@SuppressWarnings("unchecked")
	@Override
	public Miembro getMiembroByID(String cedula) {
		Criteria criteria = getSession().createCriteria(Miembro.class);
		criteria.add(Restrictions.eq("cedula", cedula));
		List<Miembro> listaMiembros = (List<Miembro>) criteria.list();

		// Revisamos si no hay resultado, en cuyo caso retornamos null
		if (listaMiembros.isEmpty()) {
			return null;
		}
		// Si hay match, retornamos el elemento, en este caso es la
		// llave primaria asi que es seguro asumir que solo hay un resultado
		return listaMiembros.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Miembro> searchMiembros(String cedula, String nombre, String apellido) {
		// Vamos a hacer un like
		// asi que los concatenamos y anadimos el wildcard
		String cedulaLike = cedula;
		String nombreLike = nombre;
		String apellidoLike = apellido;

		Criteria criteria = getSession().createCriteria(Miembro.class);
		// Cada Criterion representa una operacion booleana, y se pueden meter dentro de
		// otros Criterions (son recursivos)
		Criterion nombreMatch = Restrictions.ilike("nombre", nombreLike, MatchMode.ANYWHERE);
		Criterion apellidoMatch = Restrictions.ilike("apellido", apellidoLike, MatchMode.ANYWHERE);
		Criterion cedulaMatch = Restrictions.ilike("cedula", cedulaLike, MatchMode.ANYWHERE);

		// Usamos el metodo OR para retornar lo que cumpla con al menos una
		Criterion matchTotal = Restrictions.or(nombreMatch, apellidoMatch, cedulaMatch);
		// Anadimos la condicion al query
		criteria.add(matchTotal);
		// Retorno de resultados
		return (List<Miembro>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Miembro> searchMiembros(String termino) {
		// Vamos a hacer un like
		// asi que los concatenamos y anadimos el wildcard
		String terminoLike = termino;

		Criteria criteria = getSession().createCriteria(Miembro.class);
		// Cada Criterion representa una operacion booleana, y se pueden meter dentro de
		// otros Criterions (son recursivos)
		Criterion nombreMatch = Restrictions.ilike("nombre", termino, MatchMode.ANYWHERE);
		Criterion apellidoMatch = Restrictions.ilike("apellido", termino, MatchMode.ANYWHERE);
		Criterion cedulaMatch = Restrictions.ilike("cedula", termino, MatchMode.ANYWHERE);

		// Usamos el metodo OR para retornar lo que cumpla con al menos una
		Criterion matchTotal = Restrictions.or(nombreMatch, apellidoMatch, cedulaMatch);
		// Anadimos la condicion al query
		criteria.add(matchTotal);
		// Retorno de resultados
		return (List<Miembro>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Miembro> listMiembros() {
		Criteria criteria = getSession().createCriteria(Miembro.class);
		return (List<Miembro>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Miembro> listMiembrosByReunion(Reunion reunion) {
		Criteria criteria = getSession().createCriteria(Miembro.class);
		return (List<Miembro>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Miembro> searchMiembrosByReunion(String termino, Reunion reunion) {
		// Vamos a hacer un like
		// asi que los concatenamos y anadimos el wildcard
		String terminoLike = termino;

		Criteria criteria = getSession().createCriteria(Miembro.class);
		criteria.setFetchMode("reuniones", FetchMode.JOIN);
		criteria.createAlias("reuniones", "re");

		// Cada Criterion representa una operacion booleana, y se pueden meter dentro de
		// otros Criterions (son recursivos)
		Criterion nombreMatch = Restrictions.ilike("nombre", termino, MatchMode.ANYWHERE);
		Criterion apellidoMatch = Restrictions.ilike("apellido", termino, MatchMode.ANYWHERE);
		Criterion cedulaMatch = Restrictions.ilike("cedula", termino, MatchMode.ANYWHERE);

		// Seleccionar solo los miembros que NO esten ya en esa reunion
		Criterion miembroAsistente = Restrictions.not(Restrictions.eq("re.reunionId", reunion.getReunionId()));

		// Usamos el metodo OR para retornar lo que cumpla con al menos una
		Criterion likeTotal = Restrictions.or(nombreMatch, apellidoMatch, cedulaMatch);
		Criterion matchTotal = Restrictions.and(likeTotal, miembroAsistente);

		// Anadimos la condicion al query
		criteria.add(matchTotal);// .add(miembroAsistente);

		// Nos aseguramos que solo retorno una instancia de cada una, que las distinga
		// segun la cedula
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		// Retorno de resultados
		return (List<Miembro>) criteria.list();
	}

}