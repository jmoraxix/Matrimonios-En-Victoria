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
@Table(name = "CANTON")

public class Canton {
	@Id
	@GeneratedValue  //ID autogenerado por la base de datos
	private int cantonId;
	@Column
	private String nombre;
	//Varios cantones tienen una sola provincia
	@ManyToOne(optional = false)
	private Provincia provincia;
	
	//Un canton tiene varios distritos, en la clase distrito el canton aparece como "canton"
	@OneToMany(mappedBy = "canton", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Distrito> distritos;
	
	public int getCantonId() {
		return cantonId;
	}
	public void setCantonId(int cantonId) {
		this.cantonId = cantonId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Canton(int cantonId, String nombre, Provincia provincia) {
		super();
		this.cantonId = cantonId;
		this.nombre = nombre;
		this.provincia = provincia;
	}
	public Canton(String nombre, Provincia provincia) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
	}
	public Canton() {
		super();
	}
	public Set<Distrito> getDistritos() {
		return distritos;
	}
	public void setDistritos(Set<Distrito> distritos) {
		this.distritos = distritos;
	}
	
	@Override
	public String toString() {
		return "nombre: " + nombre + " | Provincia " + provincia;
	}
}
