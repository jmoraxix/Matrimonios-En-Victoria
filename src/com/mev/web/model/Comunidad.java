package com.mev.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "COMUNIDAD")
public class Comunidad { //Las comunidades don los lugares físiscos donde toman lugar las reuniones
	@Id
	@GeneratedValue  //ID autogenerado por la base de datos
	private int comunidadId;
	@ManyToOne(optional = false)
	private Distrito distrito;
	@Column
	private String nombre;
	@Column
	private String detalle;
	
	public Comunidad() {
		
	}
	
	

	public Comunidad(int comunidadId, Distrito distrito, String nombre, String detalle) {
		super();
		this.comunidadId = comunidadId;
		this.distrito = distrito;
		this.nombre = nombre;
		this.detalle = detalle;
	}
	
	public Comunidad(Distrito distrito, String nombre, String detalle) {
		super();
		this.distrito = distrito;
		this.nombre = nombre;
		this.detalle = detalle;
	}



	public int getComunidadId() {
		return comunidadId;
	}

	public void setComunidadId(int comunidadId) {
		this.comunidadId = comunidadId;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
}
