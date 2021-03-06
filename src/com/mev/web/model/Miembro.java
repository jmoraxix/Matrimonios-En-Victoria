package com.mev.web.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MIEMBRO")
// @Inheritance(strategy=InheritanceType.JOINED)
public class Miembro {
	@Id
	private String cedula;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@Column
	private String detalleDireccion;
	@Column
	private String Sexo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "miembro")
	private Usuario usuario;

	// Varios miebros pueden ir a varias reuniones
	@ManyToMany(mappedBy = "asistentes")
	private Set<Reunion> reuniones;

	public Set<Reunion> getReuniones() {
		return reuniones;
	}

	public void setReuniones(Set<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Miembro() {
		// super();
	}

	public Miembro(String cedula, String nombre, String apellido, Date fechaNacimiento, String detalleDireccion,
			String sexo) {
		// super();
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

	@Override
	public String toString() {
		return "Miembro [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", detalleDireccion=" + detalleDireccion + ", Sexo=" + Sexo + "]";
	}

	@Override
	public boolean equals(Object miembro) {
		// TODO Auto-generated method stub
		return (((Miembro) miembro).getCedula().equals(this.getCedula()));
	}

}
