package com.mev.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REUNION")
public class Reunion {
	@Id
	@GeneratedValue // ID autogenerado por la base de datos
	private int reunionId;
	@Column
	private Grupo grupo;
	@Column
	private Comunidad comunidad;
	@Column
	private Date fecha;
	@ManyToMany
	private Collection<Miembro> asistentes = new ArrayList<Miembro>();

	public int getReunionId() {
		return reunionId;
	}

	public void setReunionId(int reunionId) {
		this.reunionId = reunionId;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Comunidad getComunidad() {
		return comunidad;
	}

	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Collection<Miembro> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(Collection<Miembro> asistentes) {
		this.asistentes = asistentes;
	}
}
