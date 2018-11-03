package com.mev.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "COMUNIDAD")
public class Comunidad { //Las comunidades don los lugares físiscos donde toman lugar las reuniones
	@Id
	@GeneratedValue  //ID autogenerado por la base de datos
	private int comunidadId;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Distrito distrito;
	@Column
	private String nombre;
	@Column
	private String detalle;
	
	public Comunidad() {
		
	}
}
