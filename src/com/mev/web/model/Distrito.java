package com.mev.web.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
@Entity
@Table(name = "DISTRITO")
public class Distrito {
	@Id
	@GeneratedValue //ID autogenerado por la base de datos
	private int distritoId;
	@Column
	private String nombre;
	
	//Varios distritos tienen un sol canton
	@ManyToOne(optional = false)
	private Canton canton;
	
	public Distrito() {
		
	}

	public Distrito(String nombre, Canton canton) {
		super();
		this.nombre = nombre;
		this.canton = canton;
	}

	public int getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(int distritoId) {
		this.distritoId = distritoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	
	
}
