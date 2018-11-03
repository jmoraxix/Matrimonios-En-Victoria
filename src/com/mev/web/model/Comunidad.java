package com.mev.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "COMUNIDAD")
public class Comunidad {
	@Id
	private int comunidadId;
	@Column
	private Distrito ubicacion;
	@Column
	private String comunidad;
	
public Comunidad() {
	
}

public Comunidad(int comunidadId,Distrito ubicacion,String comunidad) {
	this.comunidadId = comunidadId;
	this.ubicacion = ubicacion;
	this.comunidad = comunidad;
}

public int getComunidadId() {
	return comunidadId;
}

public void setComunidadId(int comunidadId) {
	this.comunidadId = comunidadId;
}

public Distrito getUbicacion() {
	return ubicacion;
}

public void setUbicacion(Distrito ubicacion) {
	this.ubicacion = ubicacion;
}

public String getComunidad() {
	return comunidad;
}

public void setComunidad(String comunidad) {
	this.comunidad = comunidad;
}

@Override
public String toString() {
	return "Comunidad [comunidadId=" + comunidadId + ", ubicacion=" + ubicacion + ", comunidad=" + comunidad + "]";
}


}
