package com.mev.web.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROVINCIA")

public class Provincia {
	@Id
	@GeneratedValue // ID autogenerado por la base de datos
	private int provinciaId;
	@Column
	private String nombre;
	// Una provincia tiene varios cantones, en la calase canton la provincia aparece
	// como "provincia"
	@OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Canton> cantones;

	@Override
	public String toString() {
		return "Nombre: " + nombre + "| Id: " + provinciaId;
	}

	public int getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia(int provinciaId, String nombre) {
		super();
		this.provinciaId = provinciaId;
		this.nombre = nombre;
	}

	public Provincia(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Provincia() {
		super();
	}

	public Set<Canton> getCanton() {
		return cantones;
	}

	public void setCanton(Set<Canton> canton) {
		this.cantones = canton;
	}
}
