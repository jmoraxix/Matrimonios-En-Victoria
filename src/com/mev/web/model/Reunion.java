package com.mev.web.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REUNION")
public class Reunion {
	@Id
	@GeneratedValue // ID autogenerado por la base de datos
	private int reunionId;
	@ManyToOne(optional = false)
	private Grupo grupo;
	@ManyToOne(optional = false)
	private Comunidad comunidad;
	@Column
	private Date fecha;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ASISTENCIA")
	private Collection<Miembro> asistentes = new ArrayList<Miembro>();

	public String fechaFormateada() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return df.format(this.fecha);
	}

	public int getReunionId() {
		return reunionId;
	}

	@Override
	public String toString() {
		return "Reunion [reunionId=" + reunionId + ", grupo=" + grupo + ", comunidad=" + comunidad + ", fecha=" + fecha
				+ ", asistentes=" + asistentes + "]";
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
