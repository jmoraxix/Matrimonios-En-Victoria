package com.mev.web.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "GRUPO")

public class Grupo {
	@Id
	@GeneratedValue  //ID autogenerado por la base de datos
	private int grupoId;
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reunion> reuniones;	
	
	public Set<Reunion> getReuniones() {
		return reuniones;
	}
	public void setReuniones(Set<Reunion> reuniones) {
		this.reuniones = reuniones;
	}
	public int getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Grupo(int grupoId, String nombre) {
		super();
		this.grupoId = grupoId;
		this.nombre = nombre;
	}
	public Grupo() {
		super();
	}
}
