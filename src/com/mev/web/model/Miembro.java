package com.mev.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MIEMBRO")
public class Miembro {
	@Id
	private String cedula;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private Date fechaNacimiento;
	@Column
	private String detalleDireccion;
	@Column
	private String Sexo;

	public Miembro() {
		super();
	}

	public Miembro(String cedula, String nombre, String apellido, Date fechaNacimiento, String detalleDireccion,
			String sexo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.detalleDireccion = detalleDireccion;
		this.Sexo = sexo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDetalleDireccion() {
		return detalleDireccion;
	}

	public void setDetalleDireccion(String detalleDireccion) {
		this.detalleDireccion = detalleDireccion;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

}